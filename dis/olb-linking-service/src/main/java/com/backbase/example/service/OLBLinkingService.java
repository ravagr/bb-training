package com.backbase.example.service;

import com.backbase.account.rest.spec.v1.account.*;

import com.backbase.example.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.backbase.integration.arrangement.rest.spec.v2.arrangements.ArrangementsPostRequestBody;
import com.backbase.arrangement.integration.rest.spec.v2.arrangements.ArrangementsPostResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class OLBLinkingService {

    private String ALL = "ALL";
    private String ADMIN = "admin";
    private String BANKEXTERNAL = "Bank_External";
    private String PRODUCTSUMMARYBF = "1006";

    private String VIEWPRIVILEGE = "view";

    @Qualifier(value = "customRestTemplateForOlb")
    private final RestTemplate restTemplate;
    @Value("${olb.url.accountConsent}")
    private String accountConsentUrl;
    @Value("${olb.url.accountConsentAuthorization}")
    private String accountConsentAuthorizationUrl;

    @Value("${backbase.url.arrangement}")
    private String olbArrangementCreateUrl;

    @Value("${backbase.url.datagroupSearch}")
    private String dataGroupSearchUrl;

    @Value("${backbase.url.dataGroupCreate}")
    private String createDataGroupUrl;

    @Value("${backbase.url.dataGroupUpdate}")
    private String dataGroupUpdateUrl;

    @Value("${backbase.url.createFunctionGroup}")
    private String createFGUrl;

    public ConsentPostResponseBody postConsent(ConsentPostRequestBody consentPostRequestBody) {
        return restTemplate.postForObject(accountConsentUrl, consentPostRequestBody, ConsentPostResponseBody.class);
    }

    public void getAuthorization(String consentId) {

        AuthorizationResponse authorizationResponse = restTemplate.exchange(accountConsentAuthorizationUrl, HttpMethod.GET, generateHeaders(), new ParameterizedTypeReference<AuthorizationResponse>() {
        }, consentId).getBody();
        if (0 == authorizationResponse.getStatus()) {
            System.out.println("Success from Fin agency");
        } else {
            System.out.println("Error response from Fin agency");
        }

    }


    public void postAuthorization(String consentId, AuthorizationPostRequestBody authorizationPostRequestBody) {
        AuthorizationPostResponseBody authorizationPostResponseBody = restTemplate.postForObject(accountConsentAuthorizationUrl, authorizationPostRequestBody, AuthorizationPostResponseBody.class, consentId);
        if (0 == authorizationPostResponseBody.getStatus()) {
            System.out.println("Success from Fin agency");
            ArrangementsPostResponseBody arrangementsPostResponseBody = createArrangementOlb(consentId, authorizationPostRequestBody);
            System.out.println("Success from Fin agency");
            addNewArrangementInDataGroup(arrangementsPostResponseBody.getId());
            // createAllDataGroupForOlb(arrangementsPostResponseBody.getId());
            System.out.println("Success from Fin agency after data search");
        } else {
            System.out.println("Error response from Fin agency");
        }

    }

    private ArrangementsPostResponseBody createArrangementOlb(String consentId, AuthorizationPostRequestBody authorizationPostRequestBody) {
        Set<String> legalEntityId = new HashSet<String>();
        legalEntityId.add("Bank");
        ArrangementsPostRequestBody arrangementsPostRequestBody = new ArrangementsPostRequestBody();
        arrangementsPostRequestBody.setProductId("productId2");
        arrangementsPostRequestBody.setLegalEntityIds(legalEntityId);
        arrangementsPostRequestBody.setId(consentId + System.currentTimeMillis());
        arrangementsPostRequestBody.setName(authorizationPostRequestBody.getBban() + " name");
        arrangementsPostRequestBody.setBankAlias(authorizationPostRequestBody.getBban());
        arrangementsPostRequestBody.setBBAN(authorizationPostRequestBody.getBban());
        arrangementsPostRequestBody.setCurrency("EUR");
        arrangementsPostRequestBody.setBIC(authorizationPostRequestBody.getBic());
        arrangementsPostRequestBody.setNumber(authorizationPostRequestBody.getMobileNumber());
        return restTemplate.postForObject(olbArrangementCreateUrl, arrangementsPostRequestBody, ArrangementsPostResponseBody.class);
    }

    private void addNewArrangementInDataGroup(String arrangementId) {

        IntegrationGetDataGroupsRequest integrationGetDataGroupsRequest = new IntegrationGetDataGroupsRequest();
        ServiceAgreementIdentifier serviceAgreementIdentifier = new ServiceAgreementIdentifier();
        serviceAgreementIdentifier.setExternalIdIdentifier("Bank_External");
        integrationGetDataGroupsRequest.setServiceAgreementIdentifier(serviceAgreementIdentifier);
        IntegrationItemIdentifier integrationItemIdentifier = new IntegrationItemIdentifier();
        integrationGetDataGroupsRequest.setDataItemIdentifier(integrationItemIdentifier);
        HttpEntity<IntegrationGetDataGroupsRequest> request = new HttpEntity<IntegrationGetDataGroupsRequest>(integrationGetDataGroupsRequest);
        ResponseEntity<List<IntegrationServiceAgreementWithDataGroupsItem>> response = restTemplate.exchange(
                dataGroupSearchUrl,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<List<IntegrationServiceAgreementWithDataGroupsItem>>() {
                }, "ARRANGEMENTS");
        if (response != null && response.getBody().size() > 0 && response.getBody().get(0).getDataGroups() != null) {
            List<IntegrationDataGroupDetails> integrationDataGroupDetailList = response.getBody().get(0).getDataGroups();
            IntegrationDataGroupDetails integrationDataGroupDetails = integrationDataGroupDetailList.stream()
                    .filter(integrationDataGroupDetail -> ALL.equals(integrationDataGroupDetail.getName()))
                    .findFirst()
                    .orElse(null);
            System.out.println("" + integrationDataGroupDetails);

            if (integrationDataGroupDetails != null) {
                updateDataGroup(integrationDataGroupDetails, arrangementId);
            } else {
                createAllDataGroupForOlb(arrangementId);
            }

        } else {
            createAllDataGroupForOlb(arrangementId);
        }

    }

    private void createAllDataGroupForOlb(String arrangementId) {
        IntegrationDataGroupCreate integrationDataGroupCreate = new IntegrationDataGroupCreate();
        integrationDataGroupCreate.setName(ALL);
        integrationDataGroupCreate.setDescription(ALL);
        integrationDataGroupCreate.setType("ARRANGEMENTS");
        IntegrationItemIdentifier integrationItemIdentifier = new IntegrationItemIdentifier();
        integrationItemIdentifier.setInternalIdIdentifier(arrangementId);
        List<IntegrationItemIdentifier> integrationItemIdentifierList = new ArrayList<IntegrationItemIdentifier>();
        integrationItemIdentifierList.add(integrationItemIdentifier);
        integrationDataGroupCreate.setDataItems(integrationItemIdentifierList);

        integrationDataGroupCreate.setExternalServiceAgreementId("Bank_External");
        List<IntegrationDataGroupCreate> integrationDataGroupCreateList = new ArrayList<IntegrationDataGroupCreate>();
        integrationDataGroupCreateList.add(integrationDataGroupCreate);
        HttpEntity<List<IntegrationDataGroupCreate>> request = new HttpEntity<List<IntegrationDataGroupCreate>>(integrationDataGroupCreateList);

        ResponseEntity<List<BatchResponseItemExtended>> response = restTemplate.exchange(
                createDataGroupUrl,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<List<BatchResponseItemExtended>>() {
                });

        System.out.println("" + response);
        // String fgId = createFunctionGroup();
    }


    private void updateDataGroup(IntegrationDataGroupDetails integrationDataGroupDetail, String arrangementId) {

        IntegrationDataGroupIdentifier integrationDataGroupIdentifier = new IntegrationDataGroupIdentifier();
        integrationDataGroupIdentifier.setIdIdentifier(integrationDataGroupDetail.getId());

        IntegrationDataGroupItemPutRequestBody integrationDataGroupItemPutRequestBody = new IntegrationDataGroupItemPutRequestBody();
        integrationDataGroupItemPutRequestBody.setDataGroupIdentifier(integrationDataGroupIdentifier);
        integrationDataGroupItemPutRequestBody.setAction(IntegrationAction.ADD);
        integrationDataGroupItemPutRequestBody.setType("ARRANGEMENTS");

        IntegrationItemIdentifier integrationItemIdentifier = new IntegrationItemIdentifier();
        integrationItemIdentifier.setInternalIdIdentifier(arrangementId);
        List<IntegrationItemIdentifier> integrationItemIdentifierList = new ArrayList<IntegrationItemIdentifier>();
        integrationItemIdentifierList.add(integrationItemIdentifier);
        integrationDataGroupItemPutRequestBody.setDataItems(integrationItemIdentifierList);
        List<IntegrationDataGroupItemPutRequestBody> integrationDataGroupItemPutRequestBodyList = new ArrayList<IntegrationDataGroupItemPutRequestBody>();
        integrationDataGroupItemPutRequestBodyList.add(integrationDataGroupItemPutRequestBody);
        HttpEntity<List<IntegrationDataGroupItemPutRequestBody>> request = new HttpEntity<List<IntegrationDataGroupItemPutRequestBody>>(integrationDataGroupItemPutRequestBodyList);
        ResponseEntity<List<BatchResponseItemExtended>> response = restTemplate.exchange(
                dataGroupUpdateUrl,
                HttpMethod.PUT,
                request,
                new ParameterizedTypeReference<List<BatchResponseItemExtended>>() {
                });
        System.out.println("Response is " + response);

    }

    private String createFunctionGroup() {
        FunctionGroupItem functionGroupItem = new FunctionGroupItem();
        functionGroupItem.setName(ADMIN + "fg");
        functionGroupItem.setDescription(ADMIN);
        functionGroupItem.setServiceAgreementId(BANKEXTERNAL);


        Permission permission = new Permission();
        permission.setFunctionId(PRODUCTSUMMARYBF);
        Privilege privilege = new Privilege();
        privilege.setPrivilege(VIEWPRIVILEGE);
        List<Privilege> privilegeList = new ArrayList<Privilege>();
        privilegeList.add(privilege);
        permission.setAssignedPrivileges(privilegeList);
        List<Permission> permissionList = new ArrayList<Permission>();
        permissionList.add(permission);
        functionGroupItem.setPermissions(permissionList);


        HttpEntity<FunctionGroupItem> request = new HttpEntity<FunctionGroupItem>(functionGroupItem);
        ResponseEntity<FunctionGroupPostResponseBody> response = restTemplate.exchange(
                createFGUrl,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<FunctionGroupPostResponseBody>() {
                });

        return (response.getBody().getId());

    }

    private HttpEntity generateHeaders() {
        log.info("Creating HttpEntity");
        HttpHeaders httpHeaders = new HttpHeaders();
        return new HttpEntity(httpHeaders);
    }
}

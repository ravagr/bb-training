package com.backbase.example;
import com.backbase.account.rest.spec.v1.account.*;

import com.backbase.example.service.OLBLinkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping({"/client-api/v1/account"})
@RestController
@RequiredArgsConstructor
public class OLBLinkingController implements AccountApi {

    @Autowired
    private OLBLinkingService olbLinkingService;

    @Override
    public ConsentGetResponseBody getConsent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return null;
    }

    @Override
    public ConsentPostResponseBody postConsent(ConsentPostRequestBody consentPostRequestBody, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return olbLinkingService.postConsent(consentPostRequestBody);
    }

    @Override
    public AuthorizationPostResponseBody postAuthorization(AuthorizationPostRequestBody authorizationPostRequestBody, String consentId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("test123");
        olbLinkingService.postAuthorization(consentId, authorizationPostRequestBody);
        return null;
    }

    @Override
    public void getAuthorization(String consentId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("test123get");
        olbLinkingService.getAuthorization(consentId);
    }

}

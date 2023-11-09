package com.backbase.example.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.Valid;

public class IntegrationSearchDataGroupsRequest {
    @JsonProperty("serviceAgreementIdentifier")
    private ServiceAgreementIdentifier serviceAgreementIdentifier;
    @JsonProperty("dataItemIdentifier")
    private IntegrationItemIdentifier dataItemIdentifier;
    @JsonProperty("legalEntityIdentifier")
    private LegalEntityIdentifier legalEntityIdentifier;

    public IntegrationSearchDataGroupsRequest() {
    }

    public IntegrationSearchDataGroupsRequest serviceAgreementIdentifier(ServiceAgreementIdentifier serviceAgreementIdentifier) {
        this.serviceAgreementIdentifier = serviceAgreementIdentifier;
        return this;
    }

    @ApiModelProperty("")
    public @Valid ServiceAgreementIdentifier getServiceAgreementIdentifier() {
        return this.serviceAgreementIdentifier;
    }

    public void setServiceAgreementIdentifier(ServiceAgreementIdentifier serviceAgreementIdentifier) {
        this.serviceAgreementIdentifier = serviceAgreementIdentifier;
    }

    public IntegrationSearchDataGroupsRequest dataItemIdentifier(IntegrationItemIdentifier dataItemIdentifier) {
        this.dataItemIdentifier = dataItemIdentifier;
        return this;
    }

    @ApiModelProperty("")
    public @Valid IntegrationItemIdentifier getDataItemIdentifier() {
        return this.dataItemIdentifier;
    }

    public void setDataItemIdentifier(IntegrationItemIdentifier dataItemIdentifier) {
        this.dataItemIdentifier = dataItemIdentifier;
    }

    public IntegrationSearchDataGroupsRequest legalEntityIdentifier(LegalEntityIdentifier legalEntityIdentifier) {
        this.legalEntityIdentifier = legalEntityIdentifier;
        return this;
    }

    @ApiModelProperty("")
    public @Valid LegalEntityIdentifier getLegalEntityIdentifier() {
        return this.legalEntityIdentifier;
    }

    public void setLegalEntityIdentifier(LegalEntityIdentifier legalEntityIdentifier) {
        this.legalEntityIdentifier = legalEntityIdentifier;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            IntegrationSearchDataGroupsRequest integrationSearchDataGroupsRequest = (IntegrationSearchDataGroupsRequest)o;
            return Objects.equals(this.serviceAgreementIdentifier, integrationSearchDataGroupsRequest.serviceAgreementIdentifier) && Objects.equals(this.dataItemIdentifier, integrationSearchDataGroupsRequest.dataItemIdentifier) && Objects.equals(this.legalEntityIdentifier, integrationSearchDataGroupsRequest.legalEntityIdentifier);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.serviceAgreementIdentifier, this.dataItemIdentifier, this.legalEntityIdentifier});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IntegrationSearchDataGroupsRequest {\n");
        sb.append("    serviceAgreementIdentifier: ").append(this.toIndentedString(this.serviceAgreementIdentifier)).append("\n");
        sb.append("    dataItemIdentifier: ").append(this.toIndentedString(this.dataItemIdentifier)).append("\n");
        sb.append("    legalEntityIdentifier: ").append(this.toIndentedString(this.legalEntityIdentifier)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}


package com.backbase.example.model;



import com.backbase.buildingblocks.persistence.model.AdditionalPropertiesAware;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"serviceAgreementIdentifier", "dataItemIdentifier"})
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class IntegrationGetDataGroupsRequest implements AdditionalPropertiesAware {
    @JsonProperty("serviceAgreementIdentifier")
    private @Valid ServiceAgreementIdentifier serviceAgreementIdentifier;
    @JsonProperty("dataItemIdentifier")
    private @Valid IntegrationItemIdentifier dataItemIdentifier;
    @JsonProperty("legalEntityIdentifier")
    private LegalEntityIdentifier legalEntityIdentifier;
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> additions = new HashMap();

    public IntegrationGetDataGroupsRequest() {
    }

    @JsonProperty("serviceAgreementIdentifier")
    public ServiceAgreementIdentifier getServiceAgreementIdentifier() {
        return this.serviceAgreementIdentifier;
    }

    @JsonProperty("serviceAgreementIdentifier")
    public void setServiceAgreementIdentifier(ServiceAgreementIdentifier serviceAgreementIdentifier) {
        this.serviceAgreementIdentifier = serviceAgreementIdentifier;
    }

    public IntegrationGetDataGroupsRequest withServiceAgreementIdentifier(ServiceAgreementIdentifier serviceAgreementIdentifier) {
        this.serviceAgreementIdentifier = serviceAgreementIdentifier;
        return this;
    }

    @JsonProperty("dataItemIdentifier")
    public IntegrationItemIdentifier getDataItemIdentifier() {
        return this.dataItemIdentifier;
    }

    @JsonProperty("dataItemIdentifier")
    public void setDataItemIdentifier(IntegrationItemIdentifier dataItemIdentifier) {
        this.dataItemIdentifier = dataItemIdentifier;
    }

    public IntegrationGetDataGroupsRequest withDataItemIdentifier(IntegrationItemIdentifier dataItemIdentifier) {
        this.dataItemIdentifier = dataItemIdentifier;
        return this;
    }

    @JsonProperty("legalEntityExternalId")
    public LegalEntityIdentifier getLegalEntityIdentifier() {
        return this.legalEntityIdentifier;
    }

    @JsonProperty("legalEntityExternalId")
    public void setLegalEntityIdentifier(LegalEntityIdentifier legalEntityIdentifier) {
        this.legalEntityIdentifier = legalEntityIdentifier;
    }

    public IntegrationGetDataGroupsRequest withLegalEntityIdentifier(LegalEntityIdentifier legalEntityIdentifier) {
        this.legalEntityIdentifier = legalEntityIdentifier;
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return (new HashCodeBuilder()).append(this.serviceAgreementIdentifier).append(this.dataItemIdentifier).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof IntegrationGetDataGroupsRequest)) {
            return false;
        } else {
            IntegrationGetDataGroupsRequest rhs = (IntegrationGetDataGroupsRequest)other;
            return (new EqualsBuilder()).append(this.serviceAgreementIdentifier, rhs.serviceAgreementIdentifier).append(this.dataItemIdentifier, rhs.dataItemIdentifier).isEquals();
        }
    }

    @JsonProperty("additions")
    public Map<String, String> getAdditions() {
        return this.additions;
    }

    @JsonProperty("additions")
    public void setAdditions(Map<String, String> additions) {
        this.additions = additions;
    }
}

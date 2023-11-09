package com.backbase.example.model;


import com.backbase.buildingblocks.persistence.model.AdditionalPropertiesAware;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"serviceAgreement", "dataGroups"})
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class IntegrationServiceAgreementWithDataGroups implements AdditionalPropertiesAware {
    @JsonProperty("serviceAgreement")
    private @Valid IntegrationServiceAgreementIds serviceAgreement;
    @JsonProperty("dataGroups")
    private @Valid List<IntegrationDataGroupDetails> dataGroups = new ArrayList();
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> additions = new HashMap();

    public IntegrationServiceAgreementWithDataGroups() {
    }

    @JsonProperty("serviceAgreement")
    public IntegrationServiceAgreementIds getServiceAgreement() {
        return this.serviceAgreement;
    }

    @JsonProperty("serviceAgreement")
    public void setServiceAgreement(IntegrationServiceAgreementIds serviceAgreement) {
        this.serviceAgreement = serviceAgreement;
    }

    public IntegrationServiceAgreementWithDataGroups withServiceAgreement(IntegrationServiceAgreementIds serviceAgreement) {
        this.serviceAgreement = serviceAgreement;
        return this;
    }

    @JsonProperty("dataGroups")
    public List<IntegrationDataGroupDetails> getDataGroups() {
        return this.dataGroups;
    }

    @JsonProperty("dataGroups")
    public void setDataGroups(List<IntegrationDataGroupDetails> dataGroups) {
        this.dataGroups = dataGroups;
    }

    public IntegrationServiceAgreementWithDataGroups withDataGroups(List<IntegrationDataGroupDetails> dataGroups) {
        this.dataGroups = dataGroups;
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return (new HashCodeBuilder()).append(this.serviceAgreement).append(this.dataGroups).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof IntegrationServiceAgreementWithDataGroups)) {
            return false;
        } else {
            IntegrationServiceAgreementWithDataGroups rhs = (IntegrationServiceAgreementWithDataGroups)other;
            return (new EqualsBuilder()).append(this.serviceAgreement, rhs.serviceAgreement).append(this.dataGroups, rhs.dataGroups).isEquals();
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
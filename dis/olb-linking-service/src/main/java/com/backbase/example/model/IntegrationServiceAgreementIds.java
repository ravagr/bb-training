package com.backbase.example.model;


import com.backbase.buildingblocks.persistence.model.AdditionalPropertiesAware;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "externalId"})
public class IntegrationServiceAgreementIds implements AdditionalPropertiesAware {
    @JsonProperty("id")
    private @Pattern(
            regexp = "^[0-9a-f]{32}$|^[0-9a-f-]{36}$"
    ) @Size(
            min = 1,
            max = 36
    ) String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("externalId")
    private @Pattern(
            regexp = "^[^\\r\\n]{1,64}$"
    ) @Size(
            min = 1,
            max = 64
    ) String externalId;
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> additions = new HashMap();

    public IntegrationServiceAgreementIds() {
    }

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public IntegrationServiceAgreementIds withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public IntegrationServiceAgreementIds withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("externalId")
    public String getExternalId() {
        return this.externalId;
    }

    @JsonProperty("externalId")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public IntegrationServiceAgreementIds withExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return (new HashCodeBuilder()).append(this.id).append(this.name).append(this.externalId).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof IntegrationServiceAgreementIds)) {
            return false;
        } else {
            IntegrationServiceAgreementIds rhs = (IntegrationServiceAgreementIds)other;
            return (new EqualsBuilder()).append(this.id, rhs.id).append(this.name, rhs.name).append(this.externalId, rhs.externalId).isEquals();
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
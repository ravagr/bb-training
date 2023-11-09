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
@JsonPropertyOrder({"id", "name", "description"})
public class IntegrationDataGroupDetails implements AdditionalPropertiesAware {
    @JsonProperty("id")
    private @Pattern(
            regexp = "^[0-9a-f]{32}$|^[0-9a-f-]{36}$"
    ) @Size(
            min = 1,
            max = 36
    ) String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> additions = new HashMap();
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> metadata = new HashMap();

    public IntegrationDataGroupDetails() {
    }

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public IntegrationDataGroupDetails withId(String id) {
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

    public IntegrationDataGroupDetails withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return this.description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public IntegrationDataGroupDetails withDescription(String description) {
        this.description = description;
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return (new HashCodeBuilder()).append(this.id).append(this.name).append(this.description).append(this.additions).append(this.metadata).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof IntegrationDataGroupDetails)) {
            return false;
        } else {
            IntegrationDataGroupDetails rhs = (IntegrationDataGroupDetails)other;
            return (new EqualsBuilder()).append(this.id, rhs.id).append(this.name, rhs.name).append(this.description, rhs.description).append(this.additions, rhs.additions).append(this.metadata, rhs.metadata).isEquals();
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

    @JsonProperty("metadata")
    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}

package com.backbase.example.model;

import com.backbase.buildingblocks.persistence.model.AdditionalPropertiesAware;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"id"})
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class FunctionGroupPostResponseBody implements AdditionalPropertiesAware {
    @JsonProperty("id")
    private @Pattern(
            regexp = "^[0-9a-f]{32}$|^[0-9a-f-]{36}$"
    ) @Size(
            min = 1,
            max = 36
    ) @NotNull String id;
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> additions = new HashMap();

    public FunctionGroupPostResponseBody() {
    }

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public FunctionGroupPostResponseBody withId(String id) {
        this.id = id;
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return (new HashCodeBuilder()).append(this.id).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof FunctionGroupPostResponseBody)) {
            return false;
        } else {
            FunctionGroupPostResponseBody rhs = (FunctionGroupPostResponseBody)other;
            return (new EqualsBuilder()).append(this.id, rhs.id).isEquals();
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
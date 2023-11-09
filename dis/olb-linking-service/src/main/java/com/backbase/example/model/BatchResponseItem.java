package com.backbase.example.model;

import com.backbase.buildingblocks.persistence.model.AdditionalPropertiesAware;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"resourceId", "status", "errors"})
public class BatchResponseItem implements AdditionalPropertiesAware {
    @JsonProperty("resourceId")
    private @Size(
            min = 1
    ) @NotNull String resourceId;
    @JsonProperty("status")
    private @NotNull BatchResponseStatusCode status;
    @JsonProperty("errors")
    private @Valid List<Error> errors = new ArrayList();
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> additions = new HashMap();

    public BatchResponseItem() {
    }

    @JsonProperty("resourceId")
    public String getResourceId() {
        return this.resourceId;
    }

    @JsonProperty("resourceId")
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public BatchResponseItem withResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    @JsonProperty("status")
    public BatchResponseStatusCode getStatus() {
        return this.status;
    }

    @JsonProperty("status")
    public void setStatus(BatchResponseStatusCode status) {
        this.status = status;
    }

    public BatchResponseItem withStatus(BatchResponseStatusCode status) {
        this.status = status;
        return this;
    }

    @JsonProperty("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public BatchResponseItem withErrors(List<Error> errors) {
        this.errors = errors;
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return (new HashCodeBuilder()).append(this.resourceId).append(this.status).append(this.errors).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof BatchResponseItem)) {
            return false;
        } else {
            BatchResponseItem rhs = (BatchResponseItem)other;
            return (new EqualsBuilder()).append(this.resourceId, rhs.resourceId).append(this.status, rhs.status).append(this.errors, rhs.errors).isEquals();
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

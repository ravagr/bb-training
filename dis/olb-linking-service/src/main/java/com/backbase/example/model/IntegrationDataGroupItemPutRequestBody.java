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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"dataGroupIdentifier", "action", "type", "dataItems"})
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class IntegrationDataGroupItemPutRequestBody implements AdditionalPropertiesAware {
    @JsonProperty("dataGroupIdentifier")
    private @Valid @NotNull IntegrationDataGroupIdentifier dataGroupIdentifier;
    @JsonProperty("action")
    private @NotNull IntegrationAction action;
    @JsonProperty("type")
    private @Pattern(
            regexp = "^\\S+$"
    ) @Size(
            min = 1,
            max = 36
    ) @NotNull String type;
    @JsonProperty("dataItems")
    private @Valid List<IntegrationItemIdentifier> dataItems = new ArrayList();
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> additions = new HashMap();

    public IntegrationDataGroupItemPutRequestBody() {
    }

    @JsonProperty("dataGroupIdentifier")
    public IntegrationDataGroupIdentifier getDataGroupIdentifier() {
        return this.dataGroupIdentifier;
    }

    @JsonProperty("dataGroupIdentifier")
    public void setDataGroupIdentifier(IntegrationDataGroupIdentifier dataGroupIdentifier) {
        this.dataGroupIdentifier = dataGroupIdentifier;
    }

    public IntegrationDataGroupItemPutRequestBody withDataGroupIdentifier(IntegrationDataGroupIdentifier dataGroupIdentifier) {
        this.dataGroupIdentifier = dataGroupIdentifier;
        return this;
    }

    @JsonProperty("action")
    public IntegrationAction getAction() {
        return this.action;
    }

    @JsonProperty("action")
    public void setAction(IntegrationAction action) {
        this.action = action;
    }

    public IntegrationDataGroupItemPutRequestBody withAction(IntegrationAction action) {
        this.action = action;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public IntegrationDataGroupItemPutRequestBody withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("dataItems")
    public List<IntegrationItemIdentifier> getDataItems() {
        return this.dataItems;
    }

    @JsonProperty("dataItems")
    public void setDataItems(List<IntegrationItemIdentifier> dataItems) {
        this.dataItems = dataItems;
    }

    public IntegrationDataGroupItemPutRequestBody withDataItems(List<IntegrationItemIdentifier> dataItems) {
        this.dataItems = dataItems;
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return (new HashCodeBuilder()).append(this.dataGroupIdentifier).append(this.action).append(this.type).append(this.dataItems).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof IntegrationDataGroupItemPutRequestBody)) {
            return false;
        } else {
            IntegrationDataGroupItemPutRequestBody rhs = (IntegrationDataGroupItemPutRequestBody)other;
            return (new EqualsBuilder()).append(this.dataGroupIdentifier, rhs.dataGroupIdentifier).append(this.action, rhs.action).append(this.type, rhs.type).append(this.dataItems, rhs.dataItems).isEquals();
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
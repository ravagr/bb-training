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
@JsonPropertyOrder({"name", "description", "type", "dataGroupIdentifier", "dataItems"})
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class IntegrationDataGroupItemBatchPutRequestBody implements AdditionalPropertiesAware {
    @JsonProperty("name")
    private @Size(
            min = 1,
            max = 128
    ) @NotNull String name;
    @JsonProperty("description")
    private @Pattern(
            regexp = "^(\\S|\\n)((.|\\n)*(\\S|\\n))?$"
    ) @Size(
            min = 1,
            max = 255
    ) @NotNull String description;
    @JsonProperty("type")
    private @Pattern(
            regexp = "^\\S+$"
    ) @Size(
            min = 1,
            max = 36
    ) @NotNull String type;
    @JsonProperty("dataGroupIdentifier")
    private @Valid @NotNull IntegrationDataGroupIdentifier dataGroupIdentifier;
    @JsonProperty("dataItems")
    private @Valid List<IntegrationItemIdentifier> dataItems = new ArrayList();
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> additions = new HashMap();
/*    @AllowedMetadata(
            type = MetadataType.DATA_GROUP_META_DATA
    )*/
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> metadata = null;

    public IntegrationDataGroupItemBatchPutRequestBody() {
    }

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public IntegrationDataGroupItemBatchPutRequestBody withName(String name) {
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

    public IntegrationDataGroupItemBatchPutRequestBody withDescription(String description) {
        this.description = description;
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

    public IntegrationDataGroupItemBatchPutRequestBody withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("dataGroupIdentifier")
    public IntegrationDataGroupIdentifier getDataGroupIdentifier() {
        return this.dataGroupIdentifier;
    }

    @JsonProperty("dataGroupIdentifier")
    public void setDataGroupIdentifier(IntegrationDataGroupIdentifier dataGroupIdentifier) {
        this.dataGroupIdentifier = dataGroupIdentifier;
    }

    public IntegrationDataGroupItemBatchPutRequestBody withDataGroupIdentifier(IntegrationDataGroupIdentifier dataGroupIdentifier) {
        this.dataGroupIdentifier = dataGroupIdentifier;
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

    public IntegrationDataGroupItemBatchPutRequestBody withDataItems(List<IntegrationItemIdentifier> dataItems) {
        this.dataItems = dataItems;
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return (new HashCodeBuilder()).append(this.name).append(this.description).append(this.type).append(this.dataGroupIdentifier).append(this.dataItems).append(this.additions).append(this.metadata).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof IntegrationDataGroupItemBatchPutRequestBody)) {
            return false;
        } else {
            IntegrationDataGroupItemBatchPutRequestBody rhs = (IntegrationDataGroupItemBatchPutRequestBody)other;
            return (new EqualsBuilder()).append(this.name, rhs.name).append(this.description, rhs.description).append(this.type, rhs.type).append(this.dataGroupIdentifier, rhs.dataGroupIdentifier).append(this.dataItems, rhs.dataItems).append(this.additions, rhs.additions).append(this.metadata, rhs.metadata).isEquals();
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
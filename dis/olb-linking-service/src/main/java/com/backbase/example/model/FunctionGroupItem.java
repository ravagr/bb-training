package com.backbase.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ApiModel(
        description = "Function group item"
)
@JsonPropertyOrder({"additions", "id", "serviceAgreementId", "name", "description", "type", "permissions", "validFrom", "validUntil", "approvalId", "metadata"})
public class FunctionGroupItem {
    public static final String JSON_PROPERTY_ADDITIONS = "additions";
    private Map<String, String> additions = null;
    public static final String JSON_PROPERTY_ID = "id";
    private String id;
    public static final String JSON_PROPERTY_SERVICE_AGREEMENT_ID = "serviceAgreementId";
    private String serviceAgreementId;
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;
    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;
    public static final String JSON_PROPERTY_TYPE = "type";
    private TypeEnum type;
    public static final String JSON_PROPERTY_PERMISSIONS = "permissions";
    private List<Permission> permissions = null;
    public static final String JSON_PROPERTY_VALID_FROM = "validFrom";
    private Date validFrom;
    public static final String JSON_PROPERTY_VALID_UNTIL = "validUntil";
    private Date validUntil;
    public static final String JSON_PROPERTY_APPROVAL_ID = "approvalId";
    private String approvalId;
    public static final String JSON_PROPERTY_METADATA = "metadata";
    private Map<String, String> metadata = null;

    public FunctionGroupItem() {
    }

    public FunctionGroupItem additions(Map<String, String> additions) {
        this.additions = additions;
        return this;
    }

    public FunctionGroupItem putAdditionsItem(String key, String additionsItem) {
        if (this.additions == null) {
            this.additions = new HashMap();
        }

        this.additions.put(key, additionsItem);
        return this;
    }

    @Nullable
    @ApiModelProperty("")
    @JsonProperty("additions")
    @JsonInclude(Include.USE_DEFAULTS)
    public Map<String, String> getAdditions() {
        return this.additions;
    }

    public void setAdditions(Map<String, String> additions) {
        this.additions = additions;
    }

    public FunctionGroupItem id(String id) {
        this.id = id;
        return this;
    }

    @Nullable
    @ApiModelProperty("Universally Unique Identifier.")
    @JsonProperty("id")
    @JsonInclude(Include.USE_DEFAULTS)
    public @Pattern(
            regexp = "^[0-9a-f]{32}$|^[0-9a-f-]{36}$"
    ) String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FunctionGroupItem serviceAgreementId(String serviceAgreementId) {
        this.serviceAgreementId = serviceAgreementId;
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = "Universally Unique Identifier."
    )
    @JsonProperty("serviceAgreementId")
    @JsonInclude(Include.ALWAYS)
    public @NotNull @Pattern(
            regexp = "^[0-9a-f]{32}$|^[0-9a-f-]{36}$"
    ) String getServiceAgreementId() {
        return this.serviceAgreementId;
    }

    public void setServiceAgreementId(String serviceAgreementId) {
        this.serviceAgreementId = serviceAgreementId;
    }

    public FunctionGroupItem name(String name) {
        this.name = name;
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = "Name of function group"
    )
    @JsonProperty("name")
    @JsonInclude(Include.ALWAYS)
    public @NotNull String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FunctionGroupItem description(String description) {
        this.description = description;
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = "Description of function group"
    )
    @JsonProperty("description")
    @JsonInclude(Include.ALWAYS)
    public @NotNull String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FunctionGroupItem type(TypeEnum type) {
        this.type = type;
        return this;
    }

    @NotNull
    @ApiModelProperty(
            required = true,
            value = "Type of function group"
    )
    @JsonProperty("type")
    @JsonInclude(Include.ALWAYS)
    public @NotNull TypeEnum getType() {
        return this.type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public FunctionGroupItem permissions(List<Permission> permissions) {
        this.permissions = permissions;
        return this;
    }

    public FunctionGroupItem addPermissionsItem(Permission permissionsItem) {
        if (this.permissions == null) {
            this.permissions = new ArrayList();
        }

        this.permissions.add(permissionsItem);
        return this;
    }

    @Nullable
    @ApiModelProperty("Applicable permissions for the function group")
    @JsonProperty("permissions")
    @JsonInclude(Include.USE_DEFAULTS)
    public @Valid List<Permission> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public FunctionGroupItem validFrom(Date validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    @Nullable
    @ApiModelProperty("Start date and time of the function group.")
    @JsonProperty("validFrom")
    @JsonInclude(Include.USE_DEFAULTS)
    public @Valid Date getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public FunctionGroupItem validUntil(Date validUntil) {
        this.validUntil = validUntil;
        return this;
    }

    @Nullable
    @ApiModelProperty("End date and time of the function group.")
    @JsonProperty("validUntil")
    @JsonInclude(Include.USE_DEFAULTS)
    public @Valid Date getValidUntil() {
        return this.validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public FunctionGroupItem approvalId(String approvalId) {
        this.approvalId = approvalId;
        return this;
    }

    @Nullable
    @ApiModelProperty("Id of approval request.")
    @JsonProperty("approvalId")
    @JsonInclude(Include.USE_DEFAULTS)
    public @Size(
            min = 1,
            max = 36
    ) String getApprovalId() {
        return this.approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public FunctionGroupItem metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    public FunctionGroupItem putMetadataItem(String key, String metadataItem) {
        if (this.metadata == null) {
            this.metadata = new HashMap();
        }

        this.metadata.put(key, metadataItem);
        return this;
    }

    @Nullable
    @ApiModelProperty("Metadata for specific entities. Do not use it for custom extensions. Use additions instead.")
    @JsonProperty("metadata")
    @JsonInclude(Include.USE_DEFAULTS)
    public @Size(
            min = 0,
            max = 10
    ) Map<String, String> getMetadata() {
        return this.metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            FunctionGroupItem functionGroupItem = (FunctionGroupItem)o;
            return Objects.equals(this.additions, functionGroupItem.additions) && Objects.equals(this.id, functionGroupItem.id) && Objects.equals(this.serviceAgreementId, functionGroupItem.serviceAgreementId) && Objects.equals(this.name, functionGroupItem.name) && Objects.equals(this.description, functionGroupItem.description) && Objects.equals(this.type, functionGroupItem.type) && Objects.equals(this.permissions, functionGroupItem.permissions) && Objects.equals(this.validFrom, functionGroupItem.validFrom) && Objects.equals(this.validUntil, functionGroupItem.validUntil) && Objects.equals(this.approvalId, functionGroupItem.approvalId) && Objects.equals(this.metadata, functionGroupItem.metadata);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.additions, this.id, this.serviceAgreementId, this.name, this.description, this.type, this.permissions, this.validFrom, this.validUntil, this.approvalId, this.metadata});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FunctionGroupItem {\n");
        sb.append("    additions: ").append(this.toIndentedString(this.additions)).append("\n");
        sb.append("    id: ").append(this.toIndentedString(this.id)).append("\n");
        sb.append("    serviceAgreementId: ").append(this.toIndentedString(this.serviceAgreementId)).append("\n");
        sb.append("    name: ").append(this.toIndentedString(this.name)).append("\n");
        sb.append("    description: ").append(this.toIndentedString(this.description)).append("\n");
        sb.append("    type: ").append(this.toIndentedString(this.type)).append("\n");
        sb.append("    permissions: ").append(this.toIndentedString(this.permissions)).append("\n");
        sb.append("    validFrom: ").append(this.toIndentedString(this.validFrom)).append("\n");
        sb.append("    validUntil: ").append(this.toIndentedString(this.validUntil)).append("\n");
        sb.append("    approvalId: ").append(this.toIndentedString(this.approvalId)).append("\n");
        sb.append("    metadata: ").append(this.toIndentedString(this.metadata)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }

    public static enum TypeEnum {
        DEFAULT("DEFAULT"),
        SYSTEM("SYSTEM"),
        TEMPLATE("TEMPLATE");

        private String value;

        private TypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return this.value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }

        @JsonCreator
        public static TypeEnum fromValue(String value) {
            TypeEnum[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                TypeEnum b = var1[var3];
                if (b.value.equals(value)) {
                    return b;
                }
            }

            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }
}
package com.backbase.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@JsonPropertyOrder({"externalServiceAgreementId", "name", "dataGroupType"})
public class DataGroupNameIdentifier {
    public static final String JSON_PROPERTY_EXTERNAL_SERVICE_AGREEMENT_ID = "externalServiceAgreementId";
    private String externalServiceAgreementId;
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;
    public static final String JSON_PROPERTY_DATA_GROUP_TYPE = "dataGroupType";
    private String dataGroupType;

    public DataGroupNameIdentifier() {
    }

    public DataGroupNameIdentifier externalServiceAgreementId(String externalServiceAgreementId) {
        this.externalServiceAgreementId = externalServiceAgreementId;
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = "Id of Service Agreement on which entity belongs."
    )
    @JsonProperty("externalServiceAgreementId")
    @JsonInclude(Include.ALWAYS)
    public @NotNull @Pattern(
            regexp = "^\\S(.*(\\S))?$"
    ) @Size(
            min = 1,
            max = 64
    ) String getExternalServiceAgreementId() {
        return this.externalServiceAgreementId;
    }

    public void setExternalServiceAgreementId(String externalServiceAgreementId) {
        this.externalServiceAgreementId = externalServiceAgreementId;
    }

    public DataGroupNameIdentifier name(String name) {
        this.name = name;
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = "Entity name."
    )
    @JsonProperty("name")
    @JsonInclude(Include.ALWAYS)
    public @NotNull @Pattern(
            regexp = "^\\S(.*(\\S))?$"
    ) @Size(
            min = 1,
            max = 128
    ) String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataGroupNameIdentifier dataGroupType(String dataGroupType) {
        this.dataGroupType = dataGroupType;
        return this;
    }

    @Nullable
    @ApiModelProperty("Data group type")
    @JsonProperty("dataGroupType")
    @JsonInclude(Include.USE_DEFAULTS)
    public @Pattern(
            regexp = "^\\S+$"
    ) @Size(
            min = 1,
            max = 36
    ) String getDataGroupType() {
        return this.dataGroupType;
    }

    public void setDataGroupType(String dataGroupType) {
        this.dataGroupType = dataGroupType;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            DataGroupNameIdentifier dataGroupNameIdentifier = (DataGroupNameIdentifier)o;
            return Objects.equals(this.externalServiceAgreementId, dataGroupNameIdentifier.externalServiceAgreementId) && Objects.equals(this.name, dataGroupNameIdentifier.name) && Objects.equals(this.dataGroupType, dataGroupNameIdentifier.dataGroupType);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.externalServiceAgreementId, this.name, this.dataGroupType});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataGroupNameIdentifier {\n");
        sb.append("    externalServiceAgreementId: ").append(this.toIndentedString(this.externalServiceAgreementId)).append("\n");
        sb.append("    name: ").append(this.toIndentedString(this.name)).append("\n");
        sb.append("    dataGroupType: ").append(this.toIndentedString(this.dataGroupType)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}

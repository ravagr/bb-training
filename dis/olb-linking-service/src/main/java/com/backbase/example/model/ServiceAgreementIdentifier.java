package com.backbase.example.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ServiceAgreementIdentifier {
    @JsonProperty("idIdentifier")
    private String idIdentifier;
    @JsonProperty("nameIdentifier")
    private String nameIdentifier;
    @JsonProperty("externalIdIdentifier")
    private String externalIdIdentifier;

    public ServiceAgreementIdentifier() {
    }

    public ServiceAgreementIdentifier idIdentifier(String idIdentifier) {
        this.idIdentifier = idIdentifier;
        return this;
    }

    @ApiModelProperty("Internal Identifier.")
    public @Pattern(
            regexp = "^\\S(.*(\\S))?$"
    ) @Size(
            min = 1,
            max = 36
    ) String getIdIdentifier() {
        return this.idIdentifier;
    }

    public void setIdIdentifier(String idIdentifier) {
        this.idIdentifier = idIdentifier;
    }

    public ServiceAgreementIdentifier nameIdentifier(String nameIdentifier) {
        this.nameIdentifier = nameIdentifier;
        return this;
    }

    @ApiModelProperty("Service Agreement name.")
    public @Pattern(
            regexp = "^\\S(.*(\\S))?$"
    ) @Size(
            min = 1,
            max = 128
    ) String getNameIdentifier() {
        return this.nameIdentifier;
    }

    public void setNameIdentifier(String nameIdentifier) {
        this.nameIdentifier = nameIdentifier;
    }

    public ServiceAgreementIdentifier externalIdIdentifier(String externalIdIdentifier) {
        this.externalIdIdentifier = externalIdIdentifier;
        return this;
    }

    @ApiModelProperty("External service agreement Identifier.")
    public @Pattern(
            regexp = "^\\S(.*(\\S))?$"
    ) @Size(
            min = 1,
            max = 64
    ) String getExternalIdIdentifier() {
        return this.externalIdIdentifier;
    }

    public void setExternalIdIdentifier(String externalIdIdentifier) {
        this.externalIdIdentifier = externalIdIdentifier;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ServiceAgreementIdentifier serviceAgreementIdentifier = (ServiceAgreementIdentifier)o;
            return Objects.equals(this.idIdentifier, serviceAgreementIdentifier.idIdentifier) && Objects.equals(this.nameIdentifier, serviceAgreementIdentifier.nameIdentifier) && Objects.equals(this.externalIdIdentifier, serviceAgreementIdentifier.externalIdIdentifier);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.idIdentifier, this.nameIdentifier, this.externalIdIdentifier});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceAgreementIdentifier {\n");
        sb.append("    idIdentifier: ").append(this.toIndentedString(this.idIdentifier)).append("\n");
        sb.append("    nameIdentifier: ").append(this.toIndentedString(this.nameIdentifier)).append("\n");
        sb.append("    externalIdIdentifier: ").append(this.toIndentedString(this.externalIdIdentifier)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}

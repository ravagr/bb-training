package com.backbase.example.model;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class IntegrationItemIdentifier {
    @JsonProperty("internalIdIdentifier")
    private String internalIdIdentifier;
    @JsonProperty("externalIdIdentifier")
    private String externalIdIdentifier;

    public IntegrationItemIdentifier() {
    }

    public IntegrationItemIdentifier internalIdIdentifier(String internalIdIdentifier) {
        this.internalIdIdentifier = internalIdIdentifier;
        return this;
    }

    @ApiModelProperty("Internal Identifier")
    public @Size(
            min = 1,
            max = 36
    ) String getInternalIdIdentifier() {
        return this.internalIdIdentifier;
    }

    public void setInternalIdIdentifier(String internalIdIdentifier) {
        this.internalIdIdentifier = internalIdIdentifier;
    }

    public IntegrationItemIdentifier externalIdIdentifier(String externalIdIdentifier) {
        this.externalIdIdentifier = externalIdIdentifier;
        return this;
    }

    @ApiModelProperty("External Identifier.")
    public @Pattern(
            regexp = "^[^\\r\\n]{1,64}$"
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
            IntegrationItemIdentifier integrationItemIdentifier = (IntegrationItemIdentifier)o;
            return Objects.equals(this.internalIdIdentifier, integrationItemIdentifier.internalIdIdentifier) && Objects.equals(this.externalIdIdentifier, integrationItemIdentifier.externalIdIdentifier);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.internalIdIdentifier, this.externalIdIdentifier});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IntegrationItemIdentifier {\n");
        sb.append("    internalIdIdentifier: ").append(this.toIndentedString(this.internalIdIdentifier)).append("\n");
        sb.append("    externalIdIdentifier: ").append(this.toIndentedString(this.externalIdIdentifier)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}

package com.backbase.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.Size;

public class LegalEntityIdentifier {
    @JsonProperty("externalIdIdentifier")
    private String externalIdIdentifier;
    @JsonProperty("shares")
    private SharesEnum shares;

    public LegalEntityIdentifier() {
    }

    public SharesEnum getShares() {
        return this.shares;
    }

    public void setShares(SharesEnum shares) {
        this.shares = shares;
    }

    public LegalEntityIdentifier withShares(SharesEnum shares) {
        this.shares = shares;
        return this;
    }

    public LegalEntityIdentifier externalIdIdentifier(String externalIdIdentifier) {
        this.externalIdIdentifier = externalIdIdentifier;
        return this;
    }

    @ApiModelProperty("Legal Entity External Identifier")
    public @Size(
            min = 1
    ) String getExternalIdIdentifier() {
        return this.externalIdIdentifier;
    }

    public void setExternalIdIdentifier(String externalIdIdentifier) {
        this.externalIdIdentifier = externalIdIdentifier;
    }

    public LegalEntityIdentifier withInternalIdIdentifier(String externalIdIdentifier) {
        this.externalIdIdentifier = externalIdIdentifier;
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            LegalEntityIdentifier legalEntityIdentifier = (LegalEntityIdentifier)o;
            return Objects.equals(this.externalIdIdentifier, legalEntityIdentifier.externalIdIdentifier);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.externalIdIdentifier});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LegalEntityIdentifier {\n");
        sb.append("    externalIdIdentifier: ").append(this.toIndentedString(this.externalIdIdentifier)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}

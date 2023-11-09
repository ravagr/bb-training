package com.backbase.example.model;

import lombok.Generated;

public class IntegrationDataGroupIdentifier {
    private String idIdentifier;
    private DataGroupNameIdentifier nameIdentifier;

    @Generated
    public IntegrationDataGroupIdentifier() {
    }

    @Generated
    public String getIdIdentifier() {
        return this.idIdentifier;
    }

    @Generated
    public DataGroupNameIdentifier getNameIdentifier() {
        return this.nameIdentifier;
    }

    @Generated
    public void setIdIdentifier(final String idIdentifier) {
        this.idIdentifier = idIdentifier;
    }

    @Generated
    public void setNameIdentifier(final DataGroupNameIdentifier nameIdentifier) {
        this.nameIdentifier = nameIdentifier;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof IntegrationDataGroupIdentifier)) {
            return false;
        } else {
            IntegrationDataGroupIdentifier other = (IntegrationDataGroupIdentifier)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$idIdentifier = this.getIdIdentifier();
                Object other$idIdentifier = other.getIdIdentifier();
                if (this$idIdentifier == null) {
                    if (other$idIdentifier != null) {
                        return false;
                    }
                } else if (!this$idIdentifier.equals(other$idIdentifier)) {
                    return false;
                }

                Object this$nameIdentifier = this.getNameIdentifier();
                Object other$nameIdentifier = other.getNameIdentifier();
                if (this$nameIdentifier == null) {
                    if (other$nameIdentifier != null) {
                        return false;
                    }
                } else if (!this$nameIdentifier.equals(other$nameIdentifier)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof IntegrationDataGroupIdentifier;
    }

    @Generated
    public int hashCode() {
        int result = 1;
        Object $idIdentifier = this.getIdIdentifier();
        result = result * 59 + ($idIdentifier == null ? 43 : $idIdentifier.hashCode());
        Object $nameIdentifier = this.getNameIdentifier();
        result = result * 59 + ($nameIdentifier == null ? 43 : $nameIdentifier.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getIdIdentifier();
        return "IntegrationDataGroupIdentifier(idIdentifier=" + var10000 + ", nameIdentifier=" + this.getNameIdentifier() + ")";
    }
}
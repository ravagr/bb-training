package com.backbase.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SharesEnum {
    ACCOUNTS("accounts"),
    USERS("users"),
    USERSANDACCOUNTS("usersAndAccounts");

    private String value;

    private SharesEnum(String value) {
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
    public static SharesEnum fromValue(String value) {
        SharesEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SharesEnum val = var1[var3];
            if (val.value.equals(value)) {
                return val;
            }
        }

        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
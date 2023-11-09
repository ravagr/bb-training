package com.backbase.example.model;

import com.backbase.buildingblocks.persistence.model.AdditionalPropertiesAware;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.HashMap;
import java.util.Map;

public enum BatchResponseStatusCode implements AdditionalPropertiesAware {
    HTTP_STATUS_OK("200"),
    HTTP_STATUS_OK_Success("201"),
    HTTP_STATUS_OK_Multi_Status("207"),
    HTTP_STATUS_BAD_REQUEST("400"),
    HTTP_STATUS_NOT_FOUND("404"),
    HTTP_STATUS_INTERNAL_SERVER_ERROR("500");

    private final String value;
    private static final Map<String, BatchResponseStatusCode> CONSTANTS = new HashMap();
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> additions = new HashMap();

    private BatchResponseStatusCode(String value) {
        this.value = value;
    }

    @JsonValue
    public String toString() {
        return this.value;
    }

    @JsonCreator
    public static BatchResponseStatusCode fromValue(String value) {
        BatchResponseStatusCode constant = (BatchResponseStatusCode)CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
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

    static {
        BatchResponseStatusCode[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            BatchResponseStatusCode c = var0[var2];
            CONSTANTS.put(c.value, c);
        }

    }
}
package com.backbase.example.model;


import com.backbase.buildingblocks.persistence.model.AdditionalPropertiesAware;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.HashMap;
import java.util.Map;

public enum IntegrationAction implements AdditionalPropertiesAware {
    ADD("add"),
    REMOVE("remove");

    private final String value;
    private static final Map<String, IntegrationAction> CONSTANTS = new HashMap();
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> additions = new HashMap();

    private IntegrationAction(String value) {
        this.value = value;
    }

    @JsonValue
    public String toString() {
        return this.value;
    }

    @JsonCreator
    public static IntegrationAction fromValue(String value) {
        IntegrationAction constant = (IntegrationAction)CONSTANTS.get(value);
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
        IntegrationAction[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            IntegrationAction c = var0[var2];
            CONSTANTS.put(c.value, c);
        }

    }
}
package com.backbase.example.model;


import com.backbase.buildingblocks.persistence.model.AdditionalPropertiesAware;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"message", "key"})
public class Error implements AdditionalPropertiesAware {
    @JsonProperty("message")
    private String message;
    @JsonProperty("key")
    private String key;
    @JsonInclude(Include.NON_EMPTY)
    private Map<String, String> additions = new HashMap();

    public Error() {
    }

    @JsonProperty("message")
    public String getMessage() {
        return this.message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public Error withMessage(String message) {
        this.message = message;
        return this;
    }

    @JsonProperty("key")
    public String getKey() {
        return this.key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    public Error withKey(String key) {
        this.key = key;
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return (new HashCodeBuilder()).append(this.message).append(this.key).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof Error)) {
            return false;
        } else {
            Error rhs = (Error)other;
            return (new EqualsBuilder()).append(this.message, rhs.message).append(this.key, rhs.key).isEquals();
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
}
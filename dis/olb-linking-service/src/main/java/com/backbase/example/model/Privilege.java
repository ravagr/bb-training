package com.backbase.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

@ApiModel(
        description = "Privilege"
)
@JsonPropertyOrder({"additions", "privilege"})
public class Privilege {
    public static final String JSON_PROPERTY_ADDITIONS = "additions";
    private Map<String, String> additions = null;
    public static final String JSON_PROPERTY_PRIVILEGE = "privilege";
    private String privilege;

    public Privilege() {
    }

    public Privilege additions(Map<String, String> additions) {
        this.additions = additions;
        return this;
    }

    public Privilege putAdditionsItem(String key, String additionsItem) {
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

    public Privilege privilege(String privilege) {
        this.privilege = privilege;
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = ""
    )
    @JsonProperty("privilege")
    @JsonInclude(Include.ALWAYS)
    public @NotNull String getPrivilege() {
        return this.privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Privilege privilege = (Privilege)o;
            return Objects.equals(this.additions, privilege.additions) && Objects.equals(this.privilege, privilege.privilege);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.additions, this.privilege});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Privilege {\n");
        sb.append("    additions: ").append(this.toIndentedString(this.additions)).append("\n");
        sb.append("    privilege: ").append(this.toIndentedString(this.privilege)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
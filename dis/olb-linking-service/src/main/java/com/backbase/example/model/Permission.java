package com.backbase.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@JsonPropertyOrder({"functionId", "assignedPrivileges"})
public class Permission {
    public static final String JSON_PROPERTY_FUNCTION_ID = "functionId";
    private String functionId;
    public static final String JSON_PROPERTY_ASSIGNED_PRIVILEGES = "assignedPrivileges";
    private List<Privilege> assignedPrivileges = new ArrayList();

    public Permission() {
    }

    public Permission functionId(String functionId) {
        this.functionId = functionId;
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = ""
    )
    @JsonProperty("functionId")
    @JsonInclude(Include.ALWAYS)
    public @NotNull String getFunctionId() {
        return this.functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public Permission assignedPrivileges(List<Privilege> assignedPrivileges) {
        this.assignedPrivileges = assignedPrivileges;
        return this;
    }

    public Permission addAssignedPrivilegesItem(Privilege assignedPrivilegesItem) {
        this.assignedPrivileges.add(assignedPrivilegesItem);
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = ""
    )
    @JsonProperty("assignedPrivileges")
    @JsonInclude(Include.ALWAYS)
    public @NotNull @Valid List<Privilege> getAssignedPrivileges() {
        return this.assignedPrivileges;
    }

    public void setAssignedPrivileges(List<Privilege> assignedPrivileges) {
        this.assignedPrivileges = assignedPrivileges;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Permission permission = (Permission)o;
            return Objects.equals(this.functionId, permission.functionId) && Objects.equals(this.assignedPrivileges, permission.assignedPrivileges);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.functionId, this.assignedPrivileges});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Permission {\n");
        sb.append("    functionId: ").append(this.toIndentedString(this.functionId)).append("\n");
        sb.append("    assignedPrivileges: ").append(this.toIndentedString(this.assignedPrivileges)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
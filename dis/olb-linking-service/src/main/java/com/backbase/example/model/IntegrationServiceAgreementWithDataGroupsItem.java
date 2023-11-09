package com.backbase.example.model;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.validation.Valid;

public class IntegrationServiceAgreementWithDataGroupsItem {
    @JsonProperty("additions")
    private @Valid Map<String, String> additions = null;
    @JsonProperty("serviceAgreement")
    private IntegrationServiceAgreementIds serviceAgreement;
    @JsonProperty("dataGroups")
    private @Valid List<IntegrationDataGroupDetails> dataGroups = null;

    public IntegrationServiceAgreementWithDataGroupsItem() {
    }

    public IntegrationServiceAgreementWithDataGroupsItem additions(Map<String, String> additions) {
        this.additions = additions;
        return this;
    }

    public IntegrationServiceAgreementWithDataGroupsItem putAdditionsItem(String key, String additionsItem) {
        if (this.additions == null) {
            this.additions = new HashMap();
        }

        this.additions.put(key, additionsItem);
        return this;
    }

    @ApiModelProperty("")
    public Map<String, String> getAdditions() {
        return this.additions;
    }

    public void setAdditions(Map<String, String> additions) {
        this.additions = additions;
    }

    public IntegrationServiceAgreementWithDataGroupsItem serviceAgreement(IntegrationServiceAgreementIds serviceAgreement) {
        this.serviceAgreement = serviceAgreement;
        return this;
    }

    @ApiModelProperty("")
    public @Valid IntegrationServiceAgreementIds getServiceAgreement() {
        return this.serviceAgreement;
    }

    public void setServiceAgreement(IntegrationServiceAgreementIds serviceAgreement) {
        this.serviceAgreement = serviceAgreement;
    }

    public IntegrationServiceAgreementWithDataGroupsItem dataGroups(List<IntegrationDataGroupDetails> dataGroups) {
        this.dataGroups = dataGroups;
        return this;
    }

    public IntegrationServiceAgreementWithDataGroupsItem addDataGroupsItem(IntegrationDataGroupDetails dataGroupsItem) {
        if (this.dataGroups == null) {
            this.dataGroups = new ArrayList();
        }

        this.dataGroups.add(dataGroupsItem);
        return this;
    }

    @ApiModelProperty("List of data groups")
    public @Valid List<IntegrationDataGroupDetails> getDataGroups() {
        return this.dataGroups;
    }

    public void setDataGroups(List<IntegrationDataGroupDetails> dataGroups) {
        this.dataGroups = dataGroups;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            IntegrationServiceAgreementWithDataGroupsItem integrationServiceAgreementWithDataGroupsItem = (IntegrationServiceAgreementWithDataGroupsItem)o;
            return Objects.equals(this.additions, integrationServiceAgreementWithDataGroupsItem.additions) && Objects.equals(this.serviceAgreement, integrationServiceAgreementWithDataGroupsItem.serviceAgreement) && Objects.equals(this.dataGroups, integrationServiceAgreementWithDataGroupsItem.dataGroups);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.additions, this.serviceAgreement, this.dataGroups});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IntegrationServiceAgreementWithDataGroupsItem {\n");
        sb.append("    additions: ").append(this.toIndentedString(this.additions)).append("\n");
        sb.append("    serviceAgreement: ").append(this.toIndentedString(this.serviceAgreement)).append("\n");
        sb.append("    dataGroups: ").append(this.toIndentedString(this.dataGroups)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}

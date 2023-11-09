package com.backbase.example.model;


import com.backbase.integration.arrangement.rest.spec.v2.arrangements.PersistenceAction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import javax.validation.constraints.Size;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"arrangementId", "action"})
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class BatchResponseItemExtended extends BatchResponseItem {
    @JsonProperty("arrangementId")
    private @Size(
            min = 1,
            max = 36
    ) String arrangementId;
    @JsonProperty("action")
    private PersistenceAction action;

    public BatchResponseItemExtended() {
    }

    @JsonProperty("arrangementId")
    public String getArrangementId() {
        return this.arrangementId;
    }

    @JsonProperty("arrangementId")
    public void setArrangementId(String arrangementId) {
        this.arrangementId = arrangementId;
    }

    public BatchResponseItemExtended withArrangementId(String arrangementId) {
        this.arrangementId = arrangementId;
        return this;
    }

    @JsonProperty("action")
    public PersistenceAction getAction() {
        return this.action;
    }

    @JsonProperty("action")
    public void setAction(PersistenceAction action) {
        this.action = action;
    }

    public BatchResponseItemExtended withAction(PersistenceAction action) {
        this.action = action;
        return this;
    }

    public BatchResponseItemExtended withResourceId(String resourceId) {
        super.withResourceId(resourceId);
        return this;
    }

    public BatchResponseItemExtended withStatus(BatchResponseStatusCode status) {
        super.withStatus(status);
        return this;
    }

    public BatchResponseItemExtended withErrors(List<Error> errors) {
        super.withErrors(errors);
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return (new HashCodeBuilder()).appendSuper(super.hashCode()).append(this.arrangementId).append(this.action).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof com.backbase.integration.arrangement.rest.spec.v2.arrangements.BatchResponseItemExtended)) {
            return false;
        } else {
            com.backbase.integration.arrangement.rest.spec.v2.arrangements.BatchResponseItemExtended rhs = (com.backbase.integration.arrangement.rest.spec.v2.arrangements.BatchResponseItemExtended)other;
            return (new EqualsBuilder()).appendSuper(super.equals(other)).append(this.arrangementId, rhs.getArrangementId()).append(this.action, rhs.getAction()).isEquals();
        }
    }
}

package com.backbase.example.model;


public enum ErrorCodes {
    ERR_IAG_006("Creating service agreement failed", "accessGroup.save.error.message.E_SERVICE_AGREEMENT_INGEST_FAILED"),
    ERR_IAG_007("Invalid external service agreement id", "accessGroup.save.error.message.E_INVALID_EXTERNAL_SERVICE_AGREEMENT_ID"),
    ERR_IAG_008("At least one function group must be provided", "functionGroup.update.error.message.E_NOT_PROVIDED_FUNCTION_GROUP"),
    ERR_IAG_009("At least one data group must be provided", "dataGroup.update.error.message.E_NOT_PROVIDED_DATA_GROUP"),
    ERR_IAG_010("Invalid data group type", "dataGroup.save.error.message.E_INVALID_DATA_GROUP_TYPE"),
    ERR_IAG_011("At least one item must be provided", "accessGroup.permissions.update.error.message.E_EMPTY_PAYLOAD"),
    ERR_IAG_013("At least one user must be provided", "accessGroup.serviceagreement.users.error.message.E_EMPTY_PAYLOAD"),
    ERR_IAG_016("Service agreement does not exists", "accessGroup.serviceagreement.get.error.message.E_SERVICE_AGREEMENT_DOES_NOT_EXISTS"),
    ERR_IAG_017("Invalid data group items", "dataGroup.save.error.message.E_INVALID_DATA_GROUP_ITEMS"),
    ERR_IAG_018("Invalid participant", "participant.update.error.message.E_INVALID_PARTICIPANT_BODY"),
    ERR_IAG_019("You can not update more than 200 participants at once", "participant.update.error.message.E_MAX_PARTICIPANT_SIZE_EXCEEDED"),
    ERR_IAG_020("Only internal or external id must be provided", "dataGroup.items.save.error.message.E_INVALID_DATA_ITEM_IDS"),
    ERR_IAG_021("All items in data group must be using same type of identifier (internal or external)", "dataGroup.items.save.error.message.E_DATA_ITEM_IDS_MUST_BE_EXTERNAL_OR_INTERNAL"),
    ERR_IAG_022("No service agreement or data item identifier is provided", "dataGroups.search.request.invalid"),
    ERR_IAG_023("Invalid Data group identifier is provided", "dataGroup.save.error.message.E_INVALID_DATA_GROUP_IDENTIFIERS"),
    ERR_IAG_024("Data group definition can not be null.", "dataGroup.save.error.message.E_EMPTY_PAYLOAD"),
    ERR_IAG_025("Both or none of the identifiers sent for regular/admin user assignable permission set.", "permissionSet.identifier.INVALID_IDENTIFIERS"),
    ERR_IAG_026("Invalid identifier.", "permissionSet.update.identifier.INVALID_IDENTIFIERS"),
    ERR_IAG_027("Invalid from parameter", "parameter.error.message.E_INVALID_FROM_PARAMETER"),
    ERR_IAG_028("Invalid size parameter", "parameter.error.message.E_INVALID_SIZE_PARAMETER"),
    ERR_IAG_029("Invalid from or size parameter", "parameter.error.message.E_INVALID_FROM_OR_SIZE_PARAMETER"),
    ERR_IAG_030("Either apsId or apsName should be sent.", "functionGroup.save.error.message.E_BOTH_APS_IDENTIFIERS_PROVIDED"),
    ERR_IAG_031("Assignable permission set cannot be associated with regular function group.", "functionGroup.save.error.message.E_APS_CANT_BE_ASSOCIATED_WITH_REGULAR_FG");

    private String errorCode;
    private String errorMessage;

    private ErrorCodes(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
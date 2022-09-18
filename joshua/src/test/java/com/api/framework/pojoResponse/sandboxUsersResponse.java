package com.api.framework.pojoResponse;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "token",
        "active",
        "first_name",
        "last_name",
        "email",
        "phone",
        "uses_parent_account",
        "corporate_card_holder",
        "created_time",
        "last_modified_time",
        "metadata",
        "account_holder_group_token",
        "status"
})
public class sandboxUsersResponse {

    @JsonProperty("token")
    private String token;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("uses_parent_account")
    private Boolean usesParentAccount;
    @JsonProperty("corporate_card_holder")
    private Boolean corporateCardHolder;
    @JsonProperty("created_time")
    private String createdTime;
    @JsonProperty("last_modified_time")
    private String lastModifiedTime;
//    @JsonProperty("metadata")
//    private Metadata metadata;
    @JsonProperty("account_holder_group_token")
    private String accountHolderGroupToken;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> otherProperties = new HashMap<String, Object>();

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("uses_parent_account")
    public Boolean getUsesParentAccount() {
        return usesParentAccount;
    }

    @JsonProperty("uses_parent_account")
    public void setUsesParentAccount(Boolean usesParentAccount) {
        this.usesParentAccount = usesParentAccount;
    }

    @JsonProperty("corporate_card_holder")
    public Boolean getCorporateCardHolder() {
        return corporateCardHolder;
    }

    @JsonProperty("corporate_card_holder")
    public void setCorporateCardHolder(Boolean corporateCardHolder) {
        this.corporateCardHolder = corporateCardHolder;
    }

    @JsonProperty("created_time")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("created_time")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @JsonProperty("last_modified_time")
    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    @JsonProperty("last_modified_time")
    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

//    @JsonProperty("metadata")
//    public Metadata getMetadata() {
//        return metadata;
//    }
//
//    @JsonProperty("metadata")
//    public void setMetadata(Metadata metadata) {
//        this.metadata = metadata;
//    }

    @JsonProperty("account_holder_group_token")
    public String getAccountHolderGroupToken() {
        return accountHolderGroupToken;
    }

    @JsonProperty("account_holder_group_token")
    public void setAccountHolderGroupToken(String accountHolderGroupToken) {
        this.accountHolderGroupToken = accountHolderGroupToken;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonAnyGetter
    public Map<String, Object> getOtherProperties() {
        return this.otherProperties;
    }

    @JsonAnySetter
    public void setOtherProperty(String name, Object value) {
        this.otherProperties.put(name, value);
    }

}

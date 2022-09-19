package com.api.framework;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.*;
import sun.jvm.hotspot.oops.Metadata;

import java.util.HashMap;
import java.util.Map;

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


public class ResponseBodyPojo {
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
    @JsonProperty("metadata")

    private Metadata metadata;
    @JsonProperty("account_holder_group_token")

    private String accountHolderGroupToken;
    @JsonProperty("status")

    private String status;

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Boolean getUsesParentAccount() {
        return usesParentAccount;
    }
    public void setUsesParentAccount(Boolean usesParentAccount) {
        this.usesParentAccount = usesParentAccount;
    }
    public Boolean getCorporateCardHolder() {
        return corporateCardHolder;
    }
    public void setCorporateCardHolder(Boolean corporateCardHolder) {
        this.corporateCardHolder = corporateCardHolder;
    }
    public String getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
    public String getLastModifiedTime() {
        return lastModifiedTime;
    }
    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
    public Metadata getMetadata() {
        return metadata;
    }
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
    public String getAccountHolderGroupToken() {
        return accountHolderGroupToken;
    }
    public void setAccountHolderGroupToken(String accountHolderGroupToken) {
        this.accountHolderGroupToken = accountHolderGroupToken;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonIgnore
    private Map<String, String> responseProperties = new HashMap<String, String>();

    @JsonAnyGetter
    public Map<String, String> getResponseProperties() {return this.responseProperties;}

    @JsonAnySetter
    public void setResponseProperties(String NAME, String VALUE) {this.responseProperties.put(NAME, VALUE);}
}



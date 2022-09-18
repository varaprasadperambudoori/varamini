package com.api.object.Response;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "active", "token", "created_time", "last_modified_time", "account"})

public class SandboxFundingSourcesResponse {

    @JsonProperty("name")
    private String name;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("token")
    private String token;
    @JsonProperty("created_time")
    private String createdTime;
    @JsonProperty("last_modified_time")

    private String lastModifiedTime;
    @JsonProperty("account")
    private String account;

    public String getName() {return name;}
    public void setName(String name) { this.name = name;}

    public Boolean getActive() {return active;}
    public void setActive(Boolean active) {this.active = active;}

    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}

    public String getCreatedTime() {return createdTime;}
    public void setCreatedTime(String createdTime) {this.createdTime = createdTime;}

    public String getLastModifiedTime() {return lastModifiedTime;}
    public void setLastModifiedTime(String lastModifiedTime) {this.lastModifiedTime = lastModifiedTime;}

    public String getAccount() {return account;}
    public void setAccount(String account) {this.account = account;}

    @JsonIgnore
    private Map<String, String> sandboxFundingSourcesProperties = new HashMap<String, String>();

    @JsonAnyGetter
    public Map<String, String> getSandboxFundingSourcesProperties() {return this.sandboxFundingSourcesProperties;}

    @JsonAnySetter
    public void setSandboxFundingSourcesProperties(String NAME, String VALUE) {this.sandboxFundingSourcesProperties.put(NAME, VALUE);}

}

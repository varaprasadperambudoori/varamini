package com.api.framework.pojoResponse;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "active",
        "token",
        "created_time",
        "last_modified_time",
        "account"
})

public class sandboxProgramResponse {

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

    @JsonIgnore
    private Map<String, Object> otherProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName(){
        return name;
    }

    @JsonProperty("name")
    public void setName(String name){
        this.name = name;
    }

    @JsonProperty("active")
    public Boolean getActive(){
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
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

    @JsonProperty("account")
    public String getAccount() {
        return account;
    }

    @JsonProperty("account")
    public void setAccount(String account) {
        this.account = account;
    }


    @JsonAnyGetter
    public Map<String, Object> getOtherProperties() {
        return this.otherProperties;
    }

    @JsonAnySetter
    public void setOtherProperties(String name, Object value) {
        this.otherProperties.put(name, value);
    }
}

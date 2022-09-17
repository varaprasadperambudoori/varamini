
package com.api.Pojo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "created_time",
    "last_modified_time",
    "name",
    "active",
    "account",
    "token"
})
@Generated("jsonschema2pojo")
public class CreateprogramsourceResPojo {

    @JsonProperty("created_time")
    private String createdTime;
    @JsonProperty("last_modified_time")
    private String lastModifiedTime;
    @JsonProperty("name")
    private String name;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("account")
    private String account;
    @JsonProperty("token")
    private String token;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("created_time")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("created_time")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public CreateprogramsourceResPojo withCreatedTime(String createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    @JsonProperty("last_modified_time")
    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    @JsonProperty("last_modified_time")
    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public CreateprogramsourceResPojo withLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public CreateprogramsourceResPojo withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    public CreateprogramsourceResPojo withActive(Boolean active) {
        this.active = active;
        return this;
    }

    @JsonProperty("account")
    public String getAccount() {
        return account;
    }

    @JsonProperty("account")
    public void setAccount(String account) {
        this.account = account;
    }

    public CreateprogramsourceResPojo withAccount(String account) {
        this.account = account;
        return this;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    public CreateprogramsourceResPojo withToken(String token) {
        this.token = token;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public CreateprogramsourceResPojo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CreateprogramsourceResPojo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("createdTime");
        sb.append('=');
        sb.append(((this.createdTime == null)?"<null>":this.createdTime));
        sb.append(',');
        sb.append("lastModifiedTime");
        sb.append('=');
        sb.append(((this.lastModifiedTime == null)?"<null>":this.lastModifiedTime));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("active");
        sb.append('=');
        sb.append(((this.active == null)?"<null>":this.active));
        sb.append(',');
        sb.append("account");
        sb.append('=');
        sb.append(((this.account == null)?"<null>":this.account));
        sb.append(',');
        sb.append("token");
        sb.append('=');
        sb.append(((this.token == null)?"<null>":this.token));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.lastModifiedTime == null)? 0 :this.lastModifiedTime.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.createdTime == null)? 0 :this.createdTime.hashCode()));
        result = ((result* 31)+((this.active == null)? 0 :this.active.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.account == null)? 0 :this.account.hashCode()));
        result = ((result* 31)+((this.token == null)? 0 :this.token.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreateprogramsourceResPojo) == false) {
            return false;
        }
        CreateprogramsourceResPojo rhs = ((CreateprogramsourceResPojo) other);
        return ((((((((this.lastModifiedTime == rhs.lastModifiedTime)||((this.lastModifiedTime!= null)&&this.lastModifiedTime.equals(rhs.lastModifiedTime)))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.createdTime == rhs.createdTime)||((this.createdTime!= null)&&this.createdTime.equals(rhs.createdTime))))&&((this.active == rhs.active)||((this.active!= null)&&this.active.equals(rhs.active))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.account == rhs.account)||((this.account!= null)&&this.account.equals(rhs.account))))&&((this.token == rhs.token)||((this.token!= null)&&this.token.equals(rhs.token))));
    }

}

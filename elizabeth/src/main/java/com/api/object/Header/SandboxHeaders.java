package com.api.object.Header;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class SandboxHeaders {
    public String SandboxHeaderKey;      //"Content-Type"
    public String SandboxHeaderValue;    // "Application/json";

    public SandboxHeaders() {}

    public String getSandboxHeaderKey() {return SandboxHeaderKey; }

    public void setSandboxHeaderKey(String sandboxHeaderKey) {SandboxHeaderKey = sandboxHeaderKey;}

    public String getSandboxHeaderValue() {return SandboxHeaderValue;}

    public void setSandboxHeaderValue(String sandboxHeaderValue) {SandboxHeaderValue = sandboxHeaderValue;}

    @JsonIgnore
    private Map<String, String> sandboxHeaders = new HashMap<String, String>();

    @JsonAnyGetter
    public Map<String, String> getSandboxHeaders() {return this.sandboxHeaders;}

    @JsonAnySetter
    public void setSandboxHeaders(String NAME, String VALUE) {this.sandboxHeaders.put(NAME, VALUE);}
}





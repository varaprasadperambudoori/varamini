package com.api.object.Body;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class SandboxUsersBody {
    @JsonIgnore
    private Map<String, String> sandboxUsersProperties = new HashMap<String, String>();

    @JsonAnyGetter
    public Map<String, String> getSandboxBody() {return this.sandboxUsersProperties;}

    @JsonAnySetter
    public void setSandboxBody(String NAME, String VALUE) {this.sandboxUsersProperties.put(NAME, VALUE);}
}

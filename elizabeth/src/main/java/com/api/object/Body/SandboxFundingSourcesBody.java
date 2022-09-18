package com.api.object.Body;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class SandboxFundingSourcesBody {
    @JsonIgnore
    private Map<String, String> sandboxFundingSourcesProperties = new HashMap<String, String>();

    @JsonAnyGetter
    public Map<String, String> getSandboxBody() {return this.sandboxFundingSourcesProperties;}

    @JsonAnySetter
    public void setSandboxBody(String NAME, String VALUE) {this.sandboxFundingSourcesProperties.put(NAME, VALUE);}
}

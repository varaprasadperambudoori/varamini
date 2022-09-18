package com.api.object.Response.Metadata;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

public class Metadata {
    @JsonIgnore
    private Map<String, String> sandboxUsersMetadata = new HashMap<String, String>();

    @JsonAnyGetter
    public Map<String, String> getSandboxUsersMetadata() {return this.sandboxUsersMetadata;}

    @JsonAnySetter
    public void setSandboxUsersMetadataBody(String NAME, String VALUE) {this.sandboxUsersMetadata.put(NAME, VALUE);}
}

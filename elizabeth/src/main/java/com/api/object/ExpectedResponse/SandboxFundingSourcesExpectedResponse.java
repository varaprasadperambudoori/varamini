package com.api.object.ExpectedResponse;

import com.fasterxml.jackson.annotation.*;
import com.squareup.moshi.Json;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Response"})

public class SandboxFundingSourcesExpectedResponse {

    @JsonProperty("Response")
    private Response response;

    @JsonIgnore
    private Map<String, Object> sandboxExpectedResponse = new HashMap<String,Object>();

    @JsonProperty("Response")
    public Response getResponse() {return response;}

    @JsonProperty("Response")
    public void setResponse(Response response) {this.response = response;}

    @JsonAnyGetter
    public Map<String,Object> getListOfExpectedResponse() {return this.sandboxExpectedResponse;}

    @JsonAnySetter
    public void setListOfExpectedResponse(String name, Object value) {this.sandboxExpectedResponse.put(name,value);}




}

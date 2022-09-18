package com.api.framework.pojoRequest;

public class sandboxProgramRequest {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "programName='" + getName() +
                '}';
    }
}

package com.api.framework.pojoRequest;

public class FundingsourcesProgramRequest {
    private String programName;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @Override
    public String toString() {
        return "FundingsourcesProgramPojo{" +
                "programName='" + programName + '\'' +
                '}';
    }
}

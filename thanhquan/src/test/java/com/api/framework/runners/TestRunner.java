package com.api.framework.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/java/com/api/framework/features/getMethodTesting.feature"},
        glue = {"com.api.framework.stepDefinitions"})

public class TestRunner {

}

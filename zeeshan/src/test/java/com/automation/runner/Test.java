package com.automation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/com/automation/feature/phpTravelsFeature.feature", glue = {"com.automation.stepDefinitions"})

public class Test {
}

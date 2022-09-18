package com.automation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/com/automation/feature/sandboxAPIFeature.feature", glue = {"com.automation.stepdefinitions"})

public class sandboxAPIRunnerTest {
}

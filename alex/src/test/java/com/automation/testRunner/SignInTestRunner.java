package com.automation.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features/SalesForceSignIn.feature", dryRun = false, monochrome = true,
        glue = {"com/automation/stepDefinitions"})
public class SignInTestRunner {

}
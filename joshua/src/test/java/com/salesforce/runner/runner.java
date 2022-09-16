package com.salesforce.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)

@CucumberOptions(features = "feature/salesforce.feature", glue = {"com/salesforce/stepdefinitions"})

public class runner {
}

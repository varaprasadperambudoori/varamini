package com.phptravels.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/com/phptravels/feature/phpTravelsFeature.feature", glue = {"com.phptravels.stepdefinitions"})

public class phpTravelsRunnerTest {
}

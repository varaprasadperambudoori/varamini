package com.saleforces.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@PostTest", publish = true,  features = "feature", glue = "com/saleforces/stepDefinitions")
public class SaleForcesRunnerTest {

}

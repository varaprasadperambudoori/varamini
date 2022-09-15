package com.salesforce.runner;

import com.aventstack.extentreports.ExtentReports;
import com.vimalselvam.cucumber.listener.Reporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.io.File;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"Features/Saleforce.feature"},
        glue = {"com.salesforce.stepDefinitions"},
        plugin = { "pretty",
                "html:target/cucumber-reports/reports.html",
                "json:target/cucumber-reports/Cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
               },

        monochrome = true
        )

public class SaleforceRunnerTest {
}

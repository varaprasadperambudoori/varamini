package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="cucumber/src/test/resources/features",glue={"StepDefs"})

public class TestRunner {
}

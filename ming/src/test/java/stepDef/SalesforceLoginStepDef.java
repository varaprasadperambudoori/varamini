package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesforceLoginStepDef {
    WebDriver driver;
    By username = By.id("username");
    By password = By.id("password");
    By login = By.id("Login");

    @Given("I am on Salesforce login page")
    public void i_am_on_salesforce_login_page() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");
        Thread.sleep(3000);

    }

    @When("I enter username and password")
    public void i_enter_username_and_password() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(username).sendKeys("mizhu-whfh@force.com");
        driver.findElement(password).sendKeys("thisispassword1");
        Thread.sleep(3000);

    }

    @When("I press login button")
    public void i_press_login_button() throws Exception{
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(login).click();
    }

    @Then("I should login successfully")
    public void i_should_login_successfully() throws Exception{
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Verify Your Identity | Salesforce", driver.getTitle());
        driver.close();

    }
}

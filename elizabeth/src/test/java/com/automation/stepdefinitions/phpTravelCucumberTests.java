package com.automation.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class phpTravelCucumberTests {
    WebDriver driver;
    String username = "tester.fengg-wzdw@force.com";
    String password = "123Welcome456";

    /* credentials
    First Name: ELIZABETH
    Last Name: TESTER
    Job: QE
    Phone: 123-456-7890
    Email: tester.fengg@gmail.com
    Username: tester.fengg-wzdw@force.com
    Password: 123Welcome456
    City Born: SF
     */
    @Given("I am on salesforce login page")
    public void i_am_on_salesforce_login_page() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ehealthinsuranceservicesinc.my.salesforce.com");
        Thread.sleep(2000);
    }

    @When("I input my credentials")
    public void i_input_my_credentials() throws InterruptedException {
        driver.findElement(By.id("username")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("username")).sendKeys(username);
        Thread.sleep(1000);

        driver.findElement(By.id("password")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
    }

    @Then("I log into my salesforce account")
    public void i_log_into_my_salesforce_account() throws InterruptedException {
        driver.findElement(By.id("Login")).click();
        Thread.sleep(1000);
        driver.quit();
    }

}

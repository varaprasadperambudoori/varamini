package com.automation.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class phpTravelCucumberTests {
    WebDriver driver;

    @Given("I am on salesforce login page")
    public void i_am_on_salesforce_login_page() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ehealthinsuranceservicesinc.my.salesforce.com");
        Thread.sleep(2000);
    }
    @When("I input my username {string} credentials")
    public void i_input_my_username_credentials(String string) throws InterruptedException {
        driver.findElement(By.id("username")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("username")).sendKeys(string);
        Thread.sleep(1000);
    }
    @When("I input my password {string} credentials")
    public void i_input_my_password_credentials(String string) throws InterruptedException {
        driver.findElement(By.id("password")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("password")).sendKeys(string);
        Thread.sleep(1000);
    }

    @Then("I log into my salesforce account")
    public void i_log_into_my_salesforce_account() throws InterruptedException {
        driver.findElement(By.id("Login")).click();
        Thread.sleep(1000);
        driver.quit();
    }

}

package com.automation.stepDefinitions;

import com.automation.pageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignIn {
    WebDriver driver;

    @Given("I am on the SalesForce Sign In page")
    public void i_am_on_the_google_search_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");
        Thread.sleep(2000);
    }

    @When("I enter my {string}")
    public void i_enter_my(String email) throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.enterEmail(email);
        Thread.sleep(2000);
    }

    @When("I enter my {string} and submit")
    public void i_enter_my_and_submit(String word) throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.enterPass(word);
        Thread.sleep(2000);
        login.clickLogin();
        Thread.sleep(2000);
    }
    @Then("I should access the next page")
    public void i_should_access_the_next_page(){
        //Assert.assertTrue(driver.getTitle().contains("Register Your Mobile Phone | Salesforce"));
        driver.quit();
    }
}
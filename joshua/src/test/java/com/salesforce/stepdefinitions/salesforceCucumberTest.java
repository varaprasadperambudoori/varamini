package com.salesforce.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class salesforceCucumberTest {

    WebDriver driver;
    String email = "joshtestcab@gmail.com";
    String userName = "joshtestcab-c9xu@force.com";
    String password = "123Password456";


    @Given("I am on salesforce sign in page")
    public void i_am_on_salesforce_sign_in_page() throws InterruptedException{
       System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

       driver = new ChromeDriver();
       driver.get("https://ehealthinsuranceservicesinc4.my.salesforce.com");
       Thread.sleep(1000);
    }
    @When("I input the sign in information")
    public void i_input_the_sign_in_information() throws InterruptedException{
        driver.findElement(By.id("username")).sendKeys(userName);
        Thread.sleep(200);

        driver.findElement(By.name("pw")).sendKeys(password);
        Thread.sleep(200);
    }
    @Then("I sign into the salesforce account")
    public void i_sign_into_the_salesforce_account() throws InterruptedException{
       driver.findElement(By.name("Login")).click();
       Thread.sleep(2000);
       driver.quit();

    }
}

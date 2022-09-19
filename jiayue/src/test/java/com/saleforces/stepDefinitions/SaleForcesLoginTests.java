package com.saleforces.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaleForcesLoginTests {
    WebDriver driver;
    @Given("I setup the web driver I want to use")
    public void i_setup_the_web_driver_i_want_to_use() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
        driver = new ChromeDriver();
    }
    @When("I navigate to salesforce login web page")
    public void i_navigate_to_salesforce_login_web_page() throws InterruptedException {
        driver.get("https://login.salesforce.com/");
        Thread.sleep(1000);
    }
    @Then("I enter my userName {string}")
    public void i_enter_my_user_name(String string) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(string);
        Thread.sleep(1000);
    }
    @Then("I enter my Password {string}")
    public void i_enter_my_password(String string) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(string);
        Thread.sleep(1000);
    }
    @Then("I hit the login buttom")
    public void i_hit_the_login_buttom() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
        Thread.sleep(3000);
        driver.quit();
    }

}

package com.salesforce.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaleforceTest {

    WebDriver driver;
    static String username = "thanhquan1704-2sez@force.com";
    static String password = "qwer1234";
    @Given("I am in Salefoce log in page")
    public void i_am_in_salefoce_log_in_page() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\thanh\\OneDrive\\Desktop\\varamini\\thanhquan\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://nisum4.my.salesforce.com/");
        Thread.sleep(1000);
    }
    @When("I enter username")
    public void i_enter_username() throws Exception{
        driver.findElement(By.id("username")).sendKeys(username);
        Thread.sleep(1000);
    }
    @When("I enter password")
    public void i_enter_password() throws Exception{
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
    }
    @When("I press enter key")
    public void i_press_enter_key() throws Exception{
        driver.findElement(By.id("Login")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }
    @Then("I should see the portal page")
    public void i_should_see_the_portal_page() throws Exception {
        String expectedString = "Verify Your Identity";
        Assertions.assertTrue(driver.getPageSource().contains(expectedString));
        Thread.sleep(1000);
        driver.quit();
    }
}

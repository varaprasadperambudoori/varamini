package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for username field
    By email = By.id("username");
    //Locator for password field
    By pass = By.id("password");

    //Locator for sign in button
    By login = By.id("Login");


    //Method to enter username
    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPass(String word){
        driver.findElement(pass).sendKeys(word);
    }

    public void clickLogin(){
        driver.findElement(login).click();
    }
}

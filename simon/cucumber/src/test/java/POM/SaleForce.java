package POM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;

public class SaleForce {
    WebDriver driver;
    private WebElement username,password,loginBtn;
    private static final Logger LOGGER = LogManager.getLogger(SaleForce.class);

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            LOGGER.error(""+description.getDisplayName()+" failed "+e.getMessage());
            super.failed(e, description);
        }
    };
    public SaleForce(){
        System.setProperty("webdriver.chrome.driver","cucumber/src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        LOGGER.info("Created Web Driver");
    }
    public void goToPage(){
        driver.get("https://ehealthinsuranceservicesinc.my.salesforce.com");
        loginBtn = new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Login']")));
        username = driver.findElement(By.xpath("//input[@id='username']"));
        password = driver.findElement(By.xpath("//input[@id='password']"));
        LOGGER.info("Traveled to website.");
    }
    public void fillInfo(String user,String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        LOGGER.info("Filled in login info");
    }
    public void login(){
        loginBtn.sendKeys(Keys.ENTER);
        LOGGER.info("I pressed the login button");
    }
    public void checkLogin(){
        //System.out.println(driver.findElement(By.xpath("//*[@id='header']")).getAttribute("innerHTML"));
        Assert.assertEquals("Verify Your Identity",driver.findElement(By.xpath("//*[@id='header']")).getAttribute("innerHTML"));
        LOGGER.info("Logged in.");
        driver.quit();
    }
}

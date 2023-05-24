import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;
import java.util.concurrent.TimeUnit;


import java.net.URL;
import java.net.MalformedURLException;


public class BasicTests {
    /*
    This class is for performing basic tests:
        -Fill simple form and send (eg. Login)
        -Form sending with user
        -Logout
        -Fill input (text,radio,check...)
        -Send a form
        -Static Page test
        -Multiple page test from array (easily extendable static page tests)
        -complex xpath (eg. //div//a[@href='asd'])
        -Filling or reading textarea content
        -Filling or reading drop-down
        -Filling or reading Radio button
        -At least 4 class
        -At least 6 class
        -At least 8 class
        -Explicit wait
        -Reading the page title
        -Page object pattern
        -BasePage object class
        -Test suite looks like readable test description
     */
    public WebDriver driver;
    private By emailBy = By.id("email");
    private By passwordBy = By.id("password");
    private By loginBy = By.xpath("//form[@class='css-3n8yix-StyledForm e1h04xtc0']//button[@class='css-xcv9z6-Button-Primary ehz4ycd11']");


    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    public void testFillSimpleFormAndLogin() {
        this.driver.get("https://toggl.com/track/");
        MainPage mainPage = new MainPage(this.driver);
        mainPage.usernameTextFill(emailBy, "fbauwiexqlzy@internetkeno.com");
        mainPage.passwordTextFill(passwordBy, "y6GW6$Eo8Co6");
        // usernameTogglerElement.sendKeys("fbauwiexqlzy@internetkeno.com");
        mainPage.submitLogin(loginBy);
        System.out.println("Sent email and password details.");
    }

    @Test
    public void testFooterExists() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getFooterText().contains("Toggl. All rights reserved."));
        String footer = mainPage.getFooterText();
        System.out.println(footer);
    }



    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}

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
        -Fill simple form and send (eg. Login) -> DONE
        -Form sending with user -> in hold!
        -Logout
        -Fill input (text,radio,check...)
        -Send a form
        -Static Page test
        -Multiple page test from array (easily extendable static page tests) -> DONE
        -complex xpath (eg. //div//a[@href='asd']) -> DONE
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
    //Login details -> 3c3ad7cd02@fireboxmail.lol:y6GW6$Eo8Co6
    private By emailBy = By.id("email");
    private By passwordBy = By.id("password");
    private By signupBy = By.xpath("//button[normalize-space()='Sign up with email']");
    private By loginBy = By.xpath("//button[@class='css-xcv9z6-Button-Primary ehz4ycd11']");
    private By loadingScreenBy = By.className("loading snowball");
    private By projectBy = By.xpath("//div[@class='css-15flw8s-ScrollContainer e1f220q512']//section[1]//ul[1]//a[1]");
    private By createprojectBy = By.xpath("//button[@class='e1hlosco0 css-lih12m-StyledButton-button-PrimaryButton ehcbn3e1']");
    private By textareaBy = By.xpath("//textarea[@id='message']");
    private String mainURL = "https://toggl.com/track/";
    private String loginURL = "https://toggl.com/track/login/";
    private String contactURL = "https://toggl.com/track/contact/";

    @Before
    public void setup() throws MalformedURLException  {
        /*
         * This sets up the testing environment
        */
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.get(loginURL);
        driver.manage().window().maximize();
    }

    @Test
    public void testFillSimpleFormAndClickButton() {
        /*
         * This tests A simple form filling and click on a button
        */
        MainPage mainPage = new MainPage(driver, mainURL);
        mainPage.usernameTextFill(emailBy, "fbauwiexqlzy@internetkeno.com");
        mainPage.passwordTextFill(passwordBy, "y6GW6$Eo8Co6");
        System.out.println("Sent email and password details.");
        mainPage.submitButton(signupBy);
    }

    @Test
    public void testLoginAndCreateProject() throws InterruptedException {
        /*
        * This logs in to our testing account and sends a form
        */
        MainPage mainPage = new MainPage(driver, loginURL);
        mainPage.usernameTextFill(emailBy, "3c3ad7cd02@fireboxmail.lol");
        mainPage.passwordTextFill(passwordBy, "y6GW6$Eo8Co6");
        mainPage.submitButton(loginBy);
    }

    @Test
    public void testStaticPage() {
        /*
         * This tests whether a certain URL was opened or not, by checking the existence of the footer
        */
        MainPage mainPage = new MainPage(driver, loginURL);
        Assert.assertTrue(mainPage.getFooterText().contains("Toggl. All rights reserved."));
        String footer = mainPage.getFooterText();
        System.out.println(footer);
    }

    @Test
    public void testMultipleEntries() {
        /*
         * This tests multiple contact form entries by looping from an array of strings
        */
        String[] textInputs={"Hi Team","Sorry but I won't send this","ELTE IK"};
        MainPage mainPage = new MainPage(driver, contactURL);
        for(String inputString : textInputs) {
            mainPage.fillTextBox(textareaBy, inputString+'\n');
        }
    }


    @After
    public void close() {
        /*
         * This will close the driver after we're done from the tests
        */
        if (driver != null) {
            driver.quit();
        }
    }

}

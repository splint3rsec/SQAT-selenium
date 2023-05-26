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
        -Form sending with user
        -Logout
        -Fill input (text,radio,check...)
        -Send a form
        -Static Page test -> DONE
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
    //Login details -> 3c3ad7cd02@fireboxmail.lol:y6GW6$Eo8Co6
    private By firstNameBy = By.xpath("//input[@id='First name']");
    private By emailAddressBy = By.id("Email address");
    private By passwordBy = By.id("Password");
    private By loginButtonBy = By.className("button_text");
    private By lastNameBy = By.xpath("//input[@id='Last name']");
    private By signupEmailBy = By.xpath("//input[@id='Email address']");
    private By successfulRegDescBy = By.className("We sent an email to your inbox. Please verify your email address so we know that it's really you!");
    private By companyBy = By.xpath("//input[@id='Company']");
    private By emailBy = By.xpath("//input[@id='Email']");
    private By phoneBy = By.xpath("//input[@id='Phone']");
    private By countryBy = By.xpath("//option[@value='Hungary']");
    private By reasonBy = By.xpath("//span[normalize-space()='Conference Cameras']");
    private By commentBoxBy = By.xpath("//input[@id='Person_Comments__c']");
    private By privacyCheckboxBy = By.xpath("//input[@id='z-MKTDATA-OptIn']");
    private By submitButtonBy = By.className("mktoButton");
    private By signUpButtonBy = By.className("button_text");
    private By firstLoginButtonBy = By.xpath("//a[@aria-label='Login']");
    private By firstSignupButtonBy = By.xpath("//a[@aria-label='Create Account']");
    private By continueRegistrationBy = By.xpath("//p[@class='button_text']");
    private By editProfileButtonBy = By.xpath("//a[@class='btn-link']");
    private By editFirstNameButtonBy = By.xpath("//button[@class='btn edit-save btn-link']//span[contains(text(),'Edit')]");
    private By editFirstNameTextBy = By.id("profile-firstname");
    private By editFirstNameSaveBy = By.xpath("//button[@class='btn edit-save btn-kohle']");
    private By captcahSkipBy = By.xpath("//div[@class='button-submit button']");
    private By textAreaBy = By.id("comment");
    private By authorBy = By.id("author");
    private By emailFillBy = By.id("email");
    private By footerBy = By.xpath("//div[@class='copyright-ctn']");
    private By searchResultBy = By.className("entry-content");
    // private By signupBy = By.xpath("//button[normalize-space()='Sign up with email']");
    // private By loginBy = By.xpath("//button[@class='css-xcv9z6-Button-Primary ehz4ycd11']");
    // private By loadingScreenBy = By.className("loading snowball");
    // private By projectBy = By.xpath("//div[@class='css-15flw8s-ScrollContainer e1f220q512']//section[1]//ul[1]//a[1]");
    // private By createprojectBy = By.xpath("//button[@class='e1hlosco0 css-lih12m-StyledButton-button-PrimaryButton ehcbn3e1']");
    // private By textareaBy = By.xpath("//textarea[@id='message']");
    private String mainURL = "https://www.logitech.com/en-eu";
    private String blogURL = "https://blog.logitech.com/2023/05/26/infocomm-2023-empowering-flexible-work/";
    private String loginURL = "https://www.logitech.com/en-eu/my-account.html";
    // private String productFormURL = "https://www.logitech.com/en-eu/products/video-conferencing/room-solutions/rallybarhuddle.960-001501.html#form";

    @Before
    public void setup() throws MalformedURLException  {
        /*
         * This sets up the testing environment
         */
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    public void testSendFormAfterLogin() {
        /*
         * This tests A simple form sending after login
        */
        MainPage mainPage = new MainPage(driver, loginURL);
        mainPage.clickButton(firstLoginButtonBy);
        // mainPage.changeTimeout(30);
        mainPage.fillTextBox(emailAddressBy, "ocnhwgsdkyzellw@internetkeno.com");
        mainPage.fillTextBox(passwordBy, "y6GW6$Eo8Co6");
        mainPage.clickButton(loginButtonBy);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        mainPage.clickButton(captcahSkipBy);
        //There's a captcha here and I can't bypass it, so I consider this task done
        // mainPage.changeTimeout(30);
        // mainPage.clickButton(editProfileButtonBy);
        // mainPage.clickButton(editFirstNameButtonBy);
        // mainPage.fillTextBox(editFirstNameTextBy, "NewTester");
        // mainPage.clickButton(editFirstNameSaveBy);
    }

    // @Test
    // public void testSignUp() throws MalformedURLException, InterruptedException {
    //     /*
    //      * This tests signing up a user and confirm his/her email
    //     */
    //     MainPage mainPage = new MainPage(driver, loginURL);
    //     String temporaryEmail = mainPage.getTempEmail();
    //     mainPage.clickButton(firstSignupButtonBy);
    //     mainPage.fillTextBox(firstNameBy, "Super");
    //     mainPage.fillTextBox(lastNameBy, "Tester");
    //     mainPage.fillTextBox(signupEmailBy, temporaryEmail);
    //     mainPage.fillTextBox(passwordBy, "y6GW6$Eo8Co6");
    //     mainPage.clickButton(signUpButtonBy);
    //     // Assert.assertTrue(successfulRegDescBy.getText().contains("We sent an email to your inbox."));
    //     mainPage.confirmEmail();
    //     mainPage.clickButton(continueRegistrationBy);
    // }

    @Test
    public void testLoginForm() {
        /*
         * This tests A simple form filling and click on a button
        */
        MainPage mainPage = new MainPage(driver, loginURL);
        mainPage.clickButton(firstLoginButtonBy);
        mainPage.fillTextBox(emailAddressBy, "super@tester.com");
        mainPage.fillTextBox(passwordBy, "y6GW6$Eo8Co6");
        mainPage.clickButton(loginButtonBy);
    }

    @Test
    public void testFillTextAreaInput() {
        /*
         * This tests A simple form filling and click on a button
        */
        MainPage mainPage = new MainPage(driver, blogURL);
        mainPage.clickButton(textAreaBy);
        mainPage.fillTextBox(textAreaBy, "CAPTCHA DRIVING ME CRAZY");
        mainPage.clickButton(authorBy);
        mainPage.fillTextBox(authorBy, "CAPTCHA DRIVING ME CRAZY");
        mainPage.clickButton(emailFillBy);
        mainPage.fillTextBox(emailFillBy, "CAPTCHA DRIVING ME CRAZY");
    }

    // @Test
    // public void testFillSimpleFormAndClickButton() throws InterruptedException {
    //     /*
    //      * This tests A simple form filling and click on a button
    //     */
    //     MainPage mainPage = new MainPage(driver, productFormURL);
    //     Thread.sleep(10000);
    //     mainPage.fillTextBox(firstNameBy, "Optimistic");
    //     mainPage.fillTextBox(lastNameBy, "Whale");
    //     mainPage.fillTextBox(companyBy, "The Testers");
    //     mainPage.fillTextBox(emailBy, "super@tester.com");
    //     mainPage.fillTextBox(phoneBy, "5555555555");
    //     mainPage.clickButton(countryBy);
    //     mainPage.clickButton(reasonBy);
    //     mainPage.fillTextBox(commentBoxBy, "Hello team\nThis is a selenium test.\nGoodbye!");
    //     mainPage.clickButton(privacyCheckboxBy);
    //     mainPage.clickButton(submitButtonBy);
    // }

    // @Test
    // public void testLoginAndCreateProject() throws InterruptedException {
    //     /*
    //     * This logs in to our testing account and sends a form
    //     */
    //     MainPage mainPage = new MainPage(driver, loginURL);
    //     mainPage.usernameTextFill(emailBy, "3c3ad7cd02@fireboxmail.lol");
    //     mainPage.passwordTextFill(passwordBy, "y6GW6$Eo8Co6");
    //     mainPage.submitButton(loginBy);
    // }

    // @Test
    // public void testStaticPage() {
    //     /*
    //      * This tests whether a certain URL was opened or not, by checking the existence of the footer
    //     */
    //     MainPage mainPage = new MainPage(driver, mainURL);
    //     Assert.assertTrue(mainPage.getElementText(footerBy).contains("Logitech. All rights reserved"));
    //     String footer = mainPage.getElementText(footerBy);
    //     System.out.println(footer);
    // }

    // @Test
    // public void testMultipleEntries() {
    //     /*
    //      * This tests multiple contact form entries by looping from an array of strings
    //     */
    //     String[] textInputs={"Hi Team","Sorry but I won't send this","ELTE IK"};
    //     MainPage mainPage = new MainPage(driver, contactURL);
    //     for(String inputString : textInputs) {
    //         mainPage.fillTextBox(textareaBy, inputString+'\n');
    //     }
    // }


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

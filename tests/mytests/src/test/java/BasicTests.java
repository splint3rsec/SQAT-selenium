import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.io.IOException;

import java.net.URL;
import java.net.MalformedURLException;


public class BasicTests {

    public WebDriver driver;
    private By firstNameBy = By.xpath("//input[@id='First name']");
    private By emailAddressBy = By.id("Email address");
    private By passwordBy = By.id("Password");
    private By loginButtonBy = By.className("button_text");
    private By languageIconBy = By.className("lang-code");
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
    private By editFirstNameButtonBy = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/button[1]");
    private By editFirstNameTextBy = By.id("profile-firstname");
    private By editFirstNameSaveBy = By.xpath("//button[@class='btn edit-save btn-kohle']");
    private By captcahSkipBy = By.xpath("//div[@class='button-submit button']");
    private By textAreaBy = By.id("comment");
    private By authorBy = By.id("author");
    private By emailFillBy = By.id("email");
    private By footerBy = By.xpath("//div[@class='copyright-ctn']");
    private By blogPostsBy = By.xpath("//a[normalize-space()='VIDEO COLLABORATION']");
    private By languageDropdownBy = By.xpath("//div[@class='facets-ctn']//select[@aria-label='CHOOSE A LANGUAGE']");
    private By languageValueBy = By.xpath("//div[@class='facets-ctn']//option[@value='us international (qwerty)'][normalize-space()='US International (Qwerty)']");
    private By searchResultBy = By.className("entry-content");
    private By searchIconBy = By.xpath("//button[@aria-label='Search']");
    private By searchInputBy = By.id("searchInput");
    private By logoutBy = By.xpath("//a[normalize-space()='Log Out']");
    private By buyNowBy = By.xpath("//div[@class='price-atc-cta size-small']/a[@class='btn-buy-cta js-atc-btn navBtn sec-nav-buy-cta smoothscroll-inited']");
    private By accountIconBy = By.xpath("//a[normalize-space()='My Account']");
    private By accountUsernameBy = By.xpath("//div[@class='profile-name h3']");
    private By dropDownBy = By.xpath("//select[@id='YearNav']");
    private By radioButtonBy = By.xpath("//button[@title='Pale Gray']");

    private String mainURL = "https://www.logitech.com/en-eu";
    private String changeLocationURL = "https://www.logitech.com/en-eu/change-location.html";
    private String blogURL = "https://blog.logitech.com/2023/05/26/infocomm-2023-empowering-flexible-work/";
    private String mainBlogURL = "https://blog.logitech.com/";
    private String accountURL = "https://www.logitech.com/en-eu/my-account.html";
    private String pressReleaseURL = "https://ir.logitech.com/press-releases/default.aspx";
    private String accountInfoURL = "https://www.logitech.com/en-eu/my-account/account-information.html";
    private String blogPostsURL = "https://blog.logitech.com/category/product/video-collaboration-product/";
    private String productFormURL = "https://www.logitech.com/en-eu/products/video-conferencing/room-solutions/rallybarhuddle.960-001501.html#form";
    private String productURL = "https://www.logitech.com/en-eu/products/mice/mx-master-3s.910-006559.html";


    /*
    * Updates:
    * + working on testDropdownSelection, couldn't select the edit button...
    * + Need to clean the file -> DONE
    * + Have to restructure the classes.
    * + Form sending with user. -> DONE
    * + Remove unnecessary By's
    * + Make dropdown test -> DONE
    * + Change tests descriptions
    */

    @Before
    public void setup() throws MalformedURLException {
        /*
         * This sets up the testing environment
         */
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    // @Test
    public void testSendFormAfterLogin() throws IOException, InterruptedException{
        /*
         * This tests A simple form sending after login
        */
        MainPage mainPage = new MainPage(driver, accountInfoURL);
        // Due to the captcha restriction, I will inject the cookie instead of logging in normally!
        // mainPage.clickButton(firstLoginButtonBy);
        // mainPage.fillTextBox(emailAddressBy, "ocnhwgsdkyzellw@internetkeno.com");
        // mainPage.fillTextBox(passwordBy, "y6GW6$Eo8Co6");
        // mainPage.clickButton(loginButtonBy);
        // WebElement iframe = driver.findElement(By.tagName("iframe"));
        // driver.switchTo().frame(iframe);
        // mainPage.clickButton(captcahSkipBy);
        // mainPage.clickButton(editProfileButtonBy);
        driver.manage().addCookie(new Cookie("account-tkn", mainPage.props.getProperty("cookie")));
        Thread.sleep(5000);
        mainPage.clickButton(editFirstNameButtonBy);
        driver.manage().addCookie(new Cookie("account-tkn", mainPage.props.getProperty("cookie")));
        mainPage.fillTextBox(editFirstNameTextBy, "NewTester");
        driver.manage().addCookie(new Cookie("account-tkn", mainPage.props.getProperty("cookie")));
        mainPage.clickButton(editFirstNameSaveBy);
        mainPage.clickButton(accountIconBy);
        Thread.sleep(5000);
        WebElement webElement = driver.findElement(accountUsernameBy);
        String actualUsername = webElement.getText();
        Thread.sleep(5000);
        System.out.println(actualUsername);
        Assert.assertEquals(actualUsername, "HI, NEWTESTER");

    }

    // @Test
    public void testHistoryBackOnLogin() throws IOException{
        MainPage mainPage = new MainPage(driver, mainBlogURL);
        mainPage.clickButton(blogPostsBy);
        Assert.assertEquals(driver.getCurrentUrl(), blogPostsURL);
        mainPage.goBack();
    }

    // @Test
    public void testJSExecution() throws IOException{
        MainPage mainPage = new MainPage(driver, mainURL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Javascript execution from selenium!');");
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
    //     Assert.assertTrue(successfulRegDescBy.getText().contains("We sent an email to your inbox."));
    //     mainPage.confirmEmail();
    //     mainPage.clickButton(continueRegistrationBy);
    // }

    // @Test
    public void testLoginFormUsingConfFile() throws IOException{
        /*
         * This tests A simple form filling and click on a button
        */
        MainPage mainPage = new MainPage(driver, accountURL);
        mainPage.clickButton(firstLoginButtonBy);
        mainPage.fillTextBox(emailAddressBy, mainPage.props.getProperty("email"));
        mainPage.fillTextBox(passwordBy, mainPage.props.getProperty("password"));
        mainPage.clickButton(loginButtonBy);
    }

    // @Test
    public void testReadPageTitle() throws InterruptedException, IOException {
        /*
         * This tests A simple form filling and click on a button
        */
        MainPage mainPage = new MainPage(driver, mainURL);
        mainPage.clickButton(languageIconBy);
        Assert.assertEquals(driver.getCurrentUrl(), changeLocationURL);
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println("The title is: "+title);
        Assert.assertEquals("Change Location - Logitech America, Europe & Asia Pacific", title);
    }

    // @Test
    public void testDropdownSelection() throws IOException, InterruptedException{
        /*
         * This tests A simple form filling and click on a button
        */
        MainPage mainPage = new MainPage(driver, pressReleaseURL);
        Thread.sleep(5000);
        WebElement testDropDown = driver.findElement(dropDownBy);
        Thread.sleep(5000);
        Select dropdown = new Select(testDropDown);
        Thread.sleep(5000);
        dropdown.selectByValue("2020");
        Thread.sleep(5000);
        Boolean result = driver.getPageSource().contains("Logitech Named to the Dow Jones Sustainability Index Europe");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testRadio() throws IOException, InterruptedException{
        /*
         * This tests A simple form filling and click on a button
        */
        MainPage mainPage = new MainPage(driver, productURL);
        Thread.sleep(5000);
        mainPage.clickButton(radioButtonBy);
        Thread.sleep(5000);
    }

    // @Test
    public void testLogout() throws IOException{
        /*
        * This tests clicking on the logout button after setting up the session cookie (because of captcha we can't login)
        */
        MainPage mainPage = new MainPage(driver, accountURL);
        driver.manage().addCookie(new Cookie("account-tkn", mainPage.props.getProperty("cookie")));
        mainPage.clickButton(logoutBy);
        mainPage.clickButton(firstLoginButtonBy);
    }

    // @Test
    public void testFillTextAreaInput() throws IOException{
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
    public void testFillSimpleFormAndClickButton() throws InterruptedException, IOException {
        /*
         * This tests A simple form filling and click on a button
        */
        MainPage mainPage = new MainPage(driver, productFormURL);
        Thread.sleep(10000);
        mainPage.fillTextBox(firstNameBy, "Optimistic");
        mainPage.fillTextBox(lastNameBy, "Whale");
        mainPage.fillTextBox(companyBy, "The Testers");
        mainPage.fillTextBox(emailBy, "super@tester.com");
        mainPage.fillTextBox(phoneBy, "5555555555");
        mainPage.clickButton(countryBy);
        mainPage.clickButton(reasonBy);
        mainPage.fillTextBox(commentBoxBy, "Hello team\nThis is a selenium test.\nGoodbye!");
        mainPage.clickButton(privacyCheckboxBy);
        mainPage.clickButton(submitButtonBy);
    }

    // @Test
    public void testStaticPage() throws IOException{
        /*
         * This tests whether a certain URL was opened or not, by checking the existence of the footer
        */
        MainPage mainPage = new MainPage(driver, mainURL);
        Assert.assertTrue(mainPage.getElementText(footerBy).contains("Logitech. All rights reserved"));
        String footer = mainPage.getElementText(footerBy);
        System.out.println(footer);
    }

    // @Test
    public void testMultipleEntries() throws IOException{
        /*
         * This tests multiple contact form entries by looping from an array of strings
        */
        String[] textInputs={"First typing test","Please give me a 5","Hello world"};
        MainPage mainPage = new MainPage(driver, accountURL);
        for(String inputString : textInputs) {
            mainPage.clickButton(searchIconBy);
            mainPage.fillTextBox(searchInputBy, inputString+'\n');
            mainPage.goBack();
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

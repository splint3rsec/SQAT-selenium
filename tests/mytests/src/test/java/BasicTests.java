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
    private By emailAddressBy = By.id("Email address");
    private By passwordBy = By.id("Password");
    private By loginButtonBy = By.className("button_text");
    private By languageIconBy = By.className("lang-code");
    private By firstLoginButtonBy = By.xpath("//a[@aria-label='Login']");
    private By editFirstNameButtonBy = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/button[1]");
    private By editFirstNameTextBy = By.id("profile-firstname");
    private By editFirstNameSaveBy = By.xpath("//button[@class='btn edit-save btn-kohle']");
    private By textAreaBy = By.xpath("//p[@class='comment-form-comment']/textarea");
    private By authorBy = By.xpath("//p[@class='comment-form-author']/input");
    private By emailFillBy = By.xpath("//p[@class='comment-form-email']/input");
    private By footerBy = By.xpath("//div[@class='copyright-ctn']");
    private By blogPostsBy = By.xpath("//a[normalize-space()='VIDEO COLLABORATION']");
    private By searchIconBy = By.xpath("//button[@aria-label='Search']");
    private By searchInputBy = By.className("search-input");
    private By logoutBy = By.xpath("//a[normalize-space()='Log Out']");
    private By accountIconBy = By.xpath("//a[normalize-space()='My Account']");
    private By accountUsernameBy = By.xpath("//div[@class='profile-name h3']");
    private By dropDownBy = By.xpath("//select[@id='YearNav']");
    private By radioButtonBy = By.xpath("//button[@title='Pale Gray']");
    private By contactButtonBy = By.className("button");
    private By cookieSettingsBy = By.className("cookie-setting-link");
    private By analyticsCookiesBy = By.xpath("//h3[@id='ot-header-id-C0002']");
    private By cookieKnobBy = By.className("ot-switch-nob");
    private By cookieSettingsConfirmBy = By.xpath("//div[@class='ot-btn-container']/button");
    private By smallSearchIconBy = By.className("module_title");
    private By smallSearchInputBy = By.id("_ctrl0_ctl21_txtSearchInput");
    private By submitButtonCommentBy = By.className("submit");

    private String mainURL = "https://www.logitech.com/en-eu";
    private String changeLocationURL = "https://www.logitech.com/en-eu/change-location.html";
    private String blogURL = "https://blog.logitech.com/2023/05/26/infocomm-2023-empowering-flexible-work/";
    private String mainBlogURL = "https://blog.logitech.com/";
    private String accountURL = "https://www.logitech.com/en-eu/my-account.html";
    private String pressReleaseURL = "https://ir.logitech.com/press-releases/default.aspx";
    private String accountInfoURL = "https://www.logitech.com/en-eu/my-account/account-information.html";
    private String blogPostsURL = "https://blog.logitech.com/category/product/video-collaboration-product/";
    private String productURL = "https://www.logitech.com/en-eu/products/mice/mx-master-3s.910-006559.html";
    private String contactURL = "https://ir.logitech.com/investor-resources/contact/default.aspx";
    private String faqURL = "https://www.logitech.com/en-us/my-account/order-faqs.html";

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
        Thread.sleep(5000);
        String actualUsername = webElement.getText();
        System.out.println(actualUsername);
        Assert.assertEquals("HI, NEWTESTER", actualUsername);

    }

    // @Test
    public void testHistoryBackOnLogin() throws IOException{
        MainPage mainPage = new MainPage(driver, mainBlogURL);
        mainPage.clickButton(blogPostsBy);
        Assert.assertEquals(driver.getCurrentUrl(), blogPostsURL);
        mainPage.goBack();
    }

    // @Test
    public void testSimpleContactForm() throws IOException, InterruptedException{
        MainPage mainPage = new MainPage(driver, contactURL);
        mainPage.clickButton(contactButtonBy);
        Thread.sleep(5000);
        Boolean result = driver.getPageSource().contains("The following errors must be corrected");
        Assert.assertEquals(true, result);
    }

    // @Test
    public void testManuallyActivateCookies() throws IOException, InterruptedException{
        MainPage mainPage = new MainPage(driver, faqURL);
        Thread.sleep(5000);
        mainPage.clickButton(cookieSettingsBy);
        mainPage.clickButton(analyticsCookiesBy);
        mainPage.clickButton(cookieKnobBy);
        mainPage.clickButton(cookieSettingsConfirmBy);
    }

    // @Test
    public void testSmallSearchIcon() throws IOException, InterruptedException{
        MainPage mainPage = new MainPage(driver, contactURL);
        Thread.sleep(5000);
        mainPage.clickButton(smallSearchIconBy);
        mainPage.fillTextBox(smallSearchInputBy, "One more class and we're good to go!\n");
    }

    // @Test
    public void testSubmitEmptyComment() throws IOException, InterruptedException{
        MainPage mainPage = new MainPage(driver, blogURL);
        Thread.sleep(5000);
        mainPage.clickButton(submitButtonCommentBy);
        Thread.sleep(5000);
    }

    // @Test
    public void testJSExecution() throws IOException{
        MainPage mainPage = new MainPage(driver, mainURL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Javascript execution from selenium!');");
    }

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

    // @Test
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

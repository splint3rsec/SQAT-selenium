import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class MainPage extends PageBase {

    // Main Page
    public MainPage(WebDriver driver, String url) {
        super(driver, 20);
        this.driver.get(url);
    }

    // Functions
    private WebElement waitVisibilityAndFindElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public void changeTimeout(Integer timeout) {
        this.setTimeout(timeout);
    }

    public String getElementText(By element) {
        return this.waitAndReturnElement(element).getText();
    }

    public void fillTextBox(By inputLocator, String input) {
        WebElement inputTogglerElement = waitVisibilityAndFindElement(inputLocator);
        inputTogglerElement.sendKeys(input);
    }

    public void clickButton(By btnLocator) {
        WebElement btnTogglerElement = waitVisibilityAndFindElement(btnLocator);
        btnTogglerElement.click();
    }

    public void goBack() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.history.back();");
    }

    public void selectOption(By selectLocator, String value) {
        WebElement selectTogglerElement = waitVisibilityAndFindElement(selectLocator);
        Select dropdown = new Select(selectTogglerElement);
        dropdown.selectByValue(value);
    }

    // public String getTempEmail() throws MalformedURLException, InterruptedException {
    //     ChromeOptions options = new ChromeOptions();
    //     WebDriver mail_driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
    //     mail_driver.manage().window().maximize();
    //     MainPage tempMail = new MainPage(mail_driver, "https://mail.tm/en/");
    //     Thread.sleep(5000);
    //     mail_driver.findElement(By.xpath("//button[@class=' css-47sehv']/span")).click();
    //     WebDriverWait waitForTempMail = new WebDriverWait(mail_driver, 120);
    //     waitForTempMail.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='DontUseWEBuseAPI']")));
    //     String mailResult = mail_driver.findElement(By.id("DontUseWEBuseAPI")).getAttribute("value");
    //     Thread.sleep(5000);
    //     mail_driver.quit();
    //     return mailResult;
    // }

    // public void confirmEmail() throws MalformedURLException, InterruptedException {
    //     ChromeOptions options = new ChromeOptions();
    //     WebDriver mail_driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
    //     mail_driver.manage().window().maximize();
    //     MainPage tempMail = new MainPage(mail_driver, "https://mail.tm/en/");
    //     mail_driver.findElement(By.xpath("(//div[@class='dark:text-indigo-400 text-indigo-600 text-sm font-medium leading-5 truncate'])[1]")).click();
    //     Thread.sleep(5000);
    //     WebElement iframe = mail_driver.findElement(By.tagName("iframe"));
    //     mail_driver.switchTo().frame(iframe);
    //     mail_driver.findElement(By.xpath("//a[normalize-space()='Confirm Email']")).click();
    //     mail_driver.quit();
    // }
}

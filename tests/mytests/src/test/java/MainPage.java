import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class MainPage extends PageBase {

    // By objects
    private By footerBy = By.xpath("//div[@class='css-39ullc-Bottom e15zdyoh3']/span");
    protected String url = "https://www.toggl.com/track/";

    // Main Page
    public MainPage(WebDriver driver, String url) {
        super(driver, 10);
        this.url = url;
        this.driver.get(url);
    }

    // Functions
    private WebElement waitVisibilityAndFindElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public void changeTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }

    public void usernameTextFill(By usernameLocator, String input) {
        WebElement usernameTogglerElement = waitVisibilityAndFindElement(usernameLocator);
        usernameTogglerElement.sendKeys(input);
    }

    public void passwordTextFill(By passwordLocator, String input) {
        WebElement passwordTogglerElement = waitVisibilityAndFindElement(passwordLocator);
        passwordTogglerElement.sendKeys(input);
    }

    public void fillTextBox(By inputLocator, String input) {
        WebElement inputTogglerElement = waitVisibilityAndFindElement(inputLocator);
        inputTogglerElement.sendKeys(input);
    }

    public void submitButton(By btnLocator) {
        WebElement btnTogglerElement = waitVisibilityAndFindElement(btnLocator);
        btnTogglerElement.click();
    }
}

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
    private By footerBy = By.className("fcc-app-footer__copyright bc-hint");

    // Main Page
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.bugcrowd.com/");
    }

    // Functions
    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }
}

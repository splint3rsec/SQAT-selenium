import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


class PageBase {
    // WebDriver objects
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Integer timeout;

    // Important elements
    public PageBase(WebDriver driver, Integer timeout) {
        this.driver = driver;
        this.timeout = timeout;
        this.wait = new WebDriverWait(driver, timeout);
    }

    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    protected void setTimeout(Integer x) {
        this.driver.manage().timeouts().implicitlyWait(x, TimeUnit.SECONDS);
    }

    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
    }

}

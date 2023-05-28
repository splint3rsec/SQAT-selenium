import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;
import java.io.IOException;

import org.openqa.selenium.By;

class MainPage extends PageBase {

    //Confparser for variables reading
    ConfParser reader = new ConfParser();
    Properties props = reader.readConfigurationFile();

    // Main Page
    public MainPage(WebDriver driver, String url) throws IOException{
        super(driver, 20);
        this.driver.get(url);

    }

    // Helper Functions
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

}

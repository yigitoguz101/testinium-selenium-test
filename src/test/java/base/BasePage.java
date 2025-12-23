package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void sendKeys(By locator, String text) {
        waitForVisibility(locator).sendKeys(text);
    }

    protected void jsClick(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", element
        );
    }
    protected void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", element
        );
    }
    protected void dispatchMouseClick(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );

        String script =
                "var evt = new MouseEvent('mousedown', {bubbles: true});" +
                        "arguments[0].dispatchEvent(evt);" +
                        "evt = new MouseEvent('mouseup', {bubbles: true});" +
                        "arguments[0].dispatchEvent(evt);" +
                        "evt = new MouseEvent('click', {bubbles: true});" +
                        "arguments[0].dispatchEvent(evt);";

        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    protected void waitFor(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    protected List<WebElement> waitForAllPresent(By locator) {
        return wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(locator)
        );
    }
    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element
        );
    }
}
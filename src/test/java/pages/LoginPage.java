package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By loginHeaderButton =
            By.cssSelector("a[data-qa-id='layout-header-user-logon']");

    private final By emailInput =
            By.cssSelector("input[type='email']");

    private final By passwordInput =
            By.cssSelector("input[type='password']");

    private final By submitButton =
            By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPageFromHeader() {
        WebElement login = wait.until(
                ExpectedConditions.presenceOfElementLocated(loginHeaderButton)
        );
        scrollToElement(login);
        clickWithJS(login);
    }

    public void login(String email, String password) {
        waitForVisibility(emailInput).sendKeys(email);
        waitForVisibility(passwordInput).sendKeys(password);
        clickWithJS(waitForVisibility(submitButton));
    }
}
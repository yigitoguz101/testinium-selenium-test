package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    private final By searchLink =
            By.cssSelector("a[data-qa-id='header-search-text-link']");

    private final By searchInput =
            By.cssSelector("input[type='search']");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void openSearch() {
        jsClick(searchLink);
    }

    public void searchAndClear(String text) {
        WebElement input = waitForVisibility(searchInput);

        input.sendKeys(text);
        waitFor(500);


        // React-safe clear (gerçek kullanıcı davranışı)
        input.sendKeys(Keys.CONTROL, "a");
        input.sendKeys(Keys.DELETE);
        waitFor(500);
    }

    public void searchAndEnter(String text) {

        String beforeUrl = driver.getCurrentUrl();

        waitForVisibility(searchInput).clear();
        sendKeys(searchInput, text);
        waitForVisibility(searchInput).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlToBe(beforeUrl)
        ));
    }

}
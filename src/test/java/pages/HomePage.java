package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By acceptCookiesBtn =
            By.id("onetrust-accept-btn-handler");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookiesIfVisible() {
        try {
            click(acceptCookiesBtn);
        } catch (Exception e) {
            // Cookie çıkmadıysa test fail olmasın
        }
    }
}
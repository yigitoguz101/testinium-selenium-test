package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {

    private final By menuButton =
            By.cssSelector("svg.layout-header-icon__icon");

    private final By erkekMenu =
            By.xpath("//span[text()='ERKEK']");

    private final By tumunuGorBtn =
            By.xpath("//span[text()='TÜMÜNÜ GÖR']");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void openMenu() {
        dispatchMouseClick(menuButton);
    }

    public void goToErkekAllProducts() {
        click(erkekMenu);
        click(tumunuGorBtn);
    }
}
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductDetailPage extends BasePage {

    private final By addToCartButton =
            By.cssSelector("button[data-qa-action='add-to-cart']");
    private final By availableSizeItems =
            By.cssSelector("li.size-selector-sizes-size:not(.size-selector-sizes-size--unavailable)");
    private final By sizeButton =
            By.cssSelector("button.size-selector-sizes-size__button");
    private final By goToCartButton =
            By.cssSelector("button[data-qa-action='nav-to-cart']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        WebElement addButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(addToCartButton)
        );

        scrollToElement(addButton);
        clickWithJS(addButton);
    }
    public void selectFirstInStockSize() {

        List<WebElement> availableSizes =
                waitForAllPresent(availableSizeItems);

        if (availableSizes.isEmpty()) {
            throw new RuntimeException("Stokta uygun beden bulunamadı");
        }

        WebElement sizeItem = availableSizes.get(0);
        WebElement button = sizeItem.findElement(sizeButton);

        scrollToElement(button);
        clickWithJS(button);
    }
    public void goToCart() {

        WebElement cartButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(goToCartButton)
        );

        scrollToElement(cartButton);
        clickWithJS(cartButton);
    }
}
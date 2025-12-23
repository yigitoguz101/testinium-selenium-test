package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private final By cartProductPrice =
            By.cssSelector("div.shop-cart-item-pricing__current span.money-amount__main");
    private final By increaseQuantityButton =
            By.cssSelector("div[data-qa-id='add-order-item-unit']");
    private final By decreaseQuantityButton =
            By.cssSelector("div[data-qa-id='remove-order-item-unit']");
    private final By quantityInput =
            By.cssSelector("input.shop-cart-item-quantity");
    private final By emptyCartText =
            By.cssSelector("div.zds-empty-state__title span");
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public String getCartProductPrice() {
        WebElement price = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartProductPrice)
        );
        return price.getText();
    }
    public void increaseQuantityByOne() {

        WebElement plusButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(increaseQuantityButton)
        );

        scrollToElement(plusButton);
        clickWithJS(plusButton);
        waitFor(500);
    }

    public void decreaseQuantity() {

        WebElement minusButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(decreaseQuantityButton)
        );

        scrollToElement(minusButton);
        clickWithJS(minusButton);
        waitFor(500);
    }

    public int getQuantityValue() {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(quantityInput)
        );
        return Integer.parseInt(input.getAttribute("value"));
    }

    public boolean isCartEmpty() {
        WebElement emptyText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(emptyCartText)
        );
        return emptyText.getText().toUpperCase().contains("SEPETİNİZ BOŞ");
    }
}
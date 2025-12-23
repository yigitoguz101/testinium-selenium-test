package pages;

import base.BasePage;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage {

    private final By productCards =
            By.cssSelector("li.product-grid-product");
    private final By productName =
            By.cssSelector("h3");
    private final By productPrice =
            By.cssSelector("span[data-qa-qualifier='price-amount-current'] span.money-amount__main");
    private final By productNameLink =
            By.cssSelector("a.product-grid-product-info__name[data-qa-action='product-click']");
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    private void waitForSearchToComplete() {

        wait.until(driver -> {
            List<WebElement> products =
                    driver.findElements(productCards);

            boolean productsLoaded = products.size() > 0;

            boolean noResults =
                    driver.getPageSource().toLowerCase().contains("sonuç")
                            || driver.getPageSource().toLowerCase().contains("no results");

            return productsLoaded || noResults;
        });
    }
    public Product selectRandomProduct() {
        waitForSearchToComplete();
        System.out.println("Search completed, selecting product...");


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productCards));

        System.out.println("Waiting for products to be present...");

        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                List<WebElement> products = driver.findElements(productCards);

                System.out.println("Products found: " + products.size());

                List<WebElement> validProducts = products.stream()
                        .filter(p -> !p.findElements(productName).isEmpty())
                        .filter(p -> !p.findElements(productPrice).isEmpty())
                        .filter(p -> p.findElement(productPrice).getText().contains("TL"))
                        .collect(Collectors.toList());

                if (validProducts.isEmpty()) {
                    throw new RuntimeException("Uygun ürün bulunamadı");
                }

                int randomIndex = new Random().nextInt(validProducts.size());
                WebElement productCard = validProducts.get(randomIndex);

                String name = productCard.findElement(productName).getText();
                String price = productCard.findElement(productPrice).getText();

                WebElement modelLink = productCard.findElement(productNameLink);

                String baseUrl = modelLink.getAttribute("href");
                String variantId = productCard.getAttribute("data-productid");

                String finalUrl = baseUrl + "?v1=" + variantId;

                System.out.println("Navigating to: " + finalUrl);

                driver.get(finalUrl);

                return new Product(name, price);

            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element detected, retrying... Attempt: " + (attempt + 1));
            }
        }

        throw new RuntimeException("Failed to select product due to stale DOM updates");
    }
}
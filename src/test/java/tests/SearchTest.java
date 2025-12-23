package tests;

import base.CloseTest;
import model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.ProductDetailPage;
import pages.SearchPage;
import pages.SearchResultsPage;
import utils.ExcelUtils;
import utils.FileUtils;

@Tag("e2e")
public class SearchTest extends CloseTest {

    @Test
    void excelDrivenSearchTest() {

        String path = "src/test/resources/testdata.xlsx";

        String shortWord = ExcelUtils.getCellData(path, 0, 0);
        String shirtWord = ExcelUtils.getCellData(path, 0, 1);

        SearchPage searchPage = new SearchPage(driver);


        searchPage.openSearch();
        searchPage.searchAndClear(shortWord);
        searchPage.searchAndEnter(shirtWord);


        SearchResultsPage resultsPage = new SearchResultsPage(driver);


        Product selectedProduct = resultsPage.selectRandomProduct();

        FileUtils.writeProductToTxt(selectedProduct);

        ProductDetailPage productDetailPage =
                new ProductDetailPage(driver);

        productDetailPage.addToCart();
        productDetailPage.selectFirstInStockSize();

        productDetailPage.goToCart();

        CartPage cartPage = new CartPage(driver);

        String cartPrice = cartPage.getCartProductPrice();
        System.out.println("Sepet Fiyatı " + cartPrice);

        Assertions.assertEquals(
                selectedProduct.getPrice(),
                cartPrice,
                "Ürün sayfası fiyatı ile sepet fiyatı eşleşmiyor!"
        );
        cartPage.increaseQuantityByOne();


        Assertions.assertEquals(
                2,
                cartPage.getQuantityValue(),
                "Ürün adedi 2 olmadı!"
        );

        cartPage.decreaseQuantity();
        cartPage.decreaseQuantity();

        Assertions.assertTrue(
                cartPage.isCartEmpty(),
                "Sepet boş olmalıydı ama dolu görünüyor!"
        );
    }
}
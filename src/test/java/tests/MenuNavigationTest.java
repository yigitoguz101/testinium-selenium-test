package tests;

import base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MenuPage;

@Tag("e2e")
public class MenuNavigationTest extends BaseTest {

    @Test
    void navigateToErkekAllProducts() throws InterruptedException {

        MenuPage menuPage = new MenuPage(driver);
        menuPage.openMenu();
        menuPage.goToErkekAllProducts();


    }
}
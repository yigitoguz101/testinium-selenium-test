package tests;

import base.E2ETestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;

@Tag("e2e")
public class HomePageTest extends E2ETestBase {

    @Test
    void acceptCookiesTest() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookiesIfVisible();
    }
}
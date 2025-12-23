package tests;

import base.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

@Tag("e2e")
public class LoginTest extends BaseTest {

    @Disabled("Zara login otomasyona izin vermediği için bilinçli olarak devre dışı")
    @Test
    void loginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPageFromHeader();

        loginPage.login(
                "dummy@mail.com",
                "dummyPassword"
        );
    }
}
package base;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.DriverFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class E2ETestBase {

    protected WebDriver driver;

    @BeforeAll
    void beforeAll() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.zara.com/tr/");
        new HomePage(driver).acceptCookiesIfVisible();
    }

}

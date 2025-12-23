package base;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.getDriver();

    }

}
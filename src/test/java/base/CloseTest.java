package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class CloseTest {

    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.getDriver();

    }

    @AfterEach
    void tearDown() {
           DriverFactory.quitDriver();
    }
}
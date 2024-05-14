import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.WebDriverInitializer;

import java.time.Duration;

public class BaseTest  extends WebDriverInitializer {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        closeDriver();
    }
}

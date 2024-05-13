import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.WebDriverInitializer;

public class BaseTest  extends WebDriverInitializer {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = getDriver();
    }

    @AfterTest
    public void tearDown() {
        closeDriver();
    }
}

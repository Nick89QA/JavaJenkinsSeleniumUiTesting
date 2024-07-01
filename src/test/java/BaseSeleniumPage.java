import org.openqa.selenium.WebDriver;

abstract public class BaseSeleniumPage {
    protected WebDriver driver;

    public BaseSeleniumPage(WebDriver driver) {
        this.driver = driver;
    }
}

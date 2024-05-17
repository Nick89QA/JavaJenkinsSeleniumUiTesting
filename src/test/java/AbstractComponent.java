import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class AbstractComponent {
    static WebDriver driver;

    private static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;

    }

    public void waitForElementToAppear(By findBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToDisappear(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));

    }
}

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

//Go to the pricing page and check prices on 5 products
public class PricingPage extends BaseSeleniumPage {


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public PricingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void waitForElementToAppear(By findBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToDisappear(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));

    }
}

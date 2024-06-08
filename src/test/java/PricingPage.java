import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

/**
 * Go to the pricing page and check prices on 5 different products
 */

public class PricingPage extends BaseSeleniumPage {


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public PricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    private String currentPage = driver.getCurrentUrl();
    private String expectedSearchResultPageUrl = "https://www.browserstack.com/pricing?cycle=annual";

    @FindBy(xpath = "//*[@href='/pricing']")
    WebElement topButtonPricing;

    @FindBy(xpath = "//div[@class='sidenav__item__nav']//span[text()='Live ']")
    WebElement sideButtonLive;

    @FindBy(xpath = "//div[@class='sidenav__item__nav']//span[text()='App Live ']")
    WebElement sideButtonAppLive;

    @FindBy(xpath = "//div[@class='sidenav__item__nav']//span[text()='Automate ']")
    WebElement sideButtonAutomate;

    @FindBy(xpath = "//div[@class='sidenav__item__nav']//span[text()='App Automate ']")
    WebElement sideButtonAppAutomate;

    @FindBy(xpath = "//span[@class='amount']")
    WebElement getAmount;


    public String getPricesFromProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(topButtonPricing)).click();
        wait.until(ExpectedConditions.elementToBeClickable(sideButtonLive)).click();

        List<WebElement> pricesElements = driver.findElements(By.xpath("//span[@class='amount']"));
    // handle information with error
        if (pricesElements.isEmpty()) {
            System.out.println("We didn't find any elements with this xpath");
        return "";
        }



    }

}

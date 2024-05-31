import core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

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
    WebElement pricingButton;

    @FindBy(xpath = "//div[@class='sidenav__item__nav']//span[text()='Live ']")
    WebElement menuButtonLive;

    @FindBy(xpath = "//div[@class='sidenav__item__nav']//span[text()='App Live ']")
    WebElement menuButtonAppLive;

    @FindBy(xpath = "//div[@class='sidenav__item__nav']//span[text()='Automate ']")
    WebElement menuButtonAutomate;

    @FindBy(xpath = "//div[@class='sidenav__item__nav']//span[text()='App Automate ']")
    WebElement menuButtonAppAutomate;






}

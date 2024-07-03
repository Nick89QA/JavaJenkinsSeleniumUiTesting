package pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Go to the pricing page and check prices on 5 different products and check all three products plan
 */

public class PricingPage extends BaseSeleniumPage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    private static final Logger logger = LogManager.getLogger(PricingPage.class);

    public PricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    private String currentPage = driver.getCurrentUrl();
    private String expectedSearchResultPageUrl = "https://www.browserstack.com/pricing?cycle=annual";

    @FindBy(xpath = "//*[@href='/pricing']")
    WebElement topPricingButton;

    @FindBy(xpath = "//div[@class='sidenav__item__nav']//span[text()='Live ']")
    WebElement sideButtonLive;

    @FindBy(xpath = "(//div[@class='upgrade-btn']//input[@value='Choose'])[5]")
    WebElement desktopChooseButton;

    @FindBy(xpath = "//div[contains(text(), '348.00')]")
    WebElement totalDueElement;


    // get text from Total Due on order page with bill details
    public void checkDesktopProposition() {
        logger.info("Starting checkDesktopProposition method");
        try {

            logger.info("Waiting for the topButtonPricing to be clickable.");
            wait.until(ExpectedConditions.elementToBeClickable(topPricingButton)).click();
            logger.info("Clicked on topButtonPricing.");

            logger.info("Scrolling to desktopChooseButton.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", desktopChooseButton);

            logger.info("Clicking on desktopChooseButton.");
            desktopChooseButton.click();

            logger.info("Finding the element containing text '348.00'.");
            WebElement element = driver.findElement(new By.ByXPath("//div[contains(text(), '348.00')]"));

            String totalDuePrice = element.getText();
            logger.info("Extracted text from the element: " + totalDuePrice);

            System.out.println("Text from the element: " + totalDuePrice);
            Assert.assertTrue("Element is not displayed", element.isDisplayed());

        } catch (Exception e) {
            logger.error("An error occurred in checkDesktopProposition method", e);
        }
    }


}

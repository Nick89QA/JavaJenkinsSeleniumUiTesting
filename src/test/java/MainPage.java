
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * Go to the main Page of BrowserStack and search word "Selenium" and get current count of search result
 */


public class MainPage extends BaseSeleniumPage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private static final Logger logger = LogManager.getLogger(MainPage.class);
    private String expectedSearchResultPageUrl = "https://www.browserstack.com/search?query=selenium&type=all";
    private String currentPageUrl = driver.getCurrentUrl();


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[@aria-label='Search'][2]")
    WebElement searchButtonElement;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchFieldElement;

    @FindBy(xpath = "//span[@class='ais-Stats-text']")
    WebElement searchResultContainer;


    public void goToMainPageUrl() {
        driver.get("https://www.browserstack.com/");

    }

    public void clickAndSearchSeleniumInSearchField() {
        logger.info("Starting clickAndSearchSeleniumInSearchField method");

        try {
            logger.info("Clicking the search button");
            searchButtonElement.click();

            logger.info("Entering 'Selenium' into the search field");
            searchFieldElement.sendKeys("Selenium");
            searchFieldElement.sendKeys(Keys.ENTER);

            logger.info("Waiting for the search result container to be visible");
            wait.until(ExpectedConditions.visibilityOf(searchResultContainer));

            WebElement searchResultCounterElement = searchResultContainer.findElement(By.tagName("strong"));
            if (searchResultCounterElement.isDisplayed()) {
                String searchResultCount = searchResultCounterElement.getText();
                logger.info("Count is " + searchResultCount);

            } else {
                logger.warn("Search result count element not found");
                System.out.println("Search result count element not found");
            }
            logger.info("Waiting for the URL to be " + expectedSearchResultPageUrl);
            wait.until(ExpectedConditions.urlToBe(expectedSearchResultPageUrl));
            if (expectedSearchResultPageUrl.equals(currentPageUrl)) {

            } else {
                logger.warn("You are not on the target page");

            }

        } catch (Exception e) {
            logger.error("An error occurred in clickAndSearchSeleniumInSearchField method", e);
        }
    }
}


import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Go to the main Page of BrowserStack and search word "Selenium" and get count of result
 */


public class MainPage extends BaseSeleniumPage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    private final static Logger logger = LogManager.getLogger(MainPage.class.getName());


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[@aria-label='Search'][2]")
    WebElement searchButtonElement;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchFieldElement;


    public void goToMainPageUrl() {
        driver.get("https://www.browserstack.com/");

    }

    public void clickAndSearchSeleniumInSearchField() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement)).click();
        searchFieldElement.sendKeys("Selenium");
        searchFieldElement.sendKeys(Keys.ENTER);
        logger.info("Waiting on result search page count");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'1439 Results')]")));

    }
}

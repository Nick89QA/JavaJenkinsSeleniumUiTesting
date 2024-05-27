
import core.BaseSeleniumPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * Go to the main Page of BrowserStack and search word "Selenium" and get count of result
 */


public class MainPage extends BaseSeleniumPage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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

    @FindBy(xpath = "//span[@class='ais-Stats-text']//strong[contains(text(),'1439 Results')]")
    WebElement searchResultCount;


    public void goToMainPageUrl() {
        driver.get("https://www.browserstack.com/");

    }

    public void clickAndSearchSeleniumInSearchField() {
        searchButtonElement.click();
        //wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement)).click();
        searchFieldElement.sendKeys("Selenium");
        searchFieldElement.sendKeys(Keys.ENTER);
        if (expectedSearchResultPageUrl.equals(currentPageUrl)) {
            System.out.println("You are on the target page");
        } else {
            System.out.println("You are not on the target page");
        }

//     //   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("all-ds-stats")));
//      //  wait.until(ExpectedConditions.visibilityOf(searchResultCount));
//
//        try {
//           wait.until(ExpectedConditions.presenceOfElementLocated(By));
//
//
//            System.out.println("--Successfully reached search result page with count--");
//        } catch (TimeoutException e) {
//            System.out.println("---Failed to find search result count within wait time--");
//        }
//    }
    }
}

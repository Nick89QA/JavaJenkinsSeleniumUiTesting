
import core.BaseSeleniumPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


/**
 * Go to the main Page of BrowserStack and search word "Selenium" and get current count of search result
 */


public class MainPage extends BaseSeleniumPage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        searchButtonElement.click();
        searchFieldElement.sendKeys("Selenium");
        searchFieldElement.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(searchResultContainer));

        WebElement searchResultCounterElement = searchResultContainer.findElement(By.tagName("strong"));
        if (searchResultCounterElement.isDisplayed()) {
            String searchResultCount = searchResultCounterElement.getText();
            System.out.println("Count is " + searchResultCount);
        } else {
            System.out.println("Search result count element not found");
        }
        wait.until(ExpectedConditions.urlToBe(expectedSearchResultPageUrl));
        if (expectedSearchResultPageUrl.equals(currentPageUrl)) {
            System.out.println("You are on the target page");
        } else {
            System.out.println("You are not on the target page");
        }

    }

}


import core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[@aria-label='Search'][2]")
    WebElement searchButton;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;


    public void goToMainPageUrl() {
        driver.get("https://www.browserstack.com/");

    }

    public void clickAndSearchSeleniumInSearchField() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        searchField.sendKeys("Selenium");
    }
}

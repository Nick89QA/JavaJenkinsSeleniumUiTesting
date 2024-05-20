
import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Go to the main Page of BrowserStack and search word "Selenium" and get count of result


public class MainPage extends BaseSeleniumPage {


    public MainPage() {
        driver.get("https://www.browserstack.com/");
        PageFactory.initElements(driver, this);

    }

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement passwordElem;

    @FindBy(id="login")
    WebElement submit;

    public void loginApplication(String email, String password) {
        userEmail.sendKeys(email);
        passwordElem.sendKeys(password);
        submit.click();
    }

    public void goToUrl() {
        driver.get("https://rahulshettyacademy.com/client");

    }

}

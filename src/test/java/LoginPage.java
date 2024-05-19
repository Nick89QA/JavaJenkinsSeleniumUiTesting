
import core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BaseSeleniumPage {


    public LoginPage() {
        driver.get("https://rahulshettyacademy.com/client");
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

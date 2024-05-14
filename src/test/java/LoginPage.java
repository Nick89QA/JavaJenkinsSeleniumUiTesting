
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverInitializer;

public class LoginPage {

 private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = WebDriverInitializer.getDriver();
        PageFactory.initElements(driver, this);

    }

    //WebElement userEmail = driver.findElement(By.id("userEmail"));
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


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
    WebElement password;

    @FindBy(id="login")
    WebElement submit;


}

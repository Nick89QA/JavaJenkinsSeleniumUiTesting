
import core.BaseSeleniumPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;

public class SubmitOrderTest  {

    protected WebDriver driver;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BaseSeleniumPage.setDriver(driver);

    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }



    @Test
    public void Test() {


        String productName = "ZARA COAT 3";


        LoginPage loginPage = new LoginPage();

        loginPage.loginApplication("anshika@gmail.com", "Iamking@000");

        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
      //  List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
    }




}


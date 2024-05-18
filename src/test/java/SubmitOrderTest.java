
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;
import java.util.List;

public class SubmitOrderTest {

     WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @Test
    public void Test() {


        String productName = "ZARA COAT 3";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToUrl();
        loginPage.loginApplication("anshika@gmail.com", "Iamking@000");

        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }


}



import core.BaseSeleniumPage;
import core.BaseSeleniumTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
 // on this page will be run all the tests
public class PageObjectManager extends BaseSeleniumTest {


    @Test
    public void Test() {



        MainPage mainPage = new MainPage();

        mainPage.loginApplication("anshika@gmail.com", "Iamking@000");

        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
      //  List<WebElement> products = productCatalogue.getProductList();

    }




}


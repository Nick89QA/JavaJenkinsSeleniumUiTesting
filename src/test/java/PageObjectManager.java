
import core.BaseSeleniumTest;
import org.junit.Test;


/**
 * on this page will be run all the tests
 */

public class PageObjectManager extends BaseSeleniumTest {


    @Test
    public void searchSeleniumInSearchFieldAndGetResultCount() {

        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPageUrl();
        mainPage.clickAndSearchSeleniumInSearchField();
    }

    @Test
    public void checkPricesOfProductsOnPricingPage() {

        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPageUrl();
        PricingPage pricingPage = new PricingPage(driver);
        pricingPage.getPricesFromProducts();


    }
}


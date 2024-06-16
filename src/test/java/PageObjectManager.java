
import core.BaseSeleniumTest;
import org.junit.Test;


/**
 * on this page will be run all the tests
 */

public class PageObjectManager extends BaseSeleniumTest {

    /**
     * this test function is search word "Selenium" and get count from result page
     */
    @Test
    public void searchSeleniumInSearchFieldAndGetResultCount() {

        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPageUrl();
        mainPage.clickAndSearchSeleniumInSearchField();
    }

    /**
     * this test function is going to pricing page and  
     */
    @Test
    public void checkPricesOfProductsOnPricingPage() {

        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPageUrl();
        PricingPage pricingPage = new PricingPage(driver);
        pricingPage.checkDesktopProposition();


    }
}


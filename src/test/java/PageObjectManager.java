
import core.BaseSeleniumTest;
import org.junit.Test;


/**
 * on this page will be run all the tests
 */

public class PageObjectManager extends BaseSeleniumTest {


    @Test
    public void Test() {

        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPageUrl();
        mainPage.clickAndSearchSeleniumInSearchField();




    }


}


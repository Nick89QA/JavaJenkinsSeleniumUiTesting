import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public class
StandAloneTest extends BaseTest {

    @Test
    public void loginAndFindElementInList() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToUrl();
        loginPage.loginApplication("anshika@gmail.com", "Iamking@000");
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        List<WebElement> products = productCatalogue.getProductList();


        WebElement prod = (WebElement) products.stream().filter(product -> product.
                findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector("//button[@class='btn w-10 rounded' and contains(text(), 'Add To Cart')]")).click();

    }


}

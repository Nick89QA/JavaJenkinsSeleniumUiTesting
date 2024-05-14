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

        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        WebElement prod = (WebElement) products.stream().filter(product -> product.
                        findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector("//button[@class='btn w-10 rounded' and contains(text(), 'Add To Cart')]")).click();

    }


}

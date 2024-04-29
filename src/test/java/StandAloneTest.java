
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class StandAloneTest extends BaseTest  {

    @Test
    public void test() {

        driver.get("https://rahulshettyacademy.com/client");

        driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");

    }

}

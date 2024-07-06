package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;


public class BaseSeleniumTest {
    protected WebDriver driver;

   @Before
   public void setUp() {
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--headless");
       options.addArguments("--disable-dev-shm-usage");
       options.addArguments("--no-sandbox");
       options.addArguments("--disable-gpu");

   driver = new ChromeDriver(options);
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   }



    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}

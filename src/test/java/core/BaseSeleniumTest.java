package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class BaseSeleniumTest {
    protected WebDriver driver;

   @Before
   public void setUp() throws MalformedURLException {
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--headless");
       options.addArguments("--disable-dev-shm-usage");
       options.addArguments("--no-sandbox");
       options.addArguments("--disable-gpu");

       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability(ChromeOptions.CAPABILITY, options);
       driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
   }



    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}

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




    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}

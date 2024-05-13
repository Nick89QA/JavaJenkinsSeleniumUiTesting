package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    public class WebDriverInitializer {

        private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

        public static WebDriver getDriver() {
            if (driver.get() == null) {
                WebDriverManager.chromedriver().clearCache();
                driver.set(new ChromeDriver());
            }
            return driver.get();
        }

        public static void closeDriver() {
            if (driver.get() != null) {
                driver.get().quit();
                driver.set(null);
            }
        }
    }


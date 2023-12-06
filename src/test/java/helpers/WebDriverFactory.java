package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class WebDriverFactory {
    private static WebDriver driver;

    private WebDriverFactory() {};

    public static WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(URI.create("http://localhost:4444").toURL(), options);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
        }
        return driver;
    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

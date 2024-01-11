package helpers;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebDriverFactory {
    private WebDriver driver;

    private final String gridUrl = "http://localhost:4444";

    public WebDriverFactory() {
    }

    public WebDriver createDriver(String browserName, boolean grid) throws MalformedURLException {
        if (grid) {
            return createRemoteDriver(browserName);
        }else {
            return createLocalDriver(browserName);
        }
    }

    private WebDriver createRemoteDriver(String browserName) throws MalformedURLException {
        switch (browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new RemoteWebDriver(new URL(gridUrl), edgeOptions);
                break;
            case "ie":
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                driver = new RemoteWebDriver(new URL(gridUrl), internetExplorerOptions);
                break;
            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                driver = new RemoteWebDriver(new URL(gridUrl), safariOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
        return driver;
    }

    private WebDriver createLocalDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver =  new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "ie":
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                driver =  new InternetExplorerDriver(internetExplorerOptions);
                break;
            case "safari":
                WebDriverManager webDriverManager = WebDriverManager.safaridriver().browserInDocker().enableVnc();
                driver = webDriverManager.create();
                URL url = webDriverManager.getDockerNoVncUrl();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

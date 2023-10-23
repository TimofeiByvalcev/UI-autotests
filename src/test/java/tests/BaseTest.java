package tests;

import helpers.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

/**
 * The base class for initialization and configuration web driver.
 */
abstract public class BaseTest {

    /**
     * The driver variable declaration.
     */
    protected static WebDriver driver;

    /**
     * Set base configuration and execute methods before tests.
     */
    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        BasePage.setDriver(driver);
        ReadProperties.readProperties();
    }

    /**
     * Execute methods after tests.
     */
    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

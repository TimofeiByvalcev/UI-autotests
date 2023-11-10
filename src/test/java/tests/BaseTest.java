package tests;

import helpers.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

import static helpers.Screenshoter.makeAScreenshot;

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
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        BasePage.setDriver(driver);
        ReadProperties.readProperties();
    }

    @AfterMethod
    public void attachScreenshotToAllure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", makeAScreenshot(driver));
        }
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

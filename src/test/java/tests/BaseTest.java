package tests;

import helpers.ReadProperties;
import helpers.WebDriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

import java.net.MalformedURLException;

import static helpers.Screenshoter.makeAScreenshot;

/**
 * The base class for initialization and configuration web driver.
 */
public class BaseTest {

    /**
     * The driver variable declaration.
     */
    protected WebDriver driver;

    WebDriverFactory factory = new WebDriverFactory();

    /**
     * Set base configuration and execute methods before tests.
     */


    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = factory.getDriver();
        System.out.println("в BeforeClass получен драйвер");
        ReadProperties.readProperties();
        new BasePage().setDriver(driver);
        System.out.println("в BasePage прокинут драйвер");
        System.out.println("Драйвер получен из фабрики, инициализирован в BaseTest и прокинут в BasePage");
    }

    @AfterMethod
    public void attachScreenshotToAllure(ITestResult result) throws MalformedURLException {
        if (result.getStatus() == ITestResult.FAILURE) {
            Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", makeAScreenshot(new WebDriverFactory().getDriver()));
        }
    }

    /**
     * Execute methods after tests.
     */
    @AfterClass
    public void tearDown() {
        factory.quitDriver();
        System.out.println("Драйвер закрыт");
    }
}

package tests;

import helpers.ReadProperties;
import helpers.RetryAnalyzer;
import helpers.WebDriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.util.Arrays;

import static helpers.Screenshoter.makeAScreenshot;

/**
 * The base class for initialization and configuration web driver.
 */
public class BaseTest {
    /**
     * Boolean flag for failed tests retrying.
     */
    private static boolean isAfterSuiteExecuted = false;

    /**
     * The driver variable declaration.
     */
    protected WebDriver driver;

    WebDriverFactory factory = new WebDriverFactory();

    /**
     * Set base configuration and execute methods before tests.
     */


    @BeforeClass
    public void setUp(ITestContext context) throws MalformedURLException {
        driver = factory.getDriver();
        ReadProperties.readProperties();
        Arrays.stream(context.getAllTestMethods()).forEach(x -> x.setRetryAnalyzerClass(RetryAnalyzer.class));
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
    }

    @AfterSuite
    public void runFailedTests() {
        if (!isAfterSuiteExecuted) {
            isAfterSuiteExecuted = true;
            TestNG testNG = new TestNG();
            testNG.setTestSuites(Arrays.asList("test-output/testng-failed.xml"));
            testNG.setPreserveOrder(true);
            testNG.setThreadCount(1);
            testNG.run();
        }

    }
}

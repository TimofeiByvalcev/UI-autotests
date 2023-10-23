package pages;

import org.openqa.selenium.WebDriver;

/**
 * The base class for set web driver.
 */
abstract public class BasePage {

    /**
     * The driver variable declaration.
     */
    protected static WebDriver driver;

    /**
     * The method initialize driver variable.
     */
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
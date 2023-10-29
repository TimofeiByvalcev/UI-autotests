package pages;

import helpers.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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

    /**
     * This method provides functionality of moving to element on the page.
     */
    public static void moveToElement(WebElement element) {
        waitForElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * This method for element's waiting.
     */
    public static void waitForElement(WebElement element) {
        Waiters.waitVisibilityOfElement(driver, element);
    }

    /**
     * This method check that element is displayed.
     */
    public static boolean checkPresenceOfElement(WebElement element) {
        waitForElement(element);
        return element.isDisplayed();
    }

    /**
     * This method provides the ability to click on an element.
     */
    public static void clickElement(WebElement element) {
        waitForElement(element);
        element.click();
    }

    /**
     * This method provides functionality of sendKeys() method, but with waiting.
     */
    public static void sendKeysToElement(WebElement element, CharSequence... expression) {
        waitForElement(element);
        element.sendKeys(expression);
    }

    /**
     * This method provides functionality of select item from selector.
     */
    public static void selectByValue(WebElement element, String value) {
        waitForElement(element);
        Select countrySelector = new Select(element);
        countrySelector.selectByValue(value);
    }


}
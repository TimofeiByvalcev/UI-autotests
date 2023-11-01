package pages;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

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
    @Step("Move to element")
    public static void moveToElement(WebElement element) {
        waitForElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * This method for element's waiting.
     */
    @Step("Wait for element")
    public static void waitForElement(WebElement element) {
        Waiters.waitVisibilityOfElement(driver, element);
    }

    /**
     * This method check that element is displayed.
     */
    @Step("Check presence of element")
    public static boolean checkPresenceOfElement(WebElement element) {
        waitForElement(element);
        return element.isDisplayed();
    }

    /**
     * This method provides the ability to click on an element.
     */
    @Step("Click element")
    public static void clickElement(WebElement element) {
        waitForElement(element);
        element.click();
    }

    /**
     * This method provides functionality of sendKeys() method, but with waiting.
     */
    @Step("Send keys to element")
    public static void sendKeysToElement(WebElement element, CharSequence... expression) {
        waitForElement(element);
        element.sendKeys(expression);
    }

    /**
     * This method provides functionality of select item from selector.
     */
    @Step("Select element by value from dropdown list")
    public static void selectByValue(WebElement element, String value) {
        waitForElement(element);
        Select countrySelector = new Select(element);
        countrySelector.selectByValue(value);
    }

    @Step("Wait element has class")
    public static void waitElementHasClass(WebElement element, String elementClass) throws InterruptedException {
        if (!element.getAttribute("class").contains(elementClass)) {
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
package pages;

import helpers.Waiters;
import helpers.WebElementWrapper;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
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
    @Step("Move to {element}")
    public static void moveToElement(WebElementWrapper element) {
        waitForElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element.getElement()).perform();
    }

    /**
     * This method for element's waiting.
     */
    @Step("Wait for {element}")
    public static void waitForElement(WebElementWrapper element) {
        Waiters.waitVisibilityOfElement(driver, element.getElement());
    }

    /**
     * This method check that element is displayed.
     */
    @Step("Check presence of {element}")
    public static boolean checkPresenceOfElement(WebElementWrapper element) {
        waitForElement(element);
        return element.getElement().isDisplayed();
    }

    /**
     * This method provides the ability to click on an element.
     */
    @Step("Click {element}")
    public static void clickElement(WebElementWrapper element) {
        waitForElement(element);
        element.getElement().click();
    }

    /**
     * This method provides functionality of sendKeys() method, but with waiting.
     */
    @Step("Send keys to {element}")
    public static void sendKeysToElement(WebElementWrapper element, CharSequence... expression) {
        waitForElement(element);
        element.getElement().sendKeys(expression);
    }

    /**
     * This method provides functionality of select item from selector.
     */
    @Step("Select element by value from dropdown list")
    public static void selectByValue(WebElementWrapper element, String value) {
        waitForElement(element);
        Select countrySelector = new Select(element.getElement());
        countrySelector.selectByValue(value);
    }

    @Step("Wait {element} has class")
    public static void waitElementHasClass(WebElementWrapper element, String elementClass) throws InterruptedException {
        if (!element.getElement().getAttribute("class").contains(elementClass)) {
            TimeUnit.SECONDS.sleep(1);
        }
    }

    protected static WebElementWrapper wrapElement(WebElement element, String description) {
        return new WebElementWrapper(element, description);
    }
    @Step("Refresh page")
    public static void refreshPage() {
        driver.navigate().refresh();
    }

    @Step("Page back")
    public static void backToPage() {
        driver.navigate().back();
    }

    @Step("Checking scroll presence on the page")
    public static Boolean checkScrollPresence() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long contentHeight = (Long) js.executeScript("return document.documentElement.scrollHeight;");
        long viewportHeight = (Long) js.executeScript("return window.innerHeight;");
        return contentHeight > viewportHeight;
    }
}
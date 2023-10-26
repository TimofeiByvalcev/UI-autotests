package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * PageHelpers class provides helper methods for working with page.
 */
public class PageHelpers {

    /**
     * This method provides functionality of moving to element on the page.
     */
    public static void moveToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}

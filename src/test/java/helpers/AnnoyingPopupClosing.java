package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * AnnoyingPopupClosing class provides helper method for closing popup on the site.
 */
public class AnnoyingPopupClosing {

    /**
     * Find a close button in popup web element using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//*[@id='elementor-popup-modal-26600']/descendant::div[contains(@class, 'dialog-close-button')]")
    private static WebElement popupCloseButton;

    /**
     * Getter for popupCloseButton element.
     */
    public static WebElement getPopupCloseButton() {
        return popupCloseButton;
    }

    /**
     * This method close popup.
     */
    public static void closeAnnoyingPopup(WebDriver driver) {
        WebElement element = popupCloseButton;
        Waiters.waitVisibilityOfElement(driver, element);
        element.click();

    }

}

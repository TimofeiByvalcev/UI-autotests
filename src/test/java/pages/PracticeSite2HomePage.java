package pages;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The PracticeSite2HomePage class provides methods for work with the page which appears after registration on Practice Site 2 page.
 */
public class PracticeSite2HomePage extends BasePage {

    /**
     * PAGE_TITLE contains page title text.
     */
    private static final String PAGE_TITLE = "Home";

    /**
     * LOGGED_IN_MESSAGE contains text of message after successful registration.
     */
    private static final String LOGGED_IN_MESSAGE = "You're logged in!!";

    /**
     * Find a page title web element using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//h1[text() = 'Home']")
    private WebElement pageTitle;

    /**
     * Find a message web element after successful registration using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//p[contains(text(),'logged in!!')]")
    private WebElement loggedInMessage;

    /**
     * Find a Logout button tab web element using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//a[text() = 'Logout']")
    private WebElement logout;

    /**
     * Constructor for getting the driver instance from the BasePage class.
     * And also to initialize WebElements(Page Objects) declared in this class using PageFactory.
     */
    public PracticeSite2HomePage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Get page title web element")
    public WebElement getPageTitle() {
        Waiters.waitVisibilityOfElement(driver, pageTitle);
        return pageTitle;
    }

    @Step("Get 'logged in message' web element")
    public WebElement getLoggedInMessage() {
        Waiters.waitVisibilityOfElement(driver, loggedInMessage);
        return loggedInMessage;
    }

    /**
     * Get page title text from PAGE_TITLE.
     */
    public String getPageTitleText() {
        return PAGE_TITLE;
    }

    /**
     * Get text of message after successful registration from LOGGED_IN_MESSAGE.
     */
    public String getLoggedInMessageText() {
        return LOGGED_IN_MESSAGE;
    }

}

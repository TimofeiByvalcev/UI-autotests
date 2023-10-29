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
     * Constructor for getting the driver instance from the BasePage class.
     * And also to initialize WebElements(Page Objects) declared in this class using PageFactory.
     */
    public PracticeSite2HomePage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Get page title web element")
    public WebElement getPageTitle() {
        waitForElement(pageTitle);
        return pageTitle;
    }

    @Step("Get 'logged in message' web element")
    public WebElement getLoggedInMessage() {
        waitForElement(loggedInMessage);
        return loggedInMessage;
    }

    /**
     * Get page title text from PAGE_TITLE.
     */
    public String getPageTitleText() {
        String pageTitleText = "Home";
        return pageTitleText;
    }

    /**
     * Get text of message after successful registration from LOGGED_IN_MESSAGE.
     */
    public String getLoggedInMessageText() {
        String loggedInMessageText = "You're logged in!!";
        return loggedInMessageText;
    }

}

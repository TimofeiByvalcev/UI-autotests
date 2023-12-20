package pages;

import helpers.ReadProperties;
import helpers.WebElementWrapper;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * The PracticeSite2Page class provides methods for work with the angular registration form.
 */
public class PracticeSite2Page extends BasePage {

    /**
     * USER_NAME constant contains username for login.
     */
    public final String USER_NAME = "angular";

    /**
     * PASSWORD constant contains password for login.
     */
    public final String PASSWORD = "password";

    public final String LOGIN_BUTTON = "Login";

    /**
     * Find a Username field web element using @FindBy annotation and xpath.
     */
    @FindBy(id = "username")
    private WebElement usernameField;

    /**
     * Find a Password field web element using @FindBy annotation and xpath.
     */
    @FindBy(id = "password")
    private WebElement passwordField;

    /**
     * Find a Username Description field web element using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//input[@ng-model = 'model[options.key]']")
    private WebElement usernameDescriptionField;

    /**
     * Find a Login button web element using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//button[@ng-click = 'Auth.login()']")
    private WebElement loginButton;

    @FindBy(css = ".alert-danger")
    private WebElement alertMessage;

    @FindBy(xpath = "//div[@ng-messages = 'form.username.$error']")
    private WebElement usernameAlertMessage;

    @FindBy(xpath = "//div[@ng-messages = 'form.password.$error']")
    private WebElement passwordAlertMessage;

    @FindBy(xpath = "//div[@ng-repeat = 'field in fields ']/div")
    private WebElement usernameDescription;

    /**
     * Constructor for getting the driver instance from the BasePage class.
     * And also to initialize WebElements(Page Objects) declared in this class using PageFactory.
     */
    public PracticeSite2Page(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Open Registration Site 2 page")
    public PracticeSite2Page openRegistrationPage() {
        driver.get(ReadProperties.readProperty("practice_site2"));
        return new PracticeSite2Page(driver);
    }

    @Step("Enter Username")
    public PracticeSite2Page enterUsername(String username) {
        sendKeysToElement(wrapElement(usernameField, "Username field"), username);
        return new PracticeSite2Page(driver);
    }

    @Step("Enter Password")
    public PracticeSite2Page enterPassword(String password) {
        sendKeysToElement(wrapElement(passwordField, "Password field"), password);
        return new PracticeSite2Page(driver);
    }

    @Step("Enter Username Description")
    public PracticeSite2Page enterUserNameDescription(String usernameDescription) {
        sendKeysToElement(wrapElement(usernameDescriptionField, "Description field"), usernameDescription);
        return new PracticeSite2Page(driver);
    }

    @Step("Click Login button")
    public PracticeSite2HomePage clickLoginButton() {
        clickElement(wrapElement(loginButton, "Login button"));
        return new PracticeSite2HomePage(driver);
    }

    public WebElementWrapper getAlertMessage() {
        return wrapElement(alertMessage, "Alert message");
    }

    @Step("Enter Username using JS Executor")
    public PracticeSite2Page enterUsernameJS() {
        WebElementWrapper wrappedUsername = wrapElement(usernameField, "Username field");
        clickElement(wrappedUsername);
        removeFocus(wrappedUsername);
        return new PracticeSite2Page(driver);
    }

    @Step("Enter Password using JS Executor")
    public PracticeSite2Page enterPasswordJS() {
        WebElementWrapper wrappedPassword = wrapElement(passwordField, "Password field");
        clickElement(wrappedPassword);
        removeFocus(wrappedPassword);
        return new PracticeSite2Page(driver);
    }

    @Step("Enter Username description using JS Executor")
    public PracticeSite2Page enterUsernameDescriptionJS() {
        WebElementWrapper wrappedUsernameDescription = wrapElement(usernameDescriptionField, "Username description field");
        clickElement(wrappedUsernameDescription);
        removeFocus(wrappedUsernameDescription);
        return new PracticeSite2Page(driver);
    }

    @Step("Remove focus from {element}")
    public void removeFocus(WebElementWrapper element) {
        waitForElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("document.getElementById('%s').blur();", element.getElement().getAttribute("id")));
    }

    public WebElementWrapper getUsernameAlertMessage() {
        return wrapElement(usernameAlertMessage, "Username is required");
    }

    public WebElementWrapper getPasswordAlertMessage() {
        return wrapElement(passwordAlertMessage, "Password is required");
    }

    public WebElementWrapper getUsernameDescription() {
        return wrapElement(usernameDescription, "Username description is required");
    }
}

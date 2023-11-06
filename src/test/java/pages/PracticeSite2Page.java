package pages;

import helpers.ReadProperties;
import helpers.WebElementWrapper;
import io.qameta.allure.Step;
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
    @FindBy(xpath = "//input[@id = 'username']")
    private WebElement usernameField;

    /**
     * Find a Password field web element using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//input[@id = 'password']")
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

    /**
     * Constructor for getting the driver instance from the BasePage class.
     * And also to initialize WebElements(Page Objects) declared in this class using PageFactory.
     */
    public PracticeSite2Page() {
        PageFactory.initElements(driver, this);
    }

    @Step("Open Registration Site 2 page")
    public PracticeSite2Page openRegistrationPage() {
        driver.get(ReadProperties.readProperty("practice_site2"));
        return new PracticeSite2Page();
    }

    @Step("Enter Username")
    public PracticeSite2Page enterUsername(String username) {
        sendKeysToElement(wrapElement(usernameField, "Username field"), username);
        return new PracticeSite2Page();
    }

    @Step("Enter Password")
    public PracticeSite2Page enterPassword(String password) {
        sendKeysToElement(wrapElement(passwordField, "Password field"), password);
        return new PracticeSite2Page();
    }

    @Step("Enter Username Description")
    public PracticeSite2Page enterUserNameDescription(String usernameDescription) {
        sendKeysToElement(wrapElement(usernameDescriptionField, "Description field"), usernameDescription);
        return new PracticeSite2Page();
    }

    @Step("Click Login button")
    public PracticeSite2HomePage clickLoginButton() {
        clickElement(wrapElement(loginButton, "Login button"));
        return new PracticeSite2HomePage();
    }

    public WebElementWrapper getAlertMessage() {
        return wrapElement(alertMessage, "Alert message");
    }
}

package pages;

import helpers.ReadProperties;
import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The PracticeSite2Page class provides methods for work with the angular registration form.
 */
public class PracticeSite2Page extends BasePage {

    /**
     * A USER_NAME constant contains a username.
     */
    private static final String USER_NAME = "angular";

    /**
     * A PASSWORD constant contains a password.
     */
    private static final String PASSWORD = "password";

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
    @FindBy(xpath = "//input[@id = 'formly_1_input_username_0']")
    private WebElement usernameDescriptionField;

    /**
     * Find a Login button web element using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    private WebElement loginButton;

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
        Waiters.waitVisibilityOfElement(driver, usernameField);
        usernameField.sendKeys(username);
        return new PracticeSite2Page();
    }

    @Step("Enter Password")
    public PracticeSite2Page enterPassword(String password) {
        Waiters.waitVisibilityOfElement(driver, passwordField);
        passwordField.sendKeys(password);
        return new PracticeSite2Page();
    }

    @Step("Enter Username Description")
    public PracticeSite2Page enterUserNameDescription(String usernameDescription) {
        Waiters.waitVisibilityOfElement(driver, usernameDescriptionField);
        usernameDescriptionField.sendKeys(usernameDescription);
        return new PracticeSite2Page();
    }

    @Step("Click Login button")
    public PracticeSite2HomePage clickLoginButton() {
        Waiters.waitVisibilityOfElement(driver, loginButton);
        loginButton.click();
        return new PracticeSite2HomePage();
    }

    /**
     * Get username from USER_NAME.
     */
    public String getUserName() {
        return USER_NAME;
    }

    /**
     * Get password from PASSWORD.
     */
    public String getPassword() {
        return PASSWORD;
    }

}

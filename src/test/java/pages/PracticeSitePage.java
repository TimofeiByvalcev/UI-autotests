package pages;

import helpers.ReadProperties;
import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * PracticeSitePage provides methods for work with the Practice Site page.
 */
public class PracticeSitePage extends BasePage {

    /**
     * ALERT_MESSAGE constant contains alert message on dummy registration form page.
     */
    public static final String ALERT_MESSAGE = "This is just a dummy form, you just clicked SUBMIT BUTTON";

    /**
     * Find a testing website link using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[contains(@class, 'fancybox-overlay')]/descendant::a[text() = 'ENTER TO THE TESTING WEBSITE']")
    private WebElement testingWebsiteLink;

    /**
     * Find a page description using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//h3[text() = 'Try Automating all feasible elements you find on web']")
    private WebElement pageDescription;

    /**
     * Find a name field in dummy form using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@id = 'load_box']/descendant::input[@name = 'name']")
    private WebElement dummyFormName;

    /**
     * Find a phone field in dummy form using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@id = 'load_box']/descendant::input[@name = 'phone']")
    private WebElement dummyFormPhone;

    /**
     * Find an email field in dummy form using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@id = 'load_box']/descendant::input[@name = 'email']")
    private WebElement dummyFormEmail;

    /**
     * Find a country dropdown element in dummy form using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@id = 'load_box']/descendant::select")
    private WebElement dummyFormCountry;

    /**
     * Find a city field in dummy form using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@id = 'load_box']/descendant::input[@name = 'city']")
    private WebElement dummyFormCity;

    /**
     * Find a username field in dummy form using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@id = 'load_box']/descendant::input[@name = 'username']")
    private WebElement dummyFormUserName;

    /**
     * Find a password field in dummy form using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@id = 'load_box']/descendant::input[@name = 'password']")
    private WebElement dummyFormPassword;

    /**
     * Find an alert message after submitting dummy form using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[contains(@class, 'fancybox-overlay')]/descendant::p[@id = 'alert']")
    private WebElement alertMessage;

    /**
     * Find a submit button in dummy form using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[contains(@class, 'fancybox-overlay')]/descendant::input[@value = 'Submit']")
    private WebElement submitButton;

    /**
     * Constructor for getting the driver instance from the BasePage class.
     * And also to initialize WebElements(Page Objects) declared in this class using PageFactory.
     */
    public PracticeSitePage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Open Practice Site page")
    public PracticeSitePage openPracticeSitePage() {
        driver.get(ReadProperties.readProperty("practice_site1"));
        return new PracticeSitePage();
    }

    @Step("Click testing website link")
    public PracticeSitePage clickTestingWebsiteLink() {
        clickElement(testingWebsiteLink);
        return new PracticeSitePage();
    }

    @Step("Get page description")
    public WebElement getPageDescription() {
        waitForElement(pageDescription);
        return pageDescription;
    }

    @Step("Get page description text from constant")
    public String getPageDescriptionText() {
        String pageDescription = "Try Automating all feasible elements you find on web";
        return pageDescription;
    }

    @Step("Enter name in dummy form")
    public PracticeSitePage enterDummyName(String name) {
        sendKeysToElement(dummyFormName, name);
        return new PracticeSitePage();
    }

    @Step("Enter phone in dummy form")
    public PracticeSitePage enterDummyPhone(String phone) {
        sendKeysToElement(dummyFormPhone, phone);
        return new PracticeSitePage();
    }

    @Step("Enter email in dummy form")
    public PracticeSitePage enterDummyEmail(String email) {
        sendKeysToElement(dummyFormEmail, email);
        return new PracticeSitePage();
    }

    @Step("Select country in dummy form")
    public PracticeSitePage selectDummyCountry(String country) {
        selectByValue(dummyFormCountry, country);
        return new PracticeSitePage();
    }

    @Step("Enter city in dummy form")
    public PracticeSitePage enterDummyCity(String city) {
        sendKeysToElement(dummyFormCity, city);
        return new PracticeSitePage();
    }

    @Step("Enter username in dummy form")
    public PracticeSitePage enterDummyUsername(String username) {
        sendKeysToElement(dummyFormUserName, username);
        return new PracticeSitePage();
    }

    @Step("Enter password in dummy form")
    public PracticeSitePage enterDummyPassword(String password) {
        sendKeysToElement(dummyFormPassword, password);
        return new PracticeSitePage();
    }

    @Step("Click Submit button dummy form")
    public PracticeSitePage clickSubmitButton() {
        clickElement(submitButton);
        return new PracticeSitePage();
    }

    @Step("Get alert message in dummy form")
    public WebElement getAlertMessage() {
        waitForElement(alertMessage);
        return alertMessage;
    }
}

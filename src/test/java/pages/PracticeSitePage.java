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
     * ALERT_MESSAGE constant contains a text of alert message.
     */
    private static final String ALERT_MESSAGE = "This is just a dummy form, you just clicked SUBMIT BUTTON";

    /**
     * PAGE_DESCRIPTION constant contains a text of page description.
     */
    private static final String PAGE_DESCRIPTION = "Try Automating all feasible elements you find on web";

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
        Waiters.waitVisibilityOfElement(driver, testingWebsiteLink);
        testingWebsiteLink.click();
        return new PracticeSitePage();
    }

    @Step("Get page description")
    public WebElement getPageDescription() {
        Waiters.waitVisibilityOfElement(driver, pageDescription);
        return pageDescription;
    }
    @Step("Get page description text from constant")
    public String getPageDescriptionText() {
        return PAGE_DESCRIPTION;
    }
    @Step("Enter name in dummy form")
    public PracticeSitePage enterDummyName(String name) {
        Waiters.waitVisibilityOfElement(driver, dummyFormName);
        dummyFormName.sendKeys(name);
        return new PracticeSitePage();
    }

    @Step("Enter phone in dummy form")
    public PracticeSitePage enterDummyPhone(String phone) {
        Waiters.waitVisibilityOfElement(driver, dummyFormPhone);
        dummyFormPhone.sendKeys(phone);
        return new PracticeSitePage();
    }
    @Step("Enter email in dummy form")
    public PracticeSitePage enterDummyEmail(String email) {
        Waiters.waitVisibilityOfElement(driver, dummyFormEmail);
        dummyFormEmail.sendKeys(email);
        return new PracticeSitePage();
    }

    @Step("Select country in dummy form")
    public PracticeSitePage selectDummyCountry(String country) {
        Waiters.waitVisibilityOfElement(driver, dummyFormCountry);
        Select countrySelector = new Select(dummyFormCountry);
        countrySelector.selectByValue(country);
        return new PracticeSitePage();
    }
    @Step("Enter city in dummy form")
    public PracticeSitePage enterDummyCity(String city) {
        Waiters.waitVisibilityOfElement(driver, dummyFormCity);
        dummyFormCity.sendKeys(city);
        return new PracticeSitePage();
    }

    @Step("Enter username in dummy form")
    public PracticeSitePage enterDummyUsername(String username) {
        Waiters.waitVisibilityOfElement(driver, dummyFormUserName);
        dummyFormUserName.sendKeys(username);
        return new PracticeSitePage();
    }
    @Step("Enter password in dummy form")
    public PracticeSitePage enterDummyPassword(String password) {
        Waiters.waitVisibilityOfElement(driver, dummyFormPassword);
        dummyFormPassword.sendKeys(password);
        return new PracticeSitePage();
    }

    @Step("Click Submit button dummy form")
    public PracticeSitePage clickSubmitButton() {
        Waiters.waitVisibilityOfElement(driver, submitButton);
        submitButton.click();
        return new PracticeSitePage();
    }

    @Step("Get alert message in dummy form")
    public WebElement getAlertMessage() {
        Waiters.waitVisibilityOfElement(driver, alertMessage);
        return alertMessage;
    }
    @Step("Get alert message text from constant for dummy form")
    public String getAlertMessageText() {
        return ALERT_MESSAGE;
    }
}

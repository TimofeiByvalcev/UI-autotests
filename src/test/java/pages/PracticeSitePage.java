package pages;

import helpers.ReadProperties;
import helpers.WebElementWrapper;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PracticeSitePage provides methods for work with the Practice Site page.
 */
public class PracticeSitePage extends BasePage {

    /**
     * ALERT_MESSAGE constant contains alert message on dummy registration form page.
     */
    public final String ALERT_MESSAGE = "This is just a dummy form, you just clicked SUBMIT BUTTON";

    public final String PAGE_DESCRIPTION = "Try Automating all feasible elements you find on web";

    public final String TEST_SITE_LINK = "ENTER TO THE TESTING WEBSITE";

    /**
     * Find a testing website link using @FindBy annotation and xpath.
     */
    @FindBy(linkText = TEST_SITE_LINK)
    private WebElement testingWebsiteLink;

    /**
     * Find a page description using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//h3")
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

    @FindBy(xpath = "//a[@href = 'droppable.php']")
    private WebElement droppablePage;

    /**
     * Constructor for getting the driver instance from the BasePage class.
     * And also to initialize WebElements(Page Objects) declared in this class using PageFactory.
     */
    public PracticeSitePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Open Practice Site page")
    public PracticeSitePage openPracticeSitePage() {
        driver.get(ReadProperties.readProperty("practice_site1"));
        return new PracticeSitePage(driver);
    }

    @Step("Click testing website link")
    public PracticeSitePage clickTestingWebsiteLink() {
        clickElement(wrapElement(testingWebsiteLink, "Testing website link"));
        return this;
    }

    @Step("Get page description")
    public WebElement getPageDescription() {
        waitForElement(wrapElement(pageDescription, "Description of page"));
        return pageDescription;
    }

    @Step("Enter name in dummy form")
    public PracticeSitePage enterDummyName(String name) {
        sendKeysToElement(wrapElement(dummyFormName, "Name field"), name);
        return this;
    }

    @Step("Enter phone in dummy form")
    public PracticeSitePage enterDummyPhone(String phone) {
        sendKeysToElement(wrapElement(dummyFormPhone, "Phone field"), phone);
        return this;
    }

    @Step("Enter email in dummy form")
    public PracticeSitePage enterDummyEmail(String email) {
        sendKeysToElement(wrapElement(dummyFormEmail, "Email form"), email);
        return this;
    }

    @Step("Select country in dummy form")
    public PracticeSitePage selectDummyCountry(String country) {
        selectByValue(wrapElement(dummyFormCountry, "Country in dropdown"), country);
        return this;
    }

    @Step("Enter city in dummy form")
    public PracticeSitePage enterDummyCity(String city) {
        sendKeysToElement(wrapElement(dummyFormCity, "City field"), city);
        return this;
    }

    @Step("Enter username in dummy form")
    public PracticeSitePage enterDummyUsername(String username) {
        sendKeysToElement(wrapElement(dummyFormUserName, "Username field"), username);
        return this;
    }

    @Step("Enter password in dummy form")
    public PracticeSitePage enterDummyPassword(String password) {
        sendKeysToElement(wrapElement(dummyFormPassword, "Password field"), password);
        return this;
    }

    @Step("Click Submit button dummy form")
    public PracticeSitePage clickSubmitButton() {
        clickElement(wrapElement(submitButton, "Submit form"));
        return this;
    }

    @Step("Get alert message in dummy form")
    public WebElement getAlertMessage() {
        waitForElement(wrapElement(alertMessage, "Alert message on the page"));
        return alertMessage;
    }

    @Step("Open droppable page")
    public DragNDropPage openDragNDropPage() throws Exception {
        WebElementWrapper wrappedDroppable = wrapElement(droppablePage, "Droppable page");
        waitForElement(wrappedDroppable);
        clickElement(wrappedDroppable);
        return new DragNDropPage(driver);
    }


}

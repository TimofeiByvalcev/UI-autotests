package pages;

import helpers.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SqlLoginPage extends BasePage {

    public final String LOGIN = ReadProperties.readProperty("sql_login");

    public final String PASSWORD = ReadProperties.readProperty("sql_password");

    @FindBy(xpath = "//input[@type = 'text' and @name = 'login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@type = 'password' and @name = 'psw']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type = 'submit' and @name = 'subm1']")
    private WebElement enterButton;

    @FindBy(xpath = "//a[@href = '/personal.php']")
    private WebElement profileLink;

    public SqlLoginPage () {
        PageFactory.initElements(driver, this);
    }

    @Step("Open Home page")
    public SqlLoginPage openLoginPage() {
        driver.get(ReadProperties.readProperty("sql_page"));
        return new SqlLoginPage();
    }

    @Step("Enter Login")
    public SqlLoginPage enterLogin() {
        sendKeysToElement(wrapElement(loginField, "Login field"), LOGIN);
        return new SqlLoginPage();
    }

    @Step("Enter Login")
    public SqlLoginPage enterPassword() {
        sendKeysToElement(wrapElement(passwordField, "Password field"), PASSWORD);
        return new SqlLoginPage();
    }

    @Step("Enter Login")
    public SqlLoginPage clickEnter() {
        clickElement(wrapElement(enterButton, "Submit button"));
        return new SqlLoginPage();
    }

    @Step("Click profile link")
    public SqlPersonalPage clickProfileLink() {
        clickElement(wrapElement(profileLink, "Profile link"));
        return new SqlPersonalPage();
    }
}

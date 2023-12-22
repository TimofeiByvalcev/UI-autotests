package pages;

import helpers.ReadProperties;
import helpers.WebElementWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SqlPersonalPage extends BasePage {

    public static final String PAGE_TITLE = "Personal page";
    @FindBy(xpath = "//a[@href = '/logout.php']")
    private WebElement logoutButton;

    @FindBy(xpath = "//h2")
    private static WebElement pageTitle;

    public SqlPersonalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SqlPersonalPage openPersonalPage() {
        driver.get(ReadProperties.readProperty("sql_personal_page"));
        return new SqlPersonalPage(driver);
    }

    public WebElementWrapper getLogoutButton() {
        return wrapElement(logoutButton, "Logout button");
    }

    public WebElementWrapper getPageTitle() {
        return wrapElement(pageTitle, "Page title");
    }
}

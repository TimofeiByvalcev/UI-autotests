package pages;

import helpers.WebElementWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the About Us page, provides methods for work with this page.
 */
public class AboutUsPage extends BasePage {

    public final String PAGE_TITLE = "Abosut Us";

    /**
     * Find an About Us title web element using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//h1")
    private WebElement aboutUsTitle;

    /**
     * Constructor for getting the driver instance from the BasePage class.
     * And also to initialize WebElements(Page Objects) declared in this class using PageFactory.
     */
    public AboutUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Get aboutUsTitle web element.
     */
    public WebElementWrapper getAboutUsTitle() {
        WebElementWrapper aboutUs = wrapElement(aboutUsTitle, "About Us title");
        waitForElement(aboutUs);
        return aboutUs;
    }
}

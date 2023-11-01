package pages;

import helpers.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the About Us page, provides methods for work with this page.
 */
public class AboutUsPage extends BasePage {

    public final String PAGE_TITLE = "About Us";

    /**
     * Find an About Us title web element using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//h1")
    private WebElement aboutUsTitle;

    /**
     * Constructor for getting the driver instance from the BasePage class.
     * And also to initialize WebElements(Page Objects) declared in this class using PageFactory.
     */
    public AboutUsPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Get aboutUsTitle web element.
     */
    public WebElement getAboutUsTitle() {
        Waiters.waitVisibilityOfElement(driver, aboutUsTitle);
        return aboutUsTitle;
    }
}

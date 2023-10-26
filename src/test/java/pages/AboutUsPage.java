package pages;

import helpers.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the About Us page, provides methods for work with this page.
 */
public class AboutUsPage extends BasePage {

    /**
     * An ABOUT_US constant provides a title of About Us page.
     */
    private static final String ABOUT_US = "About Us";

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
     * Getter for aboutUsTitle web element.
     */
    public WebElement getAboutUsTitle() {
        Waiters.waitVisibilityOfElement(driver, aboutUsTitle);
        return aboutUsTitle;
    }

    /**
     * Getter for ABOUT_US constant.
     */
    public String getAboutUsTitleText() {
        return ABOUT_US;
    }
}

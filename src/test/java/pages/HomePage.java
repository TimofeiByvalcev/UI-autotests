package pages;


import helpers.ReadProperties;
import helpers.WebElementWrapper;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The HomePage class provides methods for work with the Home page.
 */
public class HomePage extends BasePage {

    public final String RESOURCES = "Resources";

    public final String PRACTICE_SITE1 = "Practice Site 1";

    public final String ABOUT_US = "About Us";

    /**
     * Find a header on the home page using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@id= 'ast-desktop-header']/descendant::div[contains(@class, 'ast-primary-header-bar')]")
    private WebElement homePageHeader;

    /**
     * Find a horizontal menu on the home page using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//*[@id='ast-desktop-header']/descendant::div[contains(@class, 'main-navigation')]")
    private WebElement horizontalMenu;

    /**
     * Find a certification block on the home page using @FindBy annotation and xpath.
     */
    @FindBy(css = "div.elementor-widget-wrap>div.elementor-hidden-mobile")
    private WebElement certificationsBlock;

    /**
     * Find a courses block on the home page using @FindBy annotation and xpath.
     */
    @FindBy(css = " .swiper-container-wrap")
    private WebElement coursesBlock;

    /**
     * Find an active element in courses carousel on the home page using @FindBy annotation and xpath.
     */
    @FindBy(css = ".swiper-container-wrap .swiper-slide-active .pp-info-box-title")
    private WebElement activeCourseCarousel;

    /**
     * Find a next element in courses carousel on the home page using @FindBy annotation and xpath.
     */
    @FindBy(css = ".swiper-container-wrap .swiper-slide-next .pp-info-box-title")
    private WebElement nextCourseCarousel;

    @FindBy(css = ".swiper-container-wrap .swiper-slide-prev .pp-info-box-title")
    private WebElement prevCourseCarousel;

    /**
     * Find a footer on the home page using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@data-elementor-type = 'footer']")
    private WebElement homePageFooter;

    /**
     * Find a resources option in horizontal menu using @FindBy annotation and xpath.
     */
    @FindBy(linkText = RESOURCES)
    private WebElement resourcesOptionMenu;

    /**
     * Find a practice site 1 link in horizontal menu using @FindBy annotation and xpath.
     */
    @FindBy(linkText = PRACTICE_SITE1)
    private WebElement practiceSite1;

    /**
     * Find a next arrow in courses carousel on the home page using @FindBy annotation and xpath.
     */
    @FindBy(css = ".swiper-container-wrap .swiper-button-next")
    private WebElement courseCarouselNextArrow;

    @FindBy(css = ".swiper-container-wrap .swiper-button-prev")
    private WebElement courseCarouselPrevArrow;

    /**
     * Find an About Us link in footer on the home page using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@data-elementor-type = 'footer']/descendant::span[text() = '" + ABOUT_US + "']")
    private WebElement aboutUs;

    /**
     * Constructor for getting the driver instance from the BasePage class.
     * And also to initialize WebElements(Page Objects) declared in this class using PageFactory.
     */
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Open Home page")
    public HomePage openHomePage() {
        driver.get(ReadProperties.readProperty("home_page_url"));
        return new HomePage();
    }

    /**
     * This method get an index value of course in courses carousel.
     */
    @Step("Get name of course in carousel")
    public String getCourseName(WebElementWrapper element) {
        waitForElement(element);
        return element.getElement().getText();
    }

    /**
     * This method open Practice Site 1 page from horizontal menu.
     */
    public PracticeSitePage openPageFromMenu() {
        clickElement(wrapElement(resourcesOptionMenu, "Resource option in horizontal menu"));
        clickElement(wrapElement(practiceSite1, "Practice Site 1"));
        return new PracticeSitePage();
    }

    /**
     * This method open About Us page from footer.
     */
    public AboutUsPage openAboutUsPage() {
        moveToElement(wrapElement(homePageFooter, "Home page footer"));
        clickElement(wrapElement(aboutUs, "About us page"));
        return new AboutUsPage();
    }

    /**
     * This method returns homePageHeader web element.
     */
    public WebElementWrapper getHomePageHeader() {
        return wrapElement(homePageHeader, "Header");
    }

    /**
     * This method returns horizontalMenu web element.
     */
    public WebElementWrapper getHorizontalMenu() {
        return wrapElement(horizontalMenu, "Horizontal menu");
    }

    /**
     * This method returns certificationsBlock web element.
     */
    public WebElementWrapper getCertificationsBlock() {
        return wrapElement(certificationsBlock, "Certifications block");
    }

    /**
     * This method returns coursesBlock web element.
     */
    public WebElementWrapper getCoursesBlock() {
        return wrapElement(coursesBlock, "Courses block");
    }

    /**
     * This method returns activeCourseCarousel web element.
     */
    public WebElementWrapper getActiveCourseCarousel() {
        return wrapElement(activeCourseCarousel, "Active course in carousel");
    }

    /**
     * This method returns nextCourseCarousel web element.
     */
    public WebElementWrapper getNextCourseCarousel() {
        return wrapElement(nextCourseCarousel, "Next course in carousel");
    }

    /**
     * This method returns homePageFooter web element.
     */
    public WebElementWrapper getHomePageFooter() {

        return new WebElementWrapper(homePageFooter, "Home page footer");
    }

    /**
     * This method returns courseCarouselNextArrow web element.
     */
    public WebElementWrapper getCourseCarouselNextArrow() {
        return wrapElement(courseCarouselNextArrow, "Carousel next arrow");
    }

    public WebElementWrapper getCourseCarouselPrevArrow() {
        return wrapElement(courseCarouselPrevArrow, "Carousel prev arrow");
    }
}

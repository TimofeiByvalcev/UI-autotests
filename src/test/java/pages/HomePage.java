package pages;


import helpers.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The HomePage class provides methods for work with the Home page.
 */
public class HomePage extends BasePage {

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
    @FindBy(css = ".swiper-container-wrap .swiper-slide-active")
    private WebElement activeCourseCarousel;

    /**
     * Find a next element in courses carousel on the home page using @FindBy annotation and xpath.
     */
    @FindBy(css = ".swiper-container-wrap .swiper-slide-next")
    private WebElement nextCourseCarousel;

    /**
     * Find a footer on the home page using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@data-elementor-type = 'footer']")
    private WebElement homePageFooter;

    /**
     * Find a resources option in horizontal menu using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@id = 'ast-desktop-header']/descendant::span[text() = 'Resources']")
    private WebElement resourcesOptionMenu;

    /**
     * Find a practice site 1 link in horizontal menu using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[contains(@class, 'main-navigation')]/descendant::li[@id = 'menu-item-27618']")
    private WebElement practiceSite1;

    /**
     * Find a next arrow in courses carousel on the home page using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[contains(@class,'swiper-button-next-c50f9f0')]")
    private WebElement courseCarouselNextArrow;

    /**
     * Find a title of courses block on the home page using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[contains(@class, 'elementor-image-box-content')]/child::h2[text() = 'Most Popular Software Testing Courses']")
    private WebElement coursesTitle;

    /**
     * Find an About Us link in footer on the home page using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[@data-elementor-type = 'footer']/descendant::span[text() = 'About Us']")
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
    @Step("Get index of course in carousel")
    public int getCourseAttributeValue(WebElement element) {
        waitForElement(element);
        return Integer.parseInt(element.getAttribute("data-swiper-slide-index"));
    }

    /**
     * This method open Practice Site 1 page from horizontal menu.
     */
    public PracticeSitePage openPageFromMenu() {
        clickElement(resourcesOptionMenu);
        clickElement(practiceSite1);
        return new PracticeSitePage();
    }

    /**
     * This method open About Us page from footer.
     */
    public AboutUsPage openAboutUsPage() {
        moveToElement(homePageFooter);
        clickElement(aboutUs);
        return new AboutUsPage();
    }

    /**
     * This method returns homePageHeader web element.
     */
    public WebElement getHomePageHeader() {
        return homePageHeader;
    }

    /**
     * This method returns horizontalMenu web element.
     */
    public WebElement getHorizontalMenu() {
        return horizontalMenu;
    }

    /**
     * This method returns certificationsBlock web element.
     */
    public WebElement getCertificationsBlock() {
        return certificationsBlock;
    }

    /**
     * This method returns coursesBlock web element.
     */
    public WebElement getCoursesBlock() {
        return coursesBlock;
    }

    /**
     * This method returns activeCourseCarousel web element.
     */
    public WebElement getActiveCourseCarousel() {
        return activeCourseCarousel;
    }

    /**
     * This method returns nextCourseCarousel web element.
     */
    public WebElement getNextCourseCarousel() {
        return nextCourseCarousel;
    }

    /**
     * This method returns homePageFooter web element.
     */
    public WebElement getHomePageFooter() {
        return homePageFooter;
    }

    /**
     * This method returns courseCarouselNextArrow web element.
     */
    public WebElement getCourseCarouselNextArrow() {
        return courseCarouselNextArrow;
    }
}

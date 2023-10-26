package pages;


import helpers.PageHelpers;
import helpers.ReadProperties;
import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

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
    @FindBy(xpath = "//*[@data-id='259f3103']/div[contains(@class, 'elementor-widget-wrap')]")
    private WebElement certificationsBlock;

    /**
     * Find a courses block on the home page using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//*[@data-id='50827c4']/div[contains(@class, 'elementor-widget-wrap')]")
    private WebElement coursesBlock;

    /**
     * Find an active element in courses carousel on the home page using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//div[contains(@class, 'swiper-container-c50f9f0')]/descendant::div[contains(@class, 'swiper-slide-active')]")
    private WebElement activeCourseCarousel;

    /**
     * Find a next element in courses carousel on the home page using @FindBy annotation and xpath.
     */
    @FindBy(xpath = "//section[@data-id = '166618a']/descendant::div[contains(@class, 'swiper-container-c50f9f0')]/descendant::div[contains(@class, 'swiper-slide-next')]")
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

    /**
     * This method returns a list of collected elements.
     */
    private List<WebElement> collectHomePageElements() {
        List<WebElement> homePageElements = Arrays.asList(homePageHeader, horizontalMenu,
                certificationsBlock, coursesBlock, courseCarouselNextArrow, homePageFooter);
        return homePageElements;
    }

    @Step("Open Home page")
    public HomePage openHomePage() {
        driver.get(ReadProperties.readProperty("home_page_url"));
        return new HomePage();
    }

    @Step("Check presence of elements on the page")
    public boolean checkPresenceOfElements() {
        List<WebElement> elements = collectHomePageElements();
        try {
            for (WebElement element : elements) {
                if (element.isDisplayed()) {
                    continue;
                }
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    /**
     * This method get an index value of course in courses carousel.
     */
    private int getAttributeValue(WebElement element) {
        return Integer.parseInt(element.getAttribute("data-swiper-slide-index"));
    }

    /**
     * This method check that slider in carousel page is working. It works like:
     * We find and move to courses block element. Then we get an index of next course and save it.
     * Click an arrow. Then compare active course's index and next course's index.
     * If active course's index equal to next course's index which we saved before. Then slider arrow works correctly.
     */
    public boolean checkSliderWork() {
        PageHelpers.moveToElement(driver, coursesBlock);

        Waiters.waitVisibilityOfElement(driver, nextCourseCarousel);
        int nextCourseIndex = getAttributeValue(nextCourseCarousel);

        Waiters.waitVisibilityOfElement(driver, courseCarouselNextArrow);
        courseCarouselNextArrow.click();

        return getAttributeValue(activeCourseCarousel) == nextCourseIndex;
    }

    /**
     * This method check header displaying after scroll.
     */
    public boolean checkHeaderMenuAfterScroll() {
        PageHelpers.moveToElement(driver, coursesBlock);
        return homePageHeader.isDisplayed();
    }

    /**
     * This method open Practice Site 1 page from horizontal menu.
     */
    public PracticeSitePage openPagesFromMenu() {
        Waiters.waitVisibilityOfElement(driver, resourcesOptionMenu);
        resourcesOptionMenu.click();
        Waiters.waitVisibilityOfElement(driver, practiceSite1);
        practiceSite1.click();
        return new PracticeSitePage();
    }

    /**
     * This method open About Us page from footer.
     */
    public AboutUsPage openAboutUsPage() {
        Waiters.waitVisibilityOfElement(driver, homePageFooter);
        PageHelpers.moveToElement(driver, homePageFooter);
        Waiters.waitVisibilityOfElement(driver, aboutUs);
        aboutUs.click();
        return new AboutUsPage();
    }
}

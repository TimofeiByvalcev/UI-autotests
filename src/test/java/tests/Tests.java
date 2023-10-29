package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static helpers.FakeData.*;
import static pages.BasePage.*;

/**
 * Tests class provides UI tests for way2automation site.
 */
public class Tests extends BaseTest {

    /**
     * Check presence of elements on the home page.
     */
    @Test
    public void testPresenceOfElements() {
        HomePage homePage = new HomePage().openHomePage();

        WebElement header = homePage.getHomePageHeader();
        WebElement horizontalMenu = homePage.getHorizontalMenu();
        WebElement certificationsBlock = homePage.getCertificationsBlock();
        WebElement coursesBlock = homePage.getCoursesBlock();
        WebElement nextCourseCarousel = homePage.getNextCourseCarousel();
        WebElement activeCourseCarousel = homePage.getActiveCourseCarousel();
        WebElement courseCarouselNextArrow = homePage.getCourseCarouselNextArrow();
        WebElement footer = homePage.getHomePageFooter();

        Assert.assertTrue(checkPresenceOfElement(header));
        Assert.assertTrue(checkPresenceOfElement(horizontalMenu));
        Assert.assertTrue(checkPresenceOfElement(certificationsBlock));
        Assert.assertTrue(checkPresenceOfElement(coursesBlock));
        Assert.assertTrue(checkPresenceOfElement(footer));

        moveToElement(coursesBlock);

        int nextCourseIndex = homePage.getCourseAttributeValue(nextCourseCarousel);
        clickElement(courseCarouselNextArrow);

        Assert.assertEquals(homePage.getCourseAttributeValue(activeCourseCarousel), nextCourseIndex, "Slider isn't work");

    }

    /**
     * Check header displaying after scroll.
     */
    @Test
    public void testMenuInHeaderAfterScroll() {
        HomePage homePage = new HomePage().openHomePage();
        WebElement header = homePage.getHomePageHeader();
        WebElement footer = homePage.getHomePageFooter();

        moveToElement(footer);

        Assert.assertTrue(checkPresenceOfElement(header), "Header isn't displayed after scroll");
    }

    /**
     * Check Practice Site page opening from horizontal menu.
     */
    @Test
    public void testOpenPracticeSite() {
        PracticeSitePage practiceSitePage = new HomePage()
                .openHomePage()
                .openPageFromMenu()
                .clickTestingWebsiteLink();

        Assert.assertEquals(practiceSitePage.getPageDescription().getText(), practiceSitePage.getPageDescriptionText());
    }

    /**
     * Test authorization form on Practice Site 2 page with valid data.
     */
    @Test
    public void authorization() {
        PracticeSite2Page practiceSite2Page = new PracticeSite2Page();

        PracticeSite2HomePage practiceSite2HomePage = practiceSite2Page
                .openRegistrationPage()
                .enterUsername(practiceSite2Page.getUserName())
                .enterPassword(practiceSite2Page.getPassword())
                .enterUserNameDescription("Test")
                .clickLoginButton();

        Assert.assertEquals(practiceSite2HomePage.getPageTitle().getText(), practiceSite2HomePage.getPageTitleText());
        Assert.assertEquals(practiceSite2HomePage.getLoggedInMessage().getText(), practiceSite2HomePage.getLoggedInMessageText());
    }

    /**
     * Check that About Us page opening from footer.
     */
    @Test
    public void openAboutUsPage() {
        AboutUsPage aboutUsPage = new HomePage()
                .openHomePage()
                .openAboutUsPage();
        Assert.assertEquals(aboutUsPage.getAboutUsTitle().getText(), aboutUsPage.getAboutUsTitleText());
    }

    /**
     * Check that dummy registration form is work.
     */
    @Test
    public void fillDummyRegistrationForm() {
        PracticeSitePage practiceSitePage = new PracticeSitePage()
                .openPracticeSitePage()
                .enterDummyName(generateFullName())
                .enterDummyPhone(generatePhoneNumber())
                .enterDummyEmail(generateEmail())
                .selectDummyCountry(generateCountry())
                .enterDummyCity(generateCity())
                .enterDummyUsername(generateUserName())
                .enterDummyPassword(generatePassword())
                .clickSubmitButton();
        Assert.assertEquals(practiceSitePage.getAlertMessage().getText(), practiceSitePage.getAlertMessageText());
    }
}

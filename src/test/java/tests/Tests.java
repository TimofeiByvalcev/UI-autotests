package tests;

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

        Assert.assertTrue(checkPresenceOfElement(homePage.getHomePageHeader()));
        Assert.assertTrue(checkPresenceOfElement(homePage.getHorizontalMenu()));
        Assert.assertTrue(checkPresenceOfElement(homePage.getCertificationsBlock()));
        Assert.assertTrue(checkPresenceOfElement(homePage.getCoursesBlock()));
        Assert.assertTrue(checkPresenceOfElement(homePage.getHomePageFooter()));

        moveToElement(homePage.getCoursesBlock());

        int nextCourseIndex = homePage.getCourseAttributeValue(homePage.getNextCourseCarousel());
        clickElement(homePage.getCourseCarouselNextArrow());

        Assert.assertEquals(homePage.getCourseAttributeValue(homePage.getActiveCourseCarousel()), nextCourseIndex, "Slider isn't work");

    }

    /**
     * Check header displaying after scroll.
     */
    @Test
    public void testMenuInHeaderAfterScroll() {
        HomePage homePage = new HomePage().openHomePage();

        moveToElement(homePage.getHomePageFooter());

        Assert.assertTrue(checkPresenceOfElement(homePage.getHomePageHeader()), "Header isn't displayed after scroll");
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
                .enterUsername(PracticeSite2Page.USER_NAME)
                .enterPassword(PracticeSite2Page.PASSWORD)
                .enterUserNameDescription("Test")
                .clickLoginButton();

        Assert.assertEquals(practiceSite2HomePage.getPageTitle().getText(), PracticeSite2HomePage.PAGE_TITLE);
        Assert.assertEquals(practiceSite2HomePage.getLoggedInMessage().getText(), PracticeSite2HomePage.LOGGED_IN_MESSAGE);
    }

    /**
     * Check that About Us page opening from footer.
     */
    @Test
    public void openAboutUsPage() {
        AboutUsPage aboutUsPage = new HomePage()
                .openHomePage()
                .openAboutUsPage();
        Assert.assertEquals(aboutUsPage.getAboutUsTitle().getText(), AboutUsPage.PAGE_TITLE);
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
        Assert.assertEquals(practiceSitePage.getAlertMessage().getText(), PracticeSitePage.ALERT_MESSAGE);
    }
}

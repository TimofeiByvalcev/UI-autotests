package tests;

import helpers.FakeData;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AboutUsPage;
import pages.BasePage;
import pages.HomePage;
import pages.PracticeSite2HomePage;
import pages.PracticeSite2Page;
import pages.PracticeSitePage;

/**
 * Tests class provides UI tests for way2automation site.
 */
public class Tests extends BaseTest {

    BasePage basePage = new BasePage();
    /**
     * Check presence of elements on the home page.
     */
    @Feature("Presence and work of elements")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Home page is opened and elements are presented")
    @Test(testName = "Check presence of elements")
    @Description("In this test we check that needed elements presented on the page")
    public void testPresenceOfElements() {
        HomePage homePage = new HomePage().openHomePage();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(basePage.checkScrollPresence());
        softAssert.assertTrue(basePage.checkPresenceOfElement(homePage.getHomePageHeader()));
        softAssert.assertTrue(basePage.checkPresenceOfElement(homePage.getHorizontalMenu()));
        softAssert.assertTrue(basePage.checkPresenceOfElement(homePage.getCertificationsBlock()));
        softAssert.assertTrue(basePage.checkPresenceOfElement(homePage.getCoursesBlock()));
        softAssert.assertTrue(basePage.checkPresenceOfElement(homePage.getHomePageFooter()));
        softAssert.assertAll();
    }

    @Feature("Presence and work of elements")
    @Severity(SeverityLevel.NORMAL)
    @Story("Home page is opened and courses carousel is work correctly")
    @Test(testName = "Check courses carousel is work")
    @Description("In this test we check that courses carousel works")
    public void testCoursesCarousel() throws InterruptedException {
        HomePage homePage = new HomePage().openHomePage();

        basePage.moveToElement(homePage.getCoursesBlock());

        String activeCourseName = homePage.getCourseName(homePage.getActiveCourseCarousel());
        basePage.clickElement(homePage.getCourseCarouselPrevArrow());
        basePage.waitElementHasClass(homePage.getNextCourseCarousel(), "swiper-slide-next");
        Assert.assertEquals(homePage.getCourseName(homePage.getNextCourseCarousel()), activeCourseName, "Slider isn't work");

        String nextCourseName = homePage.getCourseName(homePage.getNextCourseCarousel());
        basePage.clickElement(homePage.getCourseCarouselNextArrow());
        Assert.assertEquals(homePage.getCourseName(homePage.getActiveCourseCarousel()), nextCourseName, "Slider isn't work");
    }

    /**
     * Check header displaying after scroll.
     */
    @Feature("Presence and work of elements")
    @Severity(SeverityLevel.NORMAL)
    @Story("Header is visible after page scrolling")
    @Test(testName = "Check that header is displayed after scroll")
    @Description("In this test we check that header is displaying after scroll")
    public void testMenuInHeaderAfterScroll() {
        HomePage homePage = new HomePage().openHomePage();

        basePage.moveToElement(homePage.getHomePageFooter());

        Assert.assertTrue(basePage.checkPresenceOfElement(homePage.getHomePageHeader()), "Header isn't displayed after scroll");
    }

    /**
     * Check Practice Site page opening from horizontal menu.
     */
    @Feature("Pages opening")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Practice Site page is opened from horizontal menu")
    @Test(testName = "Check that page can be opened from horizontal menu")
    @Description("In this test we check page opening from horizontal menu")
    public void testOpenPracticeSite() {
        PracticeSitePage practiceSitePage = new HomePage()
                .openHomePage()
                .openPageFromMenu()
                .clickTestingWebsiteLink();

        Assert.assertEquals(practiceSitePage.getPageDescription().getText(), practiceSitePage.PAGE_DESCRIPTION);
    }

    /**
     * Test authorization form on Practice Site 2 page with valid data.
     */
    @Feature("Test authorizations on site")
    @Severity(SeverityLevel.MINOR)
    @Story("Authorization form works on Practice Site 2 page")
    @Test(testName = "Check authorization on the Practice Site 2 angular form")
    @Description("In this test we check authorization form on Practice Site 2 page")
    public void authorization() {
        PracticeSite2Page practiceSite2Page = new PracticeSite2Page();

        PracticeSite2HomePage practiceSite2HomePage = practiceSite2Page
                .openRegistrationPage()
                .enterUsername(practiceSite2Page.USER_NAME)
                .enterPassword(practiceSite2Page.PASSWORD)
                .enterUserNameDescription("Test")
                .clickLoginButton();

        Assert.assertEquals(practiceSite2HomePage.getPageTitle().getElement().getText(), practiceSite2HomePage.PAGE_TITLE);
        Assert.assertEquals(practiceSite2HomePage.getLoggedInMessage().getElement().getText(), practiceSite2HomePage.LOGGED_IN_MESSAGE);
    }

    /**
     * Check that About Us page opening from footer.
     */
    @Feature("Pages opening")
    @Severity(SeverityLevel.NORMAL)
    @Story("About Us page is opened from footer")
    @Test(testName = "Check the opening of About Us page")
    @Description("In this test we check that About Us page is opening")
    public void testOpenAboutUsPage() {
        AboutUsPage aboutUsPage = new HomePage()
                .openHomePage()
                .openAboutUsPage();
        Assert.assertEquals(aboutUsPage.getAboutUsTitle().getElement().getText(), aboutUsPage.PAGE_TITLE);
    }

    /**
     * Check that dummy registration form is work.
     */
    @Feature("Test authorizations on site")
    @Severity(SeverityLevel.MINOR)
    @Story("Dummy registration form returns alert message after registration")
    @Test(testName = "Check registration in dummy registration form")
    @Description("In this test we check dummy registration form on practice site 1")
    public void testFillDummyRegistrationForm() {
        PracticeSitePage practiceSitePage = new PracticeSitePage()
                .openPracticeSitePage()
                .enterDummyName(FakeData.generateFullName())
                .enterDummyPhone(FakeData.generatePhoneNumber())
                .enterDummyEmail(FakeData.generateEmail())
                .selectDummyCountry(FakeData.generateCountry())
                .enterDummyCity(FakeData.generateCity())
                .enterDummyUsername(FakeData.generateUserName())
                .enterDummyPassword(FakeData.generatePassword())
                .clickSubmitButton();
        Assert.assertEquals(practiceSitePage.getAlertMessage().getText(), practiceSitePage.ALERT_MESSAGE);
    }

    @Feature("Test authorizations on site")
    @Severity(SeverityLevel.MINOR)
    @Story("Authorization form works on Practice Site 2 page")
    @Test(testName = "Check that fields are required on the Practice Site 2 angular form using JS Executor")
    @Description("In this test we check that all field are required in the form on Practice Site 2 page using JS Executor")
    public void testRequiredField() {
        SoftAssert softAssert = new SoftAssert();
        PracticeSite2Page practiceSite2Page = new PracticeSite2Page().openRegistrationPage();

        practiceSite2Page.enterUsernameJS();
        softAssert.assertTrue(basePage.checkPresenceOfElement(practiceSite2Page.getUsernameAlertMessage()));

        practiceSite2Page.enterPasswordJS();
        softAssert.assertTrue(basePage.checkPresenceOfElement(practiceSite2Page.getPasswordAlertMessage()));

        practiceSite2Page.enterUsernameDescriptionJS();
        softAssert.assertTrue(basePage.checkPresenceOfElement(practiceSite2Page.getUsernameDescription()));

        softAssert.assertAll();
    }
}

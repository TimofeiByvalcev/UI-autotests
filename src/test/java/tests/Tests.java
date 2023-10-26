package tests;

import helpers.FakeData;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static helpers.FakeData.*;

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

        Assert.assertTrue(homePage.checkPresenceOfElements(), "One of elements is not displayed on the page");
        Assert.assertTrue(homePage.checkSliderWork(), "Slider is not work");
    }

    /**
     * Check header displaying after scroll.
     */
    @Test
    public void testMenuInHeaderAfterScroll() {
        HomePage homePage = new HomePage().openHomePage();

        Assert.assertTrue(homePage.checkHeaderMenuAfterScroll(), "Header isn't displayed after scroll");
    }

    /**
     * Check Practice Site page opening from horizontal menu.
     */
    @Test
    public void testOpenPracticeSite() {
        PracticeSitePage practiceSitePage = new HomePage()
                .openHomePage()
                .openPagesFromMenu()
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
                .enterUserNameDescription("Test").clickLoginButton();

        Assert.assertEquals(practiceSite2HomePage.getPageTitle().getText(), practiceSite2HomePage.getPageTitleText());
        Assert.assertEquals(practiceSite2HomePage.getLoggedInMessage().getText(), practiceSite2HomePage.getLoggedInMessageText());
    }

    /**
     * Check About Us page opening from footer.
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
                .enterDummyName(FULL_NAME)
                .enterDummyPhone(PHONE_NUMBER)
                .enterDummyEmail(EMAIL)
                .selectDummyCountry(COUNTRY)
                .enterDummyCity(CITY)
                .enterDummyUsername(USERNAME)
                .enterDummyPassword(PASSWORD)
                .clickSubmitButton();
        Assert.assertEquals(practiceSitePage.getAlertMessage().getText(), practiceSitePage.getAlertMessageText());
    }
}

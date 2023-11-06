package tests;

import helpers.AuthorizationDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PracticeSite2HomePage;
import pages.PracticeSite2Page;

public class TestsWithDDT extends BaseTest {

    @Feature("Test authorizations on site")
    @Severity(SeverityLevel.MINOR)
    @Story("Authorization form works on Practice Site 2 page")
    @Parameters({ "Username", "Password", "Description", "Positive/Negative" })
    @Test(testName = "Check authorization on the Practice Site 2 angular form using data provider",
            dataProvider = "AuthorizationDataProvider",
            dataProviderClass = AuthorizationDataProvider.class)
    @Description("In this test we check authorization form on Practice Site 2 page using data provider ")
    public void authorization(String username, String password,
                              String description, boolean typeOfTest) {

        PracticeSite2Page practiceSite2Page = new PracticeSite2Page();

        PracticeSite2HomePage practiceSite2HomePage = practiceSite2Page
                .openRegistrationPage()
                .enterUsername(username)
                .enterPassword(password)
                .enterUserNameDescription(description)
                .clickLoginButton();
        if (typeOfTest) {
            Assert.assertEquals(practiceSite2HomePage.getPageTitle().getElement().getText(), practiceSite2HomePage.PAGE_TITLE);
            Assert.assertEquals(practiceSite2HomePage.getLoggedInMessage().getElement().getText(), practiceSite2HomePage.LOGGED_IN_MESSAGE);
            BasePage.backToPage();
        } else {
            Assert.assertTrue(BasePage.checkPresenceOfElement(practiceSite2Page.getAlertMessage()));
            BasePage.refreshPage();
        }

    }
}

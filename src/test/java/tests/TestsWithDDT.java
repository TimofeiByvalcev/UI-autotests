package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PracticeSite2HomePage;
import pages.PracticeSite2Page;

public class TestsWithDDT extends BaseTest {

    @DataProvider(name = "AuthorizationValidDataProvider")
    public static Object[][] getValidAuthorizationData() {

        Object[][] validAuthorizationData = {
                {"angular", "password", "Some description"},
                {"angular", "password", "test"}
        };
        return validAuthorizationData;
    }

    @DataProvider(name = "AuthorizationInvalidDataProvider")
    public static Object[][] getInvalidAuthorizationData() {
        Object[][] invalidAuthorizationData= {
                {"Test", "Test", "Test"},
                {"Andrey", "Rublev", "Painter"},
        };
        return invalidAuthorizationData;
    }
    @Feature("Test authorizations on site")
    @Severity(SeverityLevel.MINOR)
    @Story("Authorization form works on Practice Site 2 page")
    @Parameters({"Username", "Password", "Description"})
    @Test(testName = "Check authorization on the Practice Site 2 angular form using valid data provider",
            dataProvider = "AuthorizationValidDataProvider",
            dataProviderClass = TestsWithDDT.class)
    @Description("In this test we check authorization form on Practice Site 2 page using data provider with valid data")
    public void testValidAuthorization(String username, String password,
                                       String description) {

        PracticeSite2Page practiceSite2Page = new PracticeSite2Page();

        PracticeSite2HomePage practiceSite2HomePage = practiceSite2Page
                .openRegistrationPage()
                .enterUsername(username)
                .enterPassword(password)
                .enterUserNameDescription(description)
                .clickLoginButton();

        Assert.assertEquals(practiceSite2HomePage.getPageTitle().getElement().getText(), practiceSite2HomePage.PAGE_TITLE);
        Assert.assertEquals(practiceSite2HomePage.getLoggedInMessage().getElement().getText(), practiceSite2HomePage.LOGGED_IN_MESSAGE);
        BasePage.backToPage();
    }

    @Feature("Test authorizations on site")
    @Severity(SeverityLevel.MINOR)
    @Story("Authorization form works on Practice Site 2 page")
    @Parameters({"Username", "Password", "Description"})
    @Test(testName = "Check authorization on the Practice Site 2 angular form using invalid data provider",
            dataProvider = "AuthorizationInvalidDataProvider",
            dataProviderClass = TestsWithDDT.class)
    @Description("In this test we check authorization form on Practice Site 2 page using data provider with invalid data")
    public void testInvalidAuthorization(String username, String password,
                                         String description) {

        PracticeSite2Page practiceSite2Page = new PracticeSite2Page();

        PracticeSite2HomePage practiceSite2HomePage = practiceSite2Page
                .openRegistrationPage()
                .enterUsername(username)
                .enterPassword(password)
                .enterUserNameDescription(description)
                .clickLoginButton();

        Assert.assertTrue(BasePage.checkPresenceOfElement(practiceSite2Page.getAlertMessage()));
        BasePage.refreshPage();
    }
}


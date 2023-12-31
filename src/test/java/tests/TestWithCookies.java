package tests;

import helpers.CookieHandler;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SqlLoginPage;
import pages.SqlPersonalPage;

public class TestWithCookies extends BaseTest {

    @Feature("Authorization on SQL exercises")
    @Severity(SeverityLevel.MINOR)
    @Story("Authorization with cookies")
    @Test(testName = "Check authorization with cookies on SQL exercises site")
    @Description("In this test we check that authorization with cookies works")
    public void authWithCookie() {
        SqlLoginPage sqlLoginPage = new SqlLoginPage(driver).openLoginPage();
        if (CookieHandler.CheckFileExistence("src/test/resources/cookies.txt")) {
            CookieHandler.setCookieToDriver(driver, "src/test/resources/cookies.txt");
            sqlLoginPage.refreshPage();
            sqlLoginPage.clickProfileLink();

            SqlPersonalPage sqlPersonalPage = new SqlPersonalPage(driver);

            Assert.assertEquals(sqlPersonalPage.getPageTitle().getElement().getText(), SqlPersonalPage.PAGE_TITLE);
            Assert.assertTrue(sqlPersonalPage.checkPresenceOfElement(sqlPersonalPage.getLogoutButton()));
        } else {
            SqlPersonalPage sqlPersonalPage = new SqlLoginPage(driver)
                    .openLoginPage()
                    .enterLogin()
                    .enterPassword()
                    .clickEnter()
                    .clickProfileLink();
            Assert.assertEquals(sqlPersonalPage.getPageTitle().getElement().getText(), SqlPersonalPage.PAGE_TITLE);
            Assert.assertTrue(sqlPersonalPage.checkPresenceOfElement(sqlPersonalPage.getLogoutButton()));
            CookieHandler.writeCookiesToFile(driver, "src/test/resources/cookies.txt");
        }
    }
}

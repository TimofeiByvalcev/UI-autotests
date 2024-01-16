package helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DragNDropPage;
import pages.HomePage;
import pages.PracticeSite2Page;
import pages.PracticeSitePage;
import pages.SqlPersonalPage;

public class PageUtils {
    @Step("Open Home page")
    public static HomePage openHomePage(WebDriver driver) {
        driver.get(ReadProperties.readProperty("home_page_url"));
        return new HomePage(driver);
    }

    @Step("Open drag and drop page")
    public static DragNDropPage openDragNDropPage(WebDriver driver){
        driver.get(ReadProperties.readProperty("drag_n_drop_page"));
        return new DragNDropPage(driver);
    }

    @Step("Open Registration Site 2 page")
    public static PracticeSite2Page openRegistrationPage(WebDriver driver) {
        driver.get(ReadProperties.readProperty("practice_site2"));
        return new PracticeSite2Page(driver);
    }

    @Step("Open Practice Site page")
    public static PracticeSitePage openPracticeSitePage(WebDriver driver) {
        driver.get(ReadProperties.readProperty("practice_site1"));
        return new PracticeSitePage(driver);
    }

    @Step("Open Sql Personal page")
    public static SqlPersonalPage openPersonalPage(WebDriver driver) {
        driver.get(ReadProperties.readProperty("sql_personal_page"));
        return new SqlPersonalPage(driver);
    }
}

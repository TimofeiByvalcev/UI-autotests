package pages;

import helpers.ReadProperties;
import helpers.WebWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FramesAndWindowsPage extends BasePage{
    public static String handleHost;
    public FramesAndWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void createNewTab() {
        try {
            WebWindow tab2 = new WebWindow(driver, ReadProperties.readProperty("new_browser_tab"));
        } catch (Exception e) {
            System.err.println("Couldn't load second page");
        }
    }
}

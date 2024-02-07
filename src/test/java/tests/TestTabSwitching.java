package tests;

import helpers.PageUtils;
import helpers.WebWindow;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramesAndWindowsPage;

public class TestTabSwitching extends BaseTest{
    @Test
    public void switchTab() throws InterruptedException {
        FramesAndWindowsPage framesAndWindowsPage = PageUtils.openFramesAndWindowsPage(driver);
        framesAndWindowsPage.createNewTab();
        framesAndWindowsPage.createNewTab();
        Assert.assertEquals(WebWindow.getInstanceCount(), 2, "Third tab isn't opened successfully");
    }
}

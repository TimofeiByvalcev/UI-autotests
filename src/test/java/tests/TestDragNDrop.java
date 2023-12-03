package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragNDropPage;

public class TestDragNDrop extends BaseTest {

    @Feature("Drag and Drop")
    @Severity(SeverityLevel.MINOR)
    @Story("Drag and drop web element")
    @Test(testName = "Check drag and drop functionality")
    @Description("In this test we check drag and drop functionality on the page")
    public void testDragNDrop() {
        DragNDropPage dragNDropPage = new DragNDropPage().openDragNDropPage().dragNDrop();
        Assert.assertEquals(dragNDropPage.getTextAfterDrop().getText(), dragNDropPage.TEXT_AFTER_DROP);
    }
}

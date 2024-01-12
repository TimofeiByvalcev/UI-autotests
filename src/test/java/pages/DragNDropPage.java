package pages;

import helpers.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragNDropPage extends BasePage{

    public final String TEXT_AFTER_DROP = "Dropped!";

    @FindBy(id = "draggable")
    private WebElement draggableElement;

    @FindBy(id = "droppable")
    private WebElement droppableElement;

    @FindBy(xpath = "//iframe[@src = 'droppable/default.html']")
    private WebElement dragNDropIFrame;

    @FindBy(xpath = "//div[@id = 'droppable']/p")
    private WebElement textAfterDrop;

    public DragNDropPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Open drag and drop page")
    public DragNDropPage openDragNDropPage() {
        driver.get(ReadProperties.readProperty("drag_n_drop_page"));
        return new DragNDropPage(driver);
    }
    @Step("Drag and drop element")
    public DragNDropPage dragNDrop() {
        new DragNDropPage(driver).waitForElement(wrapElement(dragNDropIFrame, "DragNDrop Iframe"));
        driver.switchTo().frame(dragNDropIFrame);
        new Actions(driver).dragAndDrop(wrapElement(draggableElement, "Draggable element").getElement(),
                wrapElement(droppableElement, "Droppable element").getElement()).perform();
        return new DragNDropPage(driver);
    }

    public WebElement getTextAfterDrop() {
        return textAfterDrop;
    }
}

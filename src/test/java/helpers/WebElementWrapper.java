package helpers;

import org.openqa.selenium.WebElement;

public class WebElementWrapper {
    private WebElement element;
    private String description;

    public WebElementWrapper(WebElement element, String description) {
        this.element = element;
        this.description = description;
    }

    // Getter for the WebElement
    public WebElement getElement() {
        return element;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Overriding toString() to display only the description
    @Override
    public String toString() {
        return description;
    }
}


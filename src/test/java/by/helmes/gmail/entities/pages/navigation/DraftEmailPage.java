package by.helmes.gmail.entities.pages.navigation;

import by.helmes.gmail.entities.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DraftEmailPage extends AbstractPage {
    private final String firstDraft = "//tr[@class=\"zA yO\"][1]";
    private final String bodyOfFirstDraft = "//*[@class=\"y2\"][1]/text()";

    public DraftEmailPage(WebDriver driver) {
        super(driver);
    }

    public String getBodyOfFirstDraft() {
        waitForElementVisible(getElementBy(firstDraft));
        return getElement(bodyOfFirstDraft).getText();
    }
}

package by.helmes.gmail.entities.pages.navigation;

import by.helmes.gmail.entities.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DraftEmailPage extends AbstractPage {
    private final String firstDraft = "//tr[@class='zA yO'][1]";
    private final String bodyOfFirstDraft = "//*[@class='y2'][1]/text()";
//    private final String searchField = "//input[@class='gb_gf']";
//    private final String searchBtn = "//button[@class='gb_pf gb_qf']";
//    private final String searchResults = "//tr[@class='zA yO']";

    public DraftEmailPage(WebDriver driver) {
        super(driver);
    }

    public String getBodyOfFirstDraft() {
        waitForElementVisible(getElementBy(firstDraft));
        return getElement(bodyOfFirstDraft).getText();
    }

//    public DraftEmailPage searchForText (String text){
//        changeWindow();
//        waitForElementClickable(getElementBy(searchField));
//        getElement(searchField).click();
//        getElement(searchField).sendKeys(text);
//        getElement(searchBtn).click();
//        return this;
//    }
//
//    public boolean verifySearchResults (){
//        waitForElementClickable(getElementBy(searchResults));
//        return getElement(searchResults).isDisplayed();
//    }
}

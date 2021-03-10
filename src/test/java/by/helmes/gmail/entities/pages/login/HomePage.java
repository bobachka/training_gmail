package by.helmes.gmail.entities.pages.login;

import by.helmes.gmail.entities.pages.AbstractPage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;

public class HomePage extends AbstractPage {

    //private static String logo = "//*[@href=\"#inbox\"]";
    private static String logo = "//*[@class=\"gb_le gb_qc gb_je\"]";
    //    private static String composeEmailBtn = "//div[contains(text(),'Написать']";
    private static String composeEmailBtn = "//*[@class=\"T-I T-I-KE L3\"]";
    private static String InboxCounter = "//*[@class=\"bsU\"]";
    private NewEmailPage newEmailPage = new NewEmailPage();
    private HomePage homePage = null;

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        waitForElementPresence(getElementBy(logo));
        return homePage;
    }

    public boolean isLogoPresent() {
        if (getElement(logo).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public NewEmailPage composeEmail() {
        waitForElementPresence(getElementBy(composeEmailBtn));
        getElement(composeEmailBtn).click();
        return newEmailPage.getNewEmailPage();
    }

    public String getInboxTotal() {
        waitForElementVisible(getElementBy(InboxCounter));
        return getElement(InboxCounter).getText();
    }

}

package by.helmes.gmail.entities.pages.login;

import by.helmes.gmail.entities.pages.AbstractPage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    //private static String logo = "//*[@href=\"#inbox\"]";
    private static String logo = "//*[@class=\"gb_le gb_qc gb_je\"]";
    //private static String composeEmailBtn = "//div[contains(text(),'Написать']";
    private static String composeEmailBtn = "//*[@class=\"T-I T-I-KE L3\"]";
    private static String InboxCounter = "//*[@class=\"bsU\"]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage getHomePage() {
        HomePage homePage = new HomePage(driver);
        waitForElementPresence(getElementBy(logo));
        return homePage;
    }

    public boolean isLogoPresent() {
        return getElement(logo).isDisplayed();
    }

    public NewEmailPage composeEmail() {
        waitForElementPresence(getElementBy(composeEmailBtn));
        getElement(composeEmailBtn).click();
        return new NewEmailPage(driver);
    }

    public String getInboxTotal() {
        waitForElementVisible(getElementBy(InboxCounter));
        return getElement(InboxCounter).getText();
    }

}

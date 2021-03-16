package by.helmes.gmail.entities.pages.login;

import by.helmes.gmail.entities.pages.AbstractPage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends AbstractPage {

    //private static String logo = "//*[@href=\"#inbox\"]";
    private static String logo = "//*[@class=\"gb_le gb_qc gb_je\"]";
    //private static String composeEmailBtn = "//div[contains(text(),'Написать']";
    private static String composeEmailBtn = "//*[@class=\"T-I T-I-KE L3\"]";
    private static String InboxCounter = "//*[@class=\"bsU\"]";
    private static String lastUnreadEmail = "//tr[@class=\"zA zE\"][1]";
    private static String unreadEmails = "//tr[@class=\"zA zE\"]";
    //private static String lastUnreadCheckbox = "//*[@role=\"checkbox\"]";
    private static String lastUnreadCheckbox = "//*[@class=\"oZ-jc T-Jo J-J5-Ji \"][1]";
    private static String trashBin = "//*[@class=\"T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs mA\"]";

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

    public HomePage deleteLastUnreadEmail() {
        //WebElement lastUnreadEmailElement = getElement(lastUnreadEmail);
        waitForElementPresence(getElementBy(lastUnreadCheckbox));
        getElement(lastUnreadCheckbox).click();
        waitForElementPresence(getElementBy(trashBin));
        getElement(trashBin).click();
        wait(5000);
        return this;
    }

    public int countUnreadEmails() {
        List<WebElement> unreadEmailsList = driver.findElements(By.xpath(unreadEmails));
        return unreadEmailsList.size();
    }

}

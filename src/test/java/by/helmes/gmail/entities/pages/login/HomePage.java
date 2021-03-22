package by.helmes.gmail.entities.pages.login;

import by.helmes.gmail.entities.pages.AbstractPage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends AbstractPage {
    private final String logo = "//*[@class=\"gb_le gb_qc gb_je\"]";
    private final String composeEmailBtn = "//*[@class=\"T-I T-I-KE L3\"]";
    private final String inboxCounter = "//*[@class=\"bsU\"]";
    private final String lastUnreadEmail = "//tr[@class=\"zA zE\"][1]";
    private final String unreadEmails = "//tr[@class=\"zA zE\"]";
    private final String lastUnreadCheckbox = "//*[@class=\"oZ-jc T-Jo J-J5-Ji \"][1]";
    private final String trashBin = "//*[@class=\"T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs mA\"]";

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
        waitForElementVisible(getElementBy(inboxCounter));
        return getElement(inboxCounter).getText();
    }

    public HomePage deleteLastUnreadEmail() {
        //WebElement lastUnreadEmailElement = getElement(lastUnreadEmail);
        waitForElementPresence(getElementBy(lastUnreadCheckbox));
        getElement(lastUnreadCheckbox).click();
        waitForElementPresence(getElementBy(trashBin));
        getElement(trashBin).click();

//TODO  replace with implicit waiter
        wait(5000);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //waitForTextChange(getElementBy(inboxCounter),getInboxTotal());
        return this;
    }

    public int countUnreadEmails() {
        List<WebElement> unreadEmailsList = driver.findElements(By.xpath(unreadEmails));
        return unreadEmailsList.size();
    }

}

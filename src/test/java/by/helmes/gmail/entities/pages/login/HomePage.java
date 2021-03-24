package by.helmes.gmail.entities.pages.login;

import by.helmes.gmail.entities.pages.AbstractPage;
import by.helmes.gmail.entities.pages.navigation.DeletedEmailPage;
import by.helmes.gmail.entities.pages.navigation.DraftEmailPage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;
import by.helmes.gmail.entities.pages.navigation.SentEmailPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    private final String logo = "//*[@class=\"gb_uc\"]";
    private final String composeEmailBtn = "//*[@class=\"T-I T-I-KE L3\"]";
    private final String inboxCounter = "//*[@class=\"bsU\"]";
    private final String lastUnreadEmail = "//tr[@class=\"zA zE\"][1]";
    private final String unreadEmails = "//tr[@class=\"zA zE\"]";
    private final String lastUnreadCheckbox = "//*[@class=\"oZ-jc T-Jo J-J5-Ji \"][1]";
    private final String trashBin = "//*[@class=\"T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs mA\"]";
    private final String draftLink = "//div[@class=\"TN bzz aHS-bnq\"]";
    private final String sentLink = "//a[@href=\"https://mail.google.com/mail/u/0/#sent\"]";
    private final String moreBtn = "//span[@class='J-Ke n4 ah9']";
    private final String deletedLink = "//a[@href=\"https://mail.google.com/mail/u/0/#trash\"]";

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

    public NewEmailPage openNewEmail() {
        waitForElementPresence(getElementBy(composeEmailBtn));
        getElement(composeEmailBtn).click();
        return new NewEmailPage(driver);
    }

    public String getInboxTotal() {
        try {
            waitForElementVisible(getElementBy(inboxCounter));
            return getElement(inboxCounter).getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public HomePage deleteLastUnreadEmail() {
        waitForElementPresence(getElementBy(lastUnreadCheckbox));
        getElement(lastUnreadCheckbox).click();
        waitForElementPresence(getElementBy(trashBin));
        String inboxTotalBeforeDeleting = getInboxTotal();
        getElement(trashBin).click();
        waitForTextChange(getElementBy(inboxCounter), String.valueOf(Integer.parseInt(inboxTotalBeforeDeleting) - 1));
        return this;
    }

    public DraftEmailPage navigateToDraft() {
        waitForElementPresence(getElementBy(draftLink));
        getElement(draftLink).click();
        return new DraftEmailPage(driver);
    }


    public SentEmailPage navigateToSent() {
        waitForElementPresence(getElementBy(sentLink));
        getElement(sentLink).click();
        return new SentEmailPage(driver);
    }


    public DeletedEmailPage navigateToDeleted() {
        hoverOnItem(sentLink);
        scrollDown();
        waitForElementClickable(getElementBy(moreBtn));
        getElement(moreBtn).click();
        scrollDown();
        waitForElementPresence(getElementBy(deletedLink));
        getElement(deletedLink).click();
        return new DeletedEmailPage(driver);
    }

    public DeletedEmailPage navigateToDeletedAgain() {
        hoverOnItem(sentLink);
        scrollDown();
        waitForElementPresence(getElementBy(deletedLink));
        getElement(deletedLink).click();
        return new DeletedEmailPage(driver);
    }

}

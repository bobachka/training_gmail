package by.helmes.gmail.entities.helpers.login;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.login.HomePage;
import by.helmes.gmail.entities.pages.navigation.DeletedEmailPage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;
import by.helmes.gmail.entities.pages.navigation.SentEmailPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomeHelper extends AbstractHelper {
    private HomePage homePage;

    public HomeHelper(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    @Step("check Home Logo")
    public boolean checkHomeLogo() {
        return homePage.getHomePage().isLogoPresent();
    }

    @Step("get Inbox Results Total")
    public int getInboxResultsTotal() {
        return Integer.parseInt(homePage.getInboxTotal());
    }

    @Step("open New Email")
    public NewEmailPage openNewEmail() {
        return homePage.openNewEmail();
    }

    @Step("delete Last Unread Email")
    public HomePage deleteLastUnreadEmail() {
        return homePage.deleteLastUnreadEmail();
    }

    @Step("navigate To Sent")
    public SentEmailPage navigateToSent() {
        return homePage.navigateToSent();
    }

    @Step("navigate To Deleted")
    public DeletedEmailPage navigateToDeleted() {
        return homePage.navigateToDeleted();
    }

    @Step("navigate To Deleted Again")
    public DeletedEmailPage navigateToDeletedAgain() {
        return homePage.navigateToDeletedAgain();
    }

    @Step("search for {text} in sent")
    public boolean searchForBodySent (String text){
        return homePage.searchForText(text).verifySearchResultsSent();
    }

    @Step("search for {text} in edited")
    public boolean searchForBodyEdited (String text){
        return homePage.searchForText(text).verifySearchResultsEdited();
    }

    public boolean searchForBodyDeleted (String text){
        return homePage.searchForText(text).verifySearchResultsDeleted();
    }
}

package by.helmes.gmail.entities.helpers.login;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.login.HomePage;
import by.helmes.gmail.entities.pages.navigation.DeletedEmailPage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;
import by.helmes.gmail.entities.pages.navigation.SentEmailPage;
import org.openqa.selenium.WebDriver;

public class HomeHelper extends AbstractHelper {
    private HomePage homePage;

    public HomeHelper(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    public boolean checkHomeLogo() {
        return homePage.getHomePage().isLogoPresent();
    }

    public int getInboxResultsTotal() {
        return Integer.parseInt(homePage.getInboxTotal());
    }

    public NewEmailPage openNewEmail() {
        return homePage.openNewEmail();
    }

    public HomePage deleteLastUnreadEmail() {
        return homePage.deleteLastUnreadEmail();
    }

    public SentEmailPage navigateToSent() {
        return homePage.navigateToSent();
    }

    public DeletedEmailPage navigateToDeleted() {
        return homePage.navigateToDeleted();
    }

    public DeletedEmailPage navigateToDeletedAgain() {
        return homePage.navigateToDeletedAgain();
    }
}

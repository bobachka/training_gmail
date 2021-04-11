package by.helmes.gmail.entities.helpers.navigation;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.navigation.DeletedEmailPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DeletedEmailHelper extends AbstractHelper {
    private DeletedEmailPage deletedEmailPage;

    public DeletedEmailHelper(WebDriver driver) {
        super(driver);
        deletedEmailPage = new DeletedEmailPage(driver);
    }

    @Step("count Deleted Emails")
    public int countDeletedEmails() {
        return deletedEmailPage.countDeletedEmails();
    }

    @Step("navigate Back To Home")
    public void navigateBackToHome() {
        deletedEmailPage.BackToHome();
    }
}

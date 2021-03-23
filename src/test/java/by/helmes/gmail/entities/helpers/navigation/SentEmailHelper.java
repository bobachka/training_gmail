package by.helmes.gmail.entities.helpers.navigation;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.navigation.SentEmailPage;
import org.openqa.selenium.WebDriver;

public class SentEmailHelper extends AbstractHelper {

    private SentEmailPage sentEmailPage;

    public SentEmailHelper(WebDriver driver) {
        super(driver);
        sentEmailPage = new SentEmailPage(driver);
    }

    public int countSendEmails() {
        return sentEmailPage.countSendEmails();
    }



}

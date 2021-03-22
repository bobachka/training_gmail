package by.helmes.gmail.entities.helpers.navigation;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.login.HomePage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;
import org.openqa.selenium.WebDriver;

public class NewEmailHelper extends AbstractHelper {
    private NewEmailPage newEmailPage;

    public NewEmailHelper (WebDriver driver){
        super(driver);
        newEmailPage = new NewEmailPage(driver);
    }

    public HomePage sendNewLetter(String receiver){
        return newEmailPage.fillReceiver(receiver)
                .fillSubject()
                .fillBody()
                .sendEmail();
    }

}

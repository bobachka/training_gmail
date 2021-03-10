package by.helmes.gmail.entities.helpers;

import by.helmes.gmail.entities.pages.login.HomePage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;

public class NewEmailHelper extends AbstractHelper{

    NewEmailPage newEmailPage = new NewEmailPage();

    public HomePage sendNewLetter(String receiver){
        return newEmailPage.fillReceiver(receiver)
                .fillSubject()
                .fillBody()
                .sendEmail();
    }

}

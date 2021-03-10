package by.helmes.gmail.entities.helpers.login;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.login.HomePage;
import by.helmes.gmail.entities.pages.login.PasswordPage;

public class PasswordHelper extends AbstractHelper {
    PasswordPage passwordPage = new PasswordPage();


    public HomePage fillInPassword(String password) {
        passwordPage
                .fillPasswordField(password)
                .clickNextBtn();
        return new HomePage();
    }

}

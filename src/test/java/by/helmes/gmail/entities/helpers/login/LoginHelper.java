package by.helmes.gmail.entities.helpers.login;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.login.LoginPage;
import by.helmes.gmail.entities.pages.login.PasswordPage;

public class LoginHelper extends AbstractHelper {
    LoginPage loginPage = new LoginPage();

    public LoginHelper navigateToHomePage() {
        loginPage.navigateToLoginPage();
        return this;
    }

    public PasswordPage fillInLogin(String login) {
        loginPage
                .fillLoginField(login)
                .clickNextBtn();
        return new PasswordPage();
    }

}

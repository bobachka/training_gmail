package by.helmes.gmail.entities.helpers.login;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.login.LoginPage;
import by.helmes.gmail.entities.pages.login.PasswordPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends AbstractHelper {
    LoginPage loginPage;

    public LoginHelper(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    @Step("navigate To Home Page")
    public LoginHelper navigateToHomePage() {
        loginPage.navigateToLoginPage();
        return this;
    }

    @Step("fill in {login}")
    public PasswordPage fillInLogin(String login) {
        loginPage
                .fillLoginField(login)
                .clickNextBtn();
        return new PasswordPage(driver);
    }

}

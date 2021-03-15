package by.helmes.gmail.entities.helpers.login;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.login.HomePage;
import by.helmes.gmail.entities.pages.login.PasswordPage;
import org.openqa.selenium.WebDriver;

public class PasswordHelper extends AbstractHelper {
    PasswordPage passwordPage;

    public PasswordHelper(WebDriver driver) {
        super(driver);
        passwordPage = new PasswordPage(driver);
    }

    public HomePage fillInPassword(String password) {
        passwordPage
                .fillPasswordField(password)
                .clickNextBtn();
        return new HomePage(driver);
    }

}

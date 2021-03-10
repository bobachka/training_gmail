package by.helmes.gmail.tests;

import by.helmes.gmail.entities.helpers.NewEmailHelper;
import by.helmes.gmail.entities.helpers.login.HomeHelper;
import by.helmes.gmail.entities.helpers.login.LoginHelper;
import by.helmes.gmail.entities.helpers.login.PasswordHelper;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class EditEmailTests {
    private LoginHelper loginHelper = new LoginHelper();
    private PasswordHelper passwordHelper = new PasswordHelper();
    private HomeHelper homeHelper = new HomeHelper();
    private NewEmailHelper newEmailHelper = new NewEmailHelper();

    @Test
    @Description(value = "Тест проверяет ввод валидных значений в поле 'Контактный телефон'")
    public void sendEmail() {
        String login = "svieta.auto@gmail.com";
        String password = "Solera2020";
        loginHelper.navigateToHomePage();
        loginHelper.fillInLogin(login);
        passwordHelper.fillInPassword(password);

        int inboxResultsBefore = homeHelper.getInboxResultsTotal();

        homeHelper.composeEmail();
        newEmailHelper.sendNewLetter("svieta.auto@gmail.com");

        int inboxResultsAfter = homeHelper.getInboxResultsTotal();

        Assert.assertNotEquals(inboxResultsBefore, inboxResultsAfter);
    }

    @AfterSuite
    public void tearDown() {
        homeHelper.quit();
    }
}

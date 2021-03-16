package by.helmes.gmail.tests;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.entities.helpers.login.HomeHelper;
import by.helmes.gmail.entities.helpers.login.LoginHelper;
import by.helmes.gmail.entities.helpers.login.PasswordHelper;
import by.helmes.gmail.entities.helpers.navigation.NewEmailHelper;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeleteEmailTests extends BaseTest {
    private LoginHelper loginHelper;
    private PasswordHelper passwordHelper;
    private HomeHelper homeHelper;
    private NewEmailHelper newEmailHelper;

    private String login;
    private String password;


    @Parameters({"fileName"})
    @BeforeTest
    public void setupClass(String fileName) {
        setup(fileName);

        loginHelper = new LoginHelper(driver);
        passwordHelper = new PasswordHelper(driver);
        homeHelper = new HomeHelper(driver);
        newEmailHelper = new NewEmailHelper(driver);

        login = FrameworkCore.login;
        password = FrameworkCore.password;

        loginHelper.navigateToHomePage();
        loginHelper.fillInLogin(login);
        passwordHelper.fillInPassword(password);

        homeHelper.composeEmail();
        newEmailHelper.sendNewLetter(login);
    }


    @Test
    @Description(value = "Deleting email'")
    public void deleteEmail() {
        long id = Thread.currentThread().getId();
        System.out.println("Delete Email tests: Thread id is " + id);

        int unreadEmailsListBefore = homeHelper.countUnreadEmails();

        homeHelper.deleteLastUnreadEmail();

        int unreadEmailsListAfter = homeHelper.countUnreadEmails();

        Assert.assertEquals(unreadEmailsListBefore, unreadEmailsListAfter);
    }

    @AfterTest
    public void tearDown() {
        homeHelper.quit();
    }
}

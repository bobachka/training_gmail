package by.helmes.gmail.tests;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.entities.helpers.login.HomeHelper;
import by.helmes.gmail.entities.helpers.login.LoginHelper;
import by.helmes.gmail.entities.helpers.login.PasswordHelper;
import by.helmes.gmail.entities.helpers.navigation.DeletedEmailHelper;
import by.helmes.gmail.entities.helpers.navigation.NewEmailHelper;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;

public class DeleteEmailTest extends BaseTest {
    private LoginHelper loginHelper;
    private PasswordHelper passwordHelper;
    private HomeHelper homeHelper;
    private NewEmailHelper newEmailHelper;
    private DeletedEmailHelper deletedEmailHelper;
    private String login;
    private String password;


    @Parameters({"fileName"})
    @BeforeClass
    public void setupClass(String fileName) {
        login = FrameworkCore.login;
        password = FrameworkCore.password;
    }

    @BeforeMethod
    public void setupMethod() {
        setupTest();

        loginHelper = new LoginHelper(driver);
        passwordHelper = new PasswordHelper(driver);
        homeHelper = new HomeHelper(driver);
        newEmailHelper = new NewEmailHelper(driver);
        deletedEmailHelper = new DeletedEmailHelper(driver);

        loginHelper.navigateToHomePage();
        loginHelper.fillInLogin(login);
        passwordHelper.fillInPassword(password);
    }


    @Test
    @Description(value = "This test is to verify that inbox counter decreases after an email is deleted")
    public void deleteEmailAndCheckInboxCounter() {
        homeHelper.openNewEmail();
        newEmailHelper.sendNewEmail(login);
        int unreadEmailsListBefore = homeHelper.getInboxResultsTotal();

        homeHelper.deleteLastUnreadEmail();

        int unreadEmailsListAfter = homeHelper.getInboxResultsTotal();

        Assert.assertEquals(unreadEmailsListBefore - 1, unreadEmailsListAfter, "Email has not been deleted:");
    }

    @Test
    @Description(value = "This test is to verify that deleted email disappears from the deleted emails table")
    public void deleteEmailAndCheckDeletedTable() {

        homeHelper.navigateToDeleted();

        int deletedTableBefore = deletedEmailHelper.countDeletedEmails();

        deletedEmailHelper.navigateBackToHome();

        homeHelper.openNewEmail();
        newEmailHelper.sendNewEmail(login);
        homeHelper.deleteLastUnreadEmail();

        homeHelper.navigateToDeletedAgain();

        int deletedTableAfter = deletedEmailHelper.countDeletedEmails();

        Assert.assertEquals(deletedTableBefore, deletedTableAfter - 1, "Email has not been deleted:");
    }

    @AfterMethod
    public void tearDown() {
        cleanupTest();
    }
}

package by.helmes.gmail.tests;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.core.utils.LoggingUtils;
import by.helmes.gmail.entities.helpers.login.HomeHelper;
import by.helmes.gmail.entities.helpers.login.LoginHelper;
import by.helmes.gmail.entities.helpers.login.PasswordHelper;
import by.helmes.gmail.entities.helpers.navigation.NewEmailHelper;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;

public class DeleteEmailTest extends BaseTest {
    private LoginHelper loginHelper;
    private PasswordHelper passwordHelper;
    private HomeHelper homeHelper;
    private NewEmailHelper newEmailHelper;
    private String login;
    private String password;


//    @Parameters({"fileName"})
//    @BeforeClass
//    public void setupClass(String fileName) {
    @BeforeClass
    public void setupClass() {
        readConfigFile(null);

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
        LoggingUtils.logInfo("Delete Email tests: Thread id is " + id);

        int unreadEmailsListBefore = homeHelper.getInboxResultsTotal();

        homeHelper.deleteLastUnreadEmail();

        int unreadEmailsListAfter = homeHelper.getInboxResultsTotal();

        Assert.assertEquals(unreadEmailsListBefore - 1, unreadEmailsListAfter, "Email has not been deleted:");
    }

    @AfterMethod
    public void tearDown() {
        cleanupTest();
    }
}

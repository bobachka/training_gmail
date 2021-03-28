package by.helmes.gmail.tests;


import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.entities.helpers.login.HomeHelper;
import by.helmes.gmail.entities.helpers.login.LoginHelper;
import by.helmes.gmail.entities.helpers.login.PasswordHelper;
import by.helmes.gmail.entities.helpers.navigation.NewEmailHelper;
import by.helmes.gmail.entities.helpers.navigation.SentEmailHelper;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;

public class SendEmailTest extends BaseTest {
    private HomeHelper homeHelper;
    private NewEmailHelper newEmailHelper;
    private SentEmailHelper sentEmailHelper;

    private String login;
    private String password;

    @Parameters({"fileName"})
    @BeforeClass
    public void setupClass(String fileName) {
        readConfigFile(fileName);
        login = FrameworkCore.login;
        password = FrameworkCore.password;
    }

    @BeforeMethod
    public void setupMethod() {
        setupTest();
        LoginHelper loginHelper = new LoginHelper(driver);
        PasswordHelper passwordHelper = new PasswordHelper(driver);
        homeHelper = new HomeHelper(driver);
        newEmailHelper = new NewEmailHelper(driver);
        sentEmailHelper = new SentEmailHelper(driver);

        loginHelper.navigateToHomePage();
        loginHelper.fillInLogin(login);
        passwordHelper.fillInPassword(password);
    }

    @Test
    @Description(value = "This test is to verify that inbox counter increases after an email is sent")
    public void sendEmailAndCheckInboxCounter() {
        int inboxResultsBefore = homeHelper.getInboxResultsTotal();

        homeHelper.openNewEmail();
        newEmailHelper.sendNewEmail(login);

        int inboxResultsAfter = homeHelper.getInboxResultsTotal();

        Assert.assertEquals(inboxResultsBefore + 1, inboxResultsAfter, "Email has not been sent");
    }

    @Test
    @Description(value = "This test is to verify that sent email appears in the sent emails table")
    public void sendEmailAndCheckSentTable() {
        homeHelper.navigateToSent();

        int sentTableBefore = sentEmailHelper.countSendEmails();

        homeHelper.openNewEmail();
        newEmailHelper.sendNewEmail(login);

        int sentTableAfter = sentEmailHelper.countSendEmails();

        Assert.assertEquals(sentTableBefore, sentTableAfter - 1, "Email has not been sent");
    }


    @AfterMethod
    public void tearDown() {
        cleanupTest();
    }
}

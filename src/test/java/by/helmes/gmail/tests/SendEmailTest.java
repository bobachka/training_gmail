package by.helmes.gmail.tests;


import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.entities.helpers.login.HomeHelper;
import by.helmes.gmail.entities.helpers.login.LoginHelper;
import by.helmes.gmail.entities.helpers.login.PasswordHelper;
import by.helmes.gmail.entities.helpers.navigation.NewEmailHelper;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;

public class SendEmailTest extends BaseTest {
    private LoginHelper loginHelper;
    private PasswordHelper passwordHelper;
    private HomeHelper homeHelper;
    private NewEmailHelper newEmailHelper;

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
        loginHelper = new LoginHelper(driver);
        passwordHelper = new PasswordHelper(driver);
        homeHelper = new HomeHelper(driver);
        newEmailHelper = new NewEmailHelper(driver);
    }

    @Test
    @Description(value = "Sending email'")
    public void sendEmail() {
        long id = Thread.currentThread().getId();
        System.out.println("Send Email tests: Thread id is " + id);

        loginHelper.navigateToHomePage();
        loginHelper.fillInLogin(login);
        passwordHelper.fillInPassword(password);

        int inboxResultsBefore = homeHelper.getInboxResultsTotal();

        homeHelper.composeEmail();
        newEmailHelper.sendNewLetter(login);

        int inboxResultsAfter = homeHelper.getInboxResultsTotal();

        Assert.assertNotEquals(inboxResultsBefore, inboxResultsAfter);
    }

    @AfterMethod
    public void tearDown() {
        cleanupTest();
    }
}

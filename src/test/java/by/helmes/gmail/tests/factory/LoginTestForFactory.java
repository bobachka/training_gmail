package by.helmes.gmail.tests.factory;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.entities.helpers.login.HomeHelper;
import by.helmes.gmail.entities.helpers.login.LoginHelper;
import by.helmes.gmail.entities.helpers.login.PasswordHelper;
import by.helmes.gmail.entities.helpers.navigation.NewEmailHelper;
import by.helmes.gmail.entities.helpers.navigation.SentEmailHelper;
import by.helmes.gmail.tests.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestForFactory extends BaseTest {
    private HomeHelper homeHelper;
    private NewEmailHelper newEmailHelper;
    private SentEmailHelper sentEmailHelper;
    private LoginHelper loginHelper;
    private PasswordHelper passwordHelper;

    private String browser = "chrome";
    private String login;
    private String password;

    public LoginTestForFactory(String browser) {
        this.browser = browser;
    }


    @BeforeMethod
    public void setupMethod() {
        readConfigFile(null);
        login = FrameworkCore.login;
        password = FrameworkCore.password;

        setupTest(browser);
        loginHelper = new LoginHelper(driver);
        passwordHelper = new PasswordHelper(driver);
        homeHelper = new HomeHelper(driver);
        newEmailHelper = new NewEmailHelper(driver);
        sentEmailHelper = new SentEmailHelper(driver);
    }


    @Test
    @Description(value = "This test is to verify the login to gmail in several browsers via factory")
    public void loginToGmail() {
        loginHelper.navigateToHomePage();
        loginHelper.fillInLogin(login);
        passwordHelper.fillInPassword(password);

        Assert.assertTrue(homeHelper.checkHomeLogo(), "User is not logged in: ");
    }


    @AfterMethod
    public void tearDown() {
        cleanupTest();
    }
}

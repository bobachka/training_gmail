package by.helmes.gmail.tests;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.entities.helpers.login.HomeHelper;
import by.helmes.gmail.entities.helpers.login.LoginHelper;
import by.helmes.gmail.entities.helpers.login.PasswordHelper;
import by.helmes.gmail.entities.helpers.navigation.NewEmailHelper;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;

public class EditEmailTest extends BaseTest {
    private NewEmailHelper newEmailHelper;
    private HomeHelper homeHelper;
    private String login;
    private String password;


    @Parameters({"fileName"})
    @BeforeClass
    public void setupClass(String fileName) {
        readConfigFile(fileName);
//    @BeforeClass
//    public void setupClass() {
//        readConfigFile(null);

        login = FrameworkCore.login;
        password = FrameworkCore.password;
    }

    @BeforeMethod
    public void setupMethod() {
        setupTest();

        LoginHelper loginHelper = new LoginHelper(driver);
        PasswordHelper passwordHelper = new PasswordHelper(driver);
        //HomeHelper homeHelper = new HomeHelper(driver);
        newEmailHelper = new NewEmailHelper(driver);
        homeHelper = new HomeHelper(driver);

        loginHelper.navigateToHomePage();
        loginHelper.fillInLogin(login);
        passwordHelper.fillInPassword(password);

        homeHelper.openNewEmail();
        newEmailHelper.composeNewEmail(login);
    }


    @Test
    @Description(value = "This test is to verify that email body can be updated after new email window is minimised and restored back")
    public void minimiseRestoreUpdateBody() {
        //@Step ("f")
        newEmailHelper.minimiseEmail();
        newEmailHelper.restoreEmail();

        newEmailHelper.addTestText();

        String updatedBody = newEmailHelper.getBody();

        newEmailHelper.closeNewEmail();

        Assert.assertTrue(homeHelper.searchForBodyEdited(updatedBody), "Email with the updated body has not been found");
    }

    @Test
    @Description(value = "This test is to verify that email body can be updated after new email window is maximised and optimised back")
    public void maximiseOptimiseUpdateBody() {

        newEmailHelper.maximiseEmail();
        newEmailHelper.optimiseEmail();

        newEmailHelper.addTestText();

        String updatedBody = newEmailHelper.getBody();

        newEmailHelper.closeNewEmail();

        Assert.assertTrue(homeHelper.searchForBodyEdited(updatedBody), "Email with the updated body has not been found");
    }


    @AfterMethod
    public void tearDown() {
        cleanupTest();
    }
}

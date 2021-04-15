package by.helmes.gmail.tests;

import by.helmes.gmail.core.FrameworkCore;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class EditEmailTest extends BaseTest {
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
    public void setupMethod(ITestContext context) {
        setupTest(context);

        loginHelper.navigateToHomePage();
        loginHelper.fillInLogin(login);
        passwordHelper.fillInPassword(password);

        homeHelper.openNewEmail();
        newEmailHelper.composeNewEmail(login);
    }


    @Test
    @Description(value = "This test is to verify that email body can be updated after new email window is minimised and restored back")
    public void minimiseRestoreUpdateBody() {
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

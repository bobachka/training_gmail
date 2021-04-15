package by.helmes.gmail.tests;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.entities.helpers.navigation.DeletedEmailHelper;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class DeleteEmailTest extends BaseTest {
    private DeletedEmailHelper deletedEmailHelper;
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
    public void setupMethod(ITestContext context) {
        setupTest(context);

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

//    @Test
//    @Description(value = "This test is to verify that deleted email disappears from the deleted emails table")
//    public void deleteEmailAndCheckDeletedTable() {
//
//        homeHelper.navigateToDeleted();
//
//        int deletedTableBefore = deletedEmailHelper.countDeletedEmails();
//
//        deletedEmailHelper.navigateBackToHome();
//
//        homeHelper.openNewEmail();
//        newEmailHelper.sendNewEmail(login);
//        homeHelper.deleteLastUnreadEmail();
//
//        homeHelper.navigateToDeletedAgain();
//
//        int deletedTableAfter = deletedEmailHelper.countDeletedEmails();
//
//        Assert.assertEquals(deletedTableBefore, deletedTableAfter - 1, "Email has not been deleted:");
//    }
//
//
//    @Test
//    @Description(value = "This test is to verify that deleted email can not be found via search")
//    public void deleteEmailAndSearchForIt() {
//        homeHelper.openNewEmail();
//        newEmailHelper.composeNewEmail(login);
//        String emailBody = newEmailHelper.getBody();
//        newEmailHelper.clickSendBtn();
//
//        homeHelper.deleteLastUnreadEmail();
//
//        Assert.assertTrue(homeHelper.searchForBodyDeleted(emailBody), "Deleted email has been found");
//    }

    @AfterMethod
    public void tearDown() {
        cleanupTest();
    }
}

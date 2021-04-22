package by.helmes.gmail.entities.helpers.navigation;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.login.HomePage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class NewEmailHelper extends AbstractHelper {
    private NewEmailPage newEmailPage;

    public NewEmailHelper(WebDriver driver) {
        super(driver);
        newEmailPage = new NewEmailPage(driver);
    }

    @Step("compose New Email")
    public NewEmailPage composeNewEmail(String receiver) {
        return newEmailPage.fillReceiver(receiver)
                .fillSubject()
                .fillBody();
    }

    @Step("click Send Btn")
    public HomePage clickSendBtn(){
        return newEmailPage.sendNewEmail();
    }

    @Step("get Body")
    public String getBody(){
        return newEmailPage.getBody();
    }

    @Step("send New Email")
    public HomePage sendNewEmail(String receiver) {
        return composeNewEmail(receiver)
                .sendNewEmail();
    }

    @Step("minimise Email")
    public NewEmailPage minimiseEmail() {
        return newEmailPage.minimiseNewEmail();
    }

    @Step("restore Email")
    public NewEmailPage restoreEmail() {
        return newEmailPage.restoreNewEmail();
    }

    @Step("maximise Email")
    public NewEmailPage maximiseEmail() {
        return newEmailPage.maximiseNewEmail();
    }

    @Step("optimise Email")
    public NewEmailPage optimiseEmail() {
        return newEmailPage.optimiseNewEmail();
    }

    public NewEmailPage selectBody(){
        return newEmailPage.selectBody();
    }

    @Step("add Test Text")
    public String addTestText(){
        return newEmailPage.addTestText();
    }

    @Step("close New Email")
    public HomePage closeNewEmail() {
        return newEmailPage.closeNewEmail();
    }
}

package by.helmes.gmail.entities.helpers.navigation;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.login.HomePage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;
import org.openqa.selenium.WebDriver;

public class NewEmailHelper extends AbstractHelper {
    private NewEmailPage newEmailPage;

    public NewEmailHelper(WebDriver driver) {
        super(driver);
        newEmailPage = new NewEmailPage(driver);
    }

    public NewEmailPage composeNewEmail(String receiver) {
        return newEmailPage.fillReceiver(receiver)
                .fillSubject()
                .fillBody();
    }

    public String getBody(){
        return newEmailPage.getBody();
    }

    public HomePage sendNewEmail(String receiver) {
        return composeNewEmail(receiver)
                .sendNewEmail();
    }

    public NewEmailPage minimiseEmail() {
        return newEmailPage.minimiseNewEmail();
    }

    public NewEmailPage restoreEmail() {
        return newEmailPage.restoreNewEmail();
    }

    public NewEmailPage maximiseEmail() {
        return newEmailPage.maximiseNewEmail();
    }

    public NewEmailPage optimiseEmail() {
        return newEmailPage.optimiseNewEmail();
    }

    public NewEmailPage openTextFormatting() {
        return newEmailPage.openTextFormatting();
    }

    public NewEmailPage selectBody(){
        return newEmailPage.selectBody();
    }

    public String addTestText(){
        return newEmailPage.addTestText();
    }

    public NewEmailPage bodyBold() {
        return newEmailPage.makeBodyBold();
    }

    public NewEmailPage bodyItalic() {
        return newEmailPage.makeBodyItalic();
    }

    public NewEmailPage bodyRed() {
        return newEmailPage.makeBodyRed();
    }

    public HomePage closeEmail() {
        return newEmailPage.closeNewEmail();
    }
}

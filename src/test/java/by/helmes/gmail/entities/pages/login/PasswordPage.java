package by.helmes.gmail.entities.pages.login;

import by.helmes.gmail.entities.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class PasswordPage extends AbstractPage {
    private final String passwordField = "//*[@name=\"password\"]";
    private final String nextBtn = "//*[@id=\"passwordNext\"]";

    public PasswordPage (WebDriver driver){
        super(driver);
    }

    public PasswordPage getPasswordPage() {
        PasswordPage passwordPage = new PasswordPage(driver);
        waitForElementPresence(getElementBy(passwordField));
        return passwordPage;
    }

    public PasswordPage fillPasswordField(String password) {
        waitForElementClickable(getElementBy(passwordField));
        getElement(passwordField).click();
        getElement(passwordField).sendKeys(password);
        return getPasswordPage();
    }

    public PasswordPage clickNextBtn() {
        getElement(nextBtn).click();
        return getPasswordPage();
    }

}

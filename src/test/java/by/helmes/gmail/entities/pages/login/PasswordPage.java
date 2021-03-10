package by.helmes.gmail.entities.pages.login;

import by.helmes.gmail.entities.pages.AbstractPage;

public class PasswordPage extends AbstractPage {
    //private static String passwordField = "//input[@type=\"password\"]";
    private static String passwordField = "//*[@name=\"password\"]";
    private static String nextBtn = "//*[@id=\"passwordNext\"]";

    public static PasswordPage getPasswordPage() {
        PasswordPage passwordPage = new PasswordPage();
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

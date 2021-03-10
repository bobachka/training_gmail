package by.helmes.gmail.entities.pages.login;

import by.helmes.gmail.entities.pages.AbstractPage;

public class LoginPage extends AbstractPage {
    private static String loginField = "//*[@id=\"identifierId\"]";
    private static String nextBtn = "//*[@id=\"identifierNext\"]";

    public LoginPage navigateToLoginPage() {
        openUrl(baseUrl);
        return getLoginPage();
    }

    public static LoginPage getLoginPage() {
        LoginPage loginPage = new LoginPage();
        waitForElementPresence(getElementBy(loginField));
        return loginPage;
    }

    public LoginPage fillLoginField(String login) {
        waitForElementPresence(getElementBy(loginField));
        getElement(loginField).click();
        getElement(loginField).sendKeys(login);
        return getLoginPage();
    }

    public LoginPage clickNextBtn() {
        getElement(nextBtn).click();
        return getLoginPage();
    }


}

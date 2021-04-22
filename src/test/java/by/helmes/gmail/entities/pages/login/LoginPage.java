package by.helmes.gmail.entities.pages.login;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.entities.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    private final String loginField = "//*[@id='identifierId']";
    private final String nextBtn = "//*[@id='identifierNext']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage navigateToLoginPage() {
        openUrl(FrameworkCore.baseUrl);
        return getLoginPage();
    }

    public LoginPage getLoginPage() {
        waitForElementPresence(getElementBy(loginField));
        return this;
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

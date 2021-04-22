package by.helmes.gmail.entities.pages.navigation;

import by.helmes.gmail.entities.pages.AbstractPage;
import by.helmes.gmail.entities.pages.login.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class NewEmailPage extends AbstractPage {
    private final String receiverField = "//*[@name='to']";
    private final String subjectField = "//*[@name='subjectbox']";
    private final String bodyField = "//*[@class='Am Al editable LW-avf tS-tW']";
    private final String sendBtn = "//*[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']";
    private final String minimiseBtn = "//img[@class='Hl']";
    private final String restoreBtn = "//img[@class='Hk']";
    private final String expandBtn = "//img[@class='Hq aUG']";
    private final String shrinkBtn = "//img[@class='Hq aUH']";
    private final String closeBtn = "//img[@class='Ha']";
    private final String inboxCounter = "//*[@class='bsU']";

    public NewEmailPage(WebDriver driver) {
        super(driver);
    }

    public NewEmailPage getNewEmailPage() {
        NewEmailPage newEmailPage = new NewEmailPage(driver);
        waitForElementPresence(getElementBy(receiverField));
        return newEmailPage;
    }

    public NewEmailPage fillReceiver(String receiver) {
        changeWindow();
        waitForElementClickable(getElementBy(receiverField));
        getElement(receiverField).click();
        getElement(receiverField).sendKeys(receiver);
        getElement(receiverField).sendKeys(Keys.ENTER);
        return this;
    }

    public NewEmailPage fillSubject() {
        waitForElementClickable(getElementBy(subjectField));
        getElement(subjectField).click();
        getElement(subjectField).sendKeys(randomiseText());
        return this;
    }

    public NewEmailPage fillBody() {
        waitForElementClickable(getElementBy(bodyField));
        getElement(bodyField).click();
        getElement(bodyField).sendKeys(randomiseText());
        return this;
    }

    public String getBody() {
        return getElement(bodyField).getText();
    }

    public String getInboxTotal() {
        waitForElementVisible(getElementBy(inboxCounter));
        return getElement(inboxCounter).getText();
    }

    public HomePage sendNewEmail() {
        waitForElementVisible(getElementBy(sendBtn));
        String inboxTotalBeforeSending = getInboxTotal();
        getElement(sendBtn).click();
        waitForTextChange(getElementBy(inboxCounter), String.valueOf(Integer.parseInt(inboxTotalBeforeSending) + 1));
        return new HomePage(driver);
    }

    public NewEmailPage minimiseNewEmail() {
        waitForElementVisible(getElementBy(minimiseBtn));
        getElement(minimiseBtn).click();
        return this;
    }

    public NewEmailPage restoreNewEmail() {
        waitForElementVisible(getElementBy(restoreBtn));
        getElement(restoreBtn).click();
        return this;
    }

    public NewEmailPage maximiseNewEmail() {
        waitForElementVisible(getElementBy(expandBtn));
        getElement(expandBtn).click();
        return this;
    }

    public NewEmailPage optimiseNewEmail() {
        waitForElementVisible(getElementBy(shrinkBtn));
        getElement(shrinkBtn).click();
        return this;
    }

    public String addTestText() {
        String testText = randomiseText();
        waitForElementClickable(getElementBy(bodyField));
        getElement(bodyField).click();
        getElement(bodyField).sendKeys(testText);
        return testText;
    }

    public NewEmailPage selectBody() {
        waitForElementClickable(getElementBy(bodyField));
        getElement(bodyField).click();
        getElement(bodyField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        return this;
    }

    public HomePage closeNewEmail() {
        waitForElementVisible(getElementBy(closeBtn));
        getElement(closeBtn).click();
        return new HomePage(driver);
    }

    public String randomiseText() {
        Date date = new Date();
        return "Selenium" + date.getTime();
    }

}

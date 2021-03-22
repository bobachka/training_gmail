package by.helmes.gmail.entities.pages.navigation;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.entities.pages.AbstractPage;
import by.helmes.gmail.entities.pages.login.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class NewEmailPage extends AbstractPage {
    private final String receiverField = "//*[@name=\"to\"]";
    private final String subjectField = "//*[@name=\"subjectbox\"]";
    private final String bodyField = "//*[@class=\"Am Al editable LW-avf tS-tW\"]";
    private final String sendBtn = "//*[@class=\"T-I J-J5-Ji aoO v7 T-I-atl L3\"]";
    private final String inboxCounter = "//*[@class=\"bsU\"]";

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
        return getNewEmailPage();
    }

    public NewEmailPage fillSubject() {
        waitForElementClickable(getElementBy(subjectField));
        getElement(subjectField).click();
        getElement(subjectField).sendKeys(randomiseSampleText(FrameworkCore.sampleText));
        return getNewEmailPage();
    }

    public NewEmailPage fillBody() {
        waitForElementClickable(getElementBy(bodyField));
        getElement(bodyField).click();
        getElement(bodyField).sendKeys(randomiseSampleText(FrameworkCore.sampleText));
        return getNewEmailPage();
    }

    public String getInboxTotal() {
        waitForElementVisible(getElementBy(inboxCounter));
        return getElement(inboxCounter).getText();
    }

    public HomePage sendEmail() {
        waitForElementVisible(getElementBy(sendBtn));
        String inboxTotalBeforeSending = getInboxTotal();
        getElement(sendBtn).click();
        waitForTextChange(getElementBy(inboxCounter), String.valueOf(Integer.parseInt(inboxTotalBeforeSending) + 1));
        return new HomePage(driver);
    }

    private String randomiseSampleText(String sampleText) {
        String[] splitText = sampleText.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < splitText.length; i++) {
            stringBuilder.append(splitText[random.nextInt(splitText.length - 1)]);
        }
        return stringBuilder.toString();
    }
}

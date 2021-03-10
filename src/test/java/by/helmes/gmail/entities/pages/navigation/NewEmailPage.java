package by.helmes.gmail.entities.pages.navigation;

import by.helmes.gmail.entities.pages.AbstractPage;
import by.helmes.gmail.entities.pages.login.HomePage;
import org.openqa.selenium.Keys;

import java.util.Random;

public class NewEmailPage extends AbstractPage {
    private static String receiverField = "//*[@name=\"to\"]";
    //    private static String subjectField = "//*[@name=\"aoT\"]";
    private static String subjectField = "//*[@name=\"subjectbox\"]";
    private static String bodyField = "//*[@class=\"Am Al editable LW-avf tS-tW\"]";
    private static String sendBtn = "//*[@class=\"T-I J-J5-Ji aoO v7 T-I-atl L3\"]";
    private HomePage homePage = new HomePage();
    private NewEmailPage newEmailPage = new NewEmailPage();

    public NewEmailPage getNewEmailPage() {
        NewEmailPage newEmailPage = new NewEmailPage();
        waitForElementPresence(getElementBy(receiverField));
        return newEmailPage;
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

    public NewEmailPage fillReceiver(String receiver) {
        changeWindow();
        waitForElementClickable(getElementBy(receiverField));
        getElement(receiverField).click();
        getElement(receiverField).sendKeys(receiver);
        getElement(receiverField).sendKeys(Keys.ENTER);
        return newEmailPage.getNewEmailPage();
    }

    public NewEmailPage fillSubject() {
        waitForElementClickable(getElementBy(subjectField));
        getElement(subjectField).click();
        getElement(subjectField).sendKeys(randomiseSampleText(sampleText));
        return newEmailPage.getNewEmailPage();
    }

    public NewEmailPage fillBody() {
        waitForElementClickable(getElementBy(bodyField));
        getElement(bodyField).click();
        getElement(bodyField).sendKeys(randomiseSampleText(sampleText));
        return newEmailPage.getNewEmailPage();
    }

    public HomePage sendEmail() {
        waitForElementVisible(getElementBy(sendBtn));
        getElement(sendBtn).click();
//        waitForElementInvisible(getElementBy(sendBtn));
        wait(5000);
        return homePage.getHomePage();
    }

}

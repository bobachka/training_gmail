package by.helmes.gmail.entities.pages.navigation;

import by.helmes.gmail.entities.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class SentEmailPage extends AbstractPage {
    private final String sentItem = "//div[@class='av']";

    public SentEmailPage(WebDriver driver) {
        super(driver);
    }

    public int countSendEmails() {
        return getElements(sentItem).size();
    }

}

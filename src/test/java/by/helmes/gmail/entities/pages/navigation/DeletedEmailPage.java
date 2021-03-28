package by.helmes.gmail.entities.pages.navigation;

import by.helmes.gmail.entities.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DeletedEmailPage extends AbstractPage {
    private final String deletedItem = "//*[@class='aqN']";
    private final String deletedLink = "//a[@href='https://mail.google.com/mail/u/0/#trash']";
    private final String allLink = "//a[@href='https://mail.google.com/mail/u/0/#all']";

    public DeletedEmailPage(WebDriver driver) {
        super(driver);
    }


    public int countDeletedEmails() {
        return getElements(deletedItem).size();
    }

    public void BackToHome(){
        navigateBackRefresh();
    }
}

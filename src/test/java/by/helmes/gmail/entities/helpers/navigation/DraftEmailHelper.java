package by.helmes.gmail.entities.helpers.navigation;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.navigation.DraftEmailPage;
import org.openqa.selenium.WebDriver;

public class DraftEmailHelper extends AbstractHelper {
    private DraftEmailPage draftEmailPage;

    public DraftEmailHelper(WebDriver driver) {
        super(driver);
        draftEmailPage = new DraftEmailPage(driver);
    }

    public String getBodyOfFirstDraft() {
        return draftEmailPage.getBodyOfFirstDraft();
    }
}

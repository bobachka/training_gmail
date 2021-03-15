package by.helmes.gmail.entities.helpers.login;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.login.HomePage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;
import org.openqa.selenium.WebDriver;

public class HomeHelper extends AbstractHelper {
    private HomePage homePage;

    public HomeHelper(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    public boolean checkHomeLogo() {
        return homePage.getHomePage().isLogoPresent();
    }

    public int getInboxResultsTotal() {
        return Integer.parseInt(homePage.getInboxTotal());
    }

    public NewEmailPage composeEmail() {
        return homePage.composeEmail();
    }

}

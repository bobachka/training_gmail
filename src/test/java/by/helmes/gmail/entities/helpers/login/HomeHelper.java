package by.helmes.gmail.entities.helpers.login;

import by.helmes.gmail.entities.helpers.AbstractHelper;
import by.helmes.gmail.entities.pages.login.HomePage;
import by.helmes.gmail.entities.pages.navigation.NewEmailPage;

public class HomeHelper extends AbstractHelper {
    private HomePage homePage = new HomePage();

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

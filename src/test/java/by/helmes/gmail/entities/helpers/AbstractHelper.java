package by.helmes.gmail.entities.helpers;

import by.helmes.gmail.entities.pages.AbstractPage;

public class AbstractHelper {
    AbstractPage abstractPage = new AbstractPage();

    public void quit() {
        abstractPage.getDriver().manage().deleteAllCookies();
        abstractPage.getDriver().quit();
    }

}
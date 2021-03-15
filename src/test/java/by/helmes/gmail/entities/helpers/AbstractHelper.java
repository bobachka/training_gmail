package by.helmes.gmail.entities.helpers;

import org.openqa.selenium.WebDriver;

public class AbstractHelper {
    protected WebDriver driver;

    public AbstractHelper (WebDriver driver){
        this.driver = driver;
    }

    public void quit() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
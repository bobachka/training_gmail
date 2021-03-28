package by.helmes.gmail.tests;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.core.driver.DriverFactory;
import by.helmes.gmail.core.driver.DriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;
    private DriverManager driverManager;

    protected void setupTest() {
        initializing(FrameworkCore.browser.toUpperCase());
    }

    protected void setupTest(String browser) {
        initializing(browser.toUpperCase());
    }

    private void initializing(String browser){
        driverManager = DriverFactory.valueOf(browser).getDriverManager();
        driver = driverManager.getDriver();
    }

    protected void readConfigFile(String fileName) {
        FrameworkCore.init(fileName);
    }

    protected void cleanupTest() {
        driverManager.quitDriver();
    }

    //TODO
    private void method(){

    }
}

package by.helmes.gmail.tests;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.core.driver.DriverFactory;
import by.helmes.gmail.core.driver.DriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    private DriverManager driverManager;
    protected String fileName;
    protected WebDriver driver;

    protected void setupTest() {
        driverManager = DriverFactory.valueOf(FrameworkCore.browser.toUpperCase()).getDriverManager();
        driver = driverManager.getDriver();
    }

    protected void readConfigFile(String fileName) {
        this.fileName = fileName;
        FrameworkCore.init(fileName);
    }

    protected void cleanupTest() {
        driverManager.quitDriver();
    }
}

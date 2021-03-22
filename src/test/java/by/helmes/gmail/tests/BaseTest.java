package by.helmes.gmail.tests;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.core.driver.DriverFactory;
import by.helmes.gmail.core.driver.DriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    //TODO try to use private approach. If some methods can be marked as private, mark it as private
    protected String fileName;
    protected WebDriver driver;
    private DriverManager driverManager;

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

package by.helmes.gmail.tests;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.core.driver.DriverFactory;
import by.helmes.gmail.core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public abstract class BaseTest {

    protected WebDriver driver;
    private DriverManager driverManager;

    protected void setupTest() {
        initialise(FrameworkCore.browser.toUpperCase());
    }

    protected void setupTest(ITestContext context) {
        initialise(FrameworkCore.browser.toUpperCase());
        context.setAttribute("WebDriver", driver);
    }

    protected void setupTest(String browser) {
        initialise(browser.toUpperCase());
    }

    private void initialise(String browser) {
        driverManager = DriverFactory.valueOf(browser).getDriverManager();
        driver = driverManager.getDriver();
    }

    protected void readConfigFile(String fileName) {
        FrameworkCore.init(fileName);
    }

    protected void cleanupTest() {
        driverManager.quitDriver();
    }
}

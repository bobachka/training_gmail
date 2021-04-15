package by.helmes.gmail.tests;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.entities.helpers.login.HomeHelper;
import by.helmes.gmail.entities.helpers.login.LoginHelper;
import by.helmes.gmail.entities.helpers.login.PasswordHelper;
import by.helmes.gmail.entities.helpers.navigation.NewEmailHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {

    protected WebDriver driver;
    protected LoginHelper loginHelper;
    protected PasswordHelper passwordHelper;
    protected HomeHelper homeHelper;
    protected NewEmailHelper newEmailHelper;

    protected void setupTest() {
        initialise(FrameworkCore.browser);
    }

    protected void setupTest(ITestContext context) {
        initialise(FrameworkCore.browser);
        context.setAttribute("WebDriver", driver);
    }

    protected void setupTest(String browser) {
        initialise(browser);
    }

    private void initialise(String browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        loginHelper = new LoginHelper(driver);
        passwordHelper = new PasswordHelper(driver);
        homeHelper = new HomeHelper(driver);
        newEmailHelper = new NewEmailHelper(driver);


            }

    protected void readConfigFile(String fileName) {
        FrameworkCore.init(fileName);
    }

    protected void cleanupTest() {
        driver.quit();
    }

}

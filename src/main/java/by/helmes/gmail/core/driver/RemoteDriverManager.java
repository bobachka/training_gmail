package by.helmes.gmail.core.driver;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.core.utils.LoggingUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverManager extends DriverManager {
    @Override
    protected WebDriver createDriver() {

        LoggingUtils.logInfo("Initializing Remote Driver");
        WebDriverManager.getInstance(DriverManagerType.valueOf(FrameworkCore.gridBrowser)).setup();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", FrameworkCore.gridBrowser.toLowerCase());

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
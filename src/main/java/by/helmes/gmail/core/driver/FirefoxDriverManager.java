package by.helmes.gmail.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class FirefoxDriverManager extends DriverManager {
    @Override
    protected WebDriver createDriver() {
        System.out.println("Initializing FF Driver"); // Change to Loggers
        WebDriverManager.getInstance(FIREFOX).setup();

        return new FirefoxDriver();
    }
}
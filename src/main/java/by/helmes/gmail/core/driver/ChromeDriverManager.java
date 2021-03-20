package by.helmes.gmail.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class ChromeDriverManager extends DriverManager {
    @Override
    protected WebDriver createDriver() {
        System.out.println("Initializing Chrome Driver"); // Change to Loggers
        WebDriverManager.getInstance(CHROME).setup();

        return new ChromeDriver();
    }

}

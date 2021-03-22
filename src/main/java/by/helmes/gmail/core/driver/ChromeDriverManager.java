package by.helmes.gmail.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class ChromeDriverManager extends DriverManager {
    @Override
    protected WebDriver createDriver() {
        //TODO Let's me recommend you to remove it from code. Try to use log4j or other logger libraries
        System.out.println("Initializing Chrome Driver");
        WebDriverManager.getInstance(CHROME).setup();

        return new ChromeDriver();
    }

}

package by.helmes.gmail.core;

import by.helmes.gmail.core.utils.BrowserConstants;
import by.helmes.gmail.core.utils.IOUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkCore {

    private final static String fileName = System.getProperty("fileName");
    public static String browser = IOUtils.loadGenericProperty("browser", fileName);
    public static String baseUrl = IOUtils.loadGenericProperty("baseUrl", fileName);
    public static String sampleText = IOUtils.loadGenericProperty("sampleText", fileName);

    public static WebDriver getInstance() {
        WebDriver driver;
        if (browser.equals(BrowserConstants.CHROME)) {
            driver = new ChromeDriver();
        } else {
            if (browser.equals(BrowserConstants.FIREFOX)) {
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Such browser is absent in .properties");
            }
        }
        return driver;
    }


}

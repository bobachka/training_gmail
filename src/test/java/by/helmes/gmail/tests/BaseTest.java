package by.helmes.gmail.tests;

import by.helmes.gmail.core.FrameworkCore;
import by.helmes.gmail.core.utils.BrowserConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.InvocationTargetException;

public abstract class BaseTest {

    private final Class<? extends WebDriver> CHROME = ChromeDriver.class;
    private final Class<? extends WebDriver> FIREFOX = FirefoxDriver.class;

    protected String fileName;
    protected WebDriver driver;

    protected void setup(String fileName) {
        this.fileName = fileName;
        FrameworkCore.init(fileName);

//        Class<? extends WebDriver> driverClass;

//        if (FrameworkCore.browser.equals(BrowserConstants.CHROME)) {
//            driverClass = CHROME;
//        } else if (FrameworkCore.browser.equals(BrowserConstants.FIREFOX)) {
//            driverClass = FIREFOX;
//        } else throw new IllegalStateException("invalid browser");


//        switch (FrameworkCore.browser) {
//            case BrowserConstants.CHROME:
//                driverClass = CHROME;
//                break;
//            case BrowserConstants.FIREFOX:
//                driverClass = FIREFOX;
//                break;
//            default:
//                throw new IllegalStateException("invalid browser");
//        }

        Class<? extends WebDriver> driverClass = switch (FrameworkCore.browser) {
            case BrowserConstants.CHROME -> CHROME;
            case BrowserConstants.FIREFOX -> FIREFOX;
            default -> throw new IllegalStateException("invalid browser");
        };


        WebDriverManager.getInstance(driverClass).setup();
        try {
            driver = driverClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new IllegalStateException("invalid browser");
        }
    }
}

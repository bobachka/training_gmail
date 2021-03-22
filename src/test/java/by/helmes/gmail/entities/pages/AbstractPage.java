package by.helmes.gmail.entities.pages;

import by.helmes.gmail.core.utils.PauseLength;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage (WebDriver driver){
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void waitForElementVisible(final By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLength.AVG.value());
            waiter.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void waitForElementPresence(final By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLength.AVG.value());
            waiter.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void waitForElementClickable(final By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLength.MAX.value());
            waiter.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static By getElementBy(String xpath) {
        return By.xpath(xpath);
    }

    public WebElement getElement(String xpath) {
        try {
            return driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public WebElement getElement(By selector) {
        try {
            return driver.findElement(selector);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<WebElement> getElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void changeWindow() {
        Set<String> handles = driver.getWindowHandles();
        for (String s : handles) {
            driver.switchTo().window(s);
        }
    }

    public void hoverOnItem(String item) {
        Actions action = new Actions(driver);
        WebElement element = getElement(item);
        action.moveToElement(element).perform();
    }
}
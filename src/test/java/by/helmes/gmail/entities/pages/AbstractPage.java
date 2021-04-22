package by.helmes.gmail.entities.pages;

import by.helmes.gmail.core.utils.LoggingUtils;
import by.helmes.gmail.core.utils.PauseLength;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void openUrl(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    protected void waitForElementVisible(final By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLength.AVG.value());
            waiter.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable e) {
            LoggingUtils.logErr(e.getLocalizedMessage());
        }
    }

    protected void waitForElementPresence(final By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLength.AVG.value());
            waiter.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable e) {
            LoggingUtils.logErr(e.getLocalizedMessage());
        }
    }

    protected void waitForElementClickable(final By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLength.MAX.value());
            waiter.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable e) {
            LoggingUtils.logErr(e.getLocalizedMessage());
        }
    }

    protected void waitForTextChange(final By by, String expectedText) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLength.MAX.value());
            waiter.until(ExpectedConditions.textToBePresentInElementLocated(by, expectedText));
        } catch (Throwable e) {
            LoggingUtils.logErr(e.getLocalizedMessage());
        }
    }

    protected static By getElementBy(String xpath) {
        return By.xpath(xpath);
    }

    protected WebElement getElement(String xpath) {
        try {
            return driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    protected WebElement getElement(By selector) {
        try {
            return driver.findElement(selector);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    protected List<WebElement> getElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    protected void changeWindow() {
        Set<String> handles = driver.getWindowHandles();
        for (String s : handles) {
            driver.switchTo().window(s);
        }
    }

    protected void scrollDown() {
        scroll(0, 300);
    }

    protected void scrollUp() {
        scroll(0, -300);
    }

    protected void hoverOnItem(String item) {
        Actions action = new Actions(driver);
        WebElement element = getElement(item);
        action.moveToElement(element).perform();
    }

    protected void navigateBackRefresh(){
        driver.navigate().back();
        driver.navigate().refresh();
    }


    private void scroll(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "window.scrollBy(" + x + "," + y + ")");
    }
}
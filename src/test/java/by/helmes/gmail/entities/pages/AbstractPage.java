package by.helmes.gmail.entities.pages;

import by.helmes.gmail.core.utils.PauseLength;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage (WebDriver driver){
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void waitForElementInvisible(final By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLength.AVG.value());
            waiter.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
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

    public boolean isElementVisible(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(PauseLength.AVG.value(), TimeUnit.SECONDS);
            List<WebElement> list = driver.findElements(by);

            if (list.size() == 0) {
                return false;
            } else {
                try {
                    return list.get(0).isDisplayed();
                } catch (StaleElementReferenceException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        } finally {
            driver.manage().timeouts().implicitlyWait(PauseLength.MAX.value(), TimeUnit.SECONDS);
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

    public void pageRefresh() {
        driver.navigate().refresh();
    }

    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
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
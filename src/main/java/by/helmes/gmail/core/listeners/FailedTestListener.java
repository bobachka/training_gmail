package by.helmes.gmail.core.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FailedTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("WebDriver");

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        //Call getScreenshotAs method to create image file
        File file = scrShot.getScreenshotAs(OutputType.FILE);

        String currentTime = new SimpleDateFormat("dd_MM_yy_hh_mm_ss").format(new Date());
        String testName = result.getName();
        //Create image in the destination
        File destFile = new File("target\\screenshots\\" + currentTime + "_" + testName + ".png");
        //Copy file at destination
        try {
            FileUtils.copyFile(file, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package org.example;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        Date currentDate = new Date();
        System.out.println(currentDate);
        String screenshotFile = currentDate.toString().replace(" ", "-").replace(":", "-");

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(src, new File(".//screenshot/screen.png"));

//Copy the screenshot on the desire location with different name using current date and time
        FileUtils.copyFile(src, new File(".//screenshot//" + screenshotFile + ".png"));
    }
}

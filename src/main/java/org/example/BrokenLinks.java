package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        broken url
//        step1 - get all urls tied up to links using selenium
//        step2 - java methods will call url and gets you status code
//        if status code>400 then url is not working
//
//        String url = driver.findElement(By.cssSelector("a[href*= 'soapui']")).getAttribute("href");
//        creating HTTP connection
        List<WebElement> lists = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
        SoftAssert a = new SoftAssert();
        for (WebElement link : lists) {
            String url = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            a.assertTrue(responseCode < 400, "The link with text" + link.getText() + "is broken with code" + responseCode);

//            if (responseCode > 400) {
//                System.out.println("The link with text" + link.getText() + "is broken with code" + responseCode);
//                Assert.assertTrue(false);
//            }
        }

        a.assertAll();

//        String url = driver.findElement(By.cssSelector("a[href*= 'brokenlink']")).getAttribute("href");
//
//
//        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//        connection.setRequestMethod("HEAD");
//        connection.connect();
//        int responseCode = connection.getResponseCode();
//        System.out.println(responseCode);
    }
}

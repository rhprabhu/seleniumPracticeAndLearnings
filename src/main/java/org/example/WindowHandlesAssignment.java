package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandlesAssignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        driver.navigate().to("http://the-internet.herokuapp.com/windows");
        driver.get("http://the-internet.herokuapp.com/windows");

        driver.manage().window().maximize();
//        WebDriverWait Explicitwait=new WebDriverWait(driver, Duration.ofMillis(1000));
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windowHandle = driver.getWindowHandles();
        Iterator<String> it = windowHandle.iterator();
        String parentid = it.next();
        String childid = it.next();
        driver.switchTo().window(childid);

        System.out.println(driver.findElement(By.tagName("h3")).getText());
//  Explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("h3")));
        driver.switchTo().window(parentid);
        System.out.println(driver.findElement(By.tagName("h3")).getText());


    }
}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalenderProblem {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companion/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
        List<WebElement> date = driver.findElements(By.className("flatpickr-day "));

        //to work on calender grab the common css for all and put in list to iterate
        int count = driver.findElements(By.className("flatpickr-day ")).size();

        for (int i = 0; i < count; i++) {
            String text = driver.findElements(By.className("flatpickr-day ")).get(i).getText();
            if (text.equalsIgnoreCase("23")) {
                driver.findElements(By.className("flatpickr-day ")).get(i).click();
                break;
            }
        }
    }
}

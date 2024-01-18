package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignmentoptiontextgrab {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("checkBoxOption2")).click();
        String optionText = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
        System.out.println(driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText());

        WebElement selectOption = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(selectOption);
        select.selectByVisibleText(optionText);

        driver.findElement(By.id("name")).sendKeys(optionText);
        driver.findElement(By.id("alertbtn")).click();
        String text = driver.switchTo().alert().getText();
        if (text.contains(optionText)) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }
}

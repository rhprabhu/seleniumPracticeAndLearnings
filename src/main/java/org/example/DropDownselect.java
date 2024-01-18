package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownselect {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        WebElement dropdown= driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
        Select select = new Select(dropdown);
        select.selectByValue("AED");
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(4000);
        select.selectByVisibleText("USD");
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(4000);
        select.selectByIndex(2);
        Thread.sleep(4000);
        System.out.println(select.getFirstSelectedOption().getText());

    }
}

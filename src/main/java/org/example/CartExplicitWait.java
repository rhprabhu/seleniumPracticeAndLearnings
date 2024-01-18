package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CartExplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait Explicitwait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //it waits for max 5 seconds
        String[] vegetables = {"Cucumber", "Brocolli", "Brinjal", "Carrot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        addItems(driver, vegetables);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        Explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".promoCode")));
        driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();
        Explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("promoInfo")));
        System.out.println(driver.findElement(By.className("promoInfo")).getText());
    }

    public static void addItems(WebDriver driver, String[] vegetables) {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));

        for (int i = 0; i < products.size(); i++) {
            String[] productName = products.get(i).getText().split("-");
            String formattedName = productName[0].trim();

            List VegetableList = Arrays.asList(vegetables);

            if (VegetableList.contains(formattedName)) {

                j++;
                //click on add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == vegetables.length) {
                    break;
                }
            }
        }
    }
}

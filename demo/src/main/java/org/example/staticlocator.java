package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class staticlocator
{
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        System.out.println("Welcome to testing world!");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Firebolt smart watch");
        driver.findElement(By.id("nav-search-submit-button")).submit();
    }
}
package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class project1
{
    public static void main(String args[]) throws IOException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://lms.kluniversity.in/login/index.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameField.sendKeys("2200030328");
        highlight(driver, driver.findElement(By.name("username")));
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Varun!599");
        highlight(driver, driver.findElement(By.id("password")));
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();
        WebElement mycourses = driver.findElement(By.cssSelector("a[title='My courses']"));
        mycourses.click();
        WebElement search = driver.findElement(By.xpath("//input[@id='searchinput']"));
        search.click();
        search.sendKeys("Software Testing");



//        TakesScreenshot TS = (TakesScreenshot)driver;
//        File file = TS.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(file,new File("./Screenoutput/Image.png"));

    }
    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

}

package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class checkboxtest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void testCheckboxInteraction() {
        // Locate the checkbox element
        WebElement checkBox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        // Verify the checkbox is not selected initially
        boolean isSelected = checkBox.isSelected();
        Assert.assertFalse("Checkbox should not be selected initially", isSelected);

        // Click the checkbox to select it
        checkBox.click();

        // Verify the checkbox is now selected
        isSelected = checkBox.isSelected();
        assertTrue("Checkbox should be selected after clicking", isSelected);

        // Verify the checkbox is displayed and enabled
        assertTrue("Checkbox should be displayed", checkBox.isDisplayed());
        assertTrue("Checkbox should be enabled", checkBox.isEnabled());
    }

    @After
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }
}

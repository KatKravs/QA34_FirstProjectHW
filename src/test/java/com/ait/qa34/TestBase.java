package com.ait.qa34;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        // Максимизируем окно браузера
        driver.manage().window().maximize();
        // Ожидаем загрузки всех элементов на сайте перед началом теста
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        // Завершаем работу драйвера после выполнения теста
        driver.quit();
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }
    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    public void click(By locator) {
        driver.findElement(locator).click();
    }

}

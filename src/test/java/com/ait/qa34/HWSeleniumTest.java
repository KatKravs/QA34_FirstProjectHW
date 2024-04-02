package com.ait.qa34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HWSeleniumTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        // Максимизируем окно браузера
        driver.manage().window().maximize();
        // Ожидаем загрузки всех элементов на сайте перед началом теста
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementsByTagName() {
        // Находим первый элемент по имени тега "title"
        WebElement element1 = driver.findElement(By.tagName("title"));
        String titleText = element1.getAttribute("innerHTML");
        System.out.println("Текст первого элемента (тег 'title'): " + titleText);

        // Находим все элементы по имени тега "title"
        List<WebElement> elements1 = driver.findElements(By.tagName("title"));
        // Выводим количество найденных элементов с тегом 'title'
        System.out.println("Общее количество элементов с тегом 'title': " + elements1.size());

        // Находим первый элемент по имени тега "input"
        WebElement element2 = driver.findElement(By.tagName("input"));
        System.out.println("Тип второго элемента (тег 'input'): " + element2.getAttribute("type"));

        // Находим все элементы по имени тега "input"
        List<WebElement> elementsInput = driver.findElements(By.tagName("input"));
        // Выводим количество найденных элементов с тегом 'input'
        System.out.println("Общее количество элементов с тегом 'input': " + elementsInput.size());

        // Находим первый элемент по имени тега "h2"
        WebElement element3 = driver.findElement(By.tagName("h2"));
        System.out.println("Текст третьего элемента (тег 'h2'): " + element3.getText());

        // Находим все элементы по имени тега "h2"
        List<WebElement> elementsH2 = driver.findElements(By.tagName("h2"));
        // Выводим количество найденных элементов с тегом 'h2'
        System.out.println("Общее количество элементов с тегом 'h2': " + elementsH2.size());
    }

    @Test
    public void findAllTags() {
        // Находим все элементы на странице
        List<WebElement> allElements = driver.findElements(By.xpath("//*"));

        // Выводим общее количество элементов на странице
        System.out.println("Общее количество тегов на странице: " + allElements.size());
    }

    @Test
    public void findTenDifferentElements() {
        // id -> #id
        driver.findElement(By.cssSelector("#flyout-cart"));
        driver.findElement(By.cssSelector("#newsletter-subscribe-block"));
        // class name -> .className
        driver.findElement(By.cssSelector(".header-links-wrapper"));
        driver.findElement(By.cssSelector(".header-logo"));
        // [name='user']
        driver.findElement(By.cssSelector("[name='q']"));
        driver.findElement(By.cssSelector("[data-valmsg-for='NewsletterEmail']"));
        driver.findElement(By.cssSelector("[href='/']"));
        // contains -> *
        driver.findElement(By.cssSelector("[href*='viewed']"));
        //start -> ^
        driver.findElement(By.cssSelector("[href^='/about']"));
        //end on -> $
        driver.findElement(By.cssSelector("[href$='/apparel']"));

    }

    @AfterMethod
    public void tearDown() {
        // Завершаем работу драйвера после выполнения теста
        driver.quit();
    }
}

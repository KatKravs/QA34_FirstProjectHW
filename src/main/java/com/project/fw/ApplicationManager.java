package com.project.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager{
    static WebDriver driver;
    String browser;

    UserHelper user;
    ShoppingCartHelper cartHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public  void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        // Максимизируем окно браузера
        driver.manage().window().maximize();
        // Ожидаем загрузки всех элементов на сайте перед началом теста
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        user = new UserHelper(driver);
        cartHelper = new ShoppingCartHelper(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public ShoppingCartHelper getCartHelper() {
        return cartHelper;
    }

    public  void stop() {
        // Завершаем работу драйвера после выполнения теста
        driver.quit();
    }

}

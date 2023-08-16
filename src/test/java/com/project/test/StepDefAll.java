package com.project.test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

public class StepDefAll {
    private static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        List<String>optionsList = Arrays.asList("--remote-allow-origins=*", "--headless", "--disable-dev-shm-usage", "--no-sandbox", "--disable-gpu");
        options.addArguments(optionsList);
        options.setHeadless(false);
        driver = new ChromeDriver(options);
    }

    @After
    public void teardown() {
        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}


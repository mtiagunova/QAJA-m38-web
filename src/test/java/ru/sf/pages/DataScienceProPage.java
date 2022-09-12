package ru.sf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DataScienceProPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public DataScienceProPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getUrl() {
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        return driver.getCurrentUrl();
    }
}

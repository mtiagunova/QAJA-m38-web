package ru.sf.pages;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDevPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String JAVA_SECTION = "//*[@id='rec421439429']//a[.='Java']";

    public WebDevPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getUrl() {
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        return driver.getCurrentUrl();
    }

    // Открыть раздел 'Java'
    public void openJavaSection() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(JAVA_SECTION))).click();
    }
}

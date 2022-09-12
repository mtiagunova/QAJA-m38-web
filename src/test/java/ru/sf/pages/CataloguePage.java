package ru.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class CataloguePage {

    private  WebDriver driver;
    private WebDriverWait wait;

    private static final String DATA_SCIENCE_SECTION = "//*[@id='rec372511587']//div[contains(text(), 'Data Science')]/..";
    private static final String DATA_SCIENCE_PROFESSION = "//div[contains(@class, 'tn-elem__4686070891652779744723')]/a";

    public CataloguePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getUrl() {
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        return driver.getCurrentUrl();
    }

    // Открыть раздел Data Science
    public void openDataScienceSection() {
        while(!driver.getCurrentUrl().equals("https://skillfactory.ru/catalogue#!/tab/372511587-2")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DATA_SCIENCE_SECTION))).click();
            wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        }
    }

    // Открыть курс 'Профессия Data Science'
    public void openDataScienceProfession() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DATA_SCIENCE_PROFESSION))).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles()); // указатели на открытые вкладки
        driver.switchTo().window(tabs.get(1));
    }
}

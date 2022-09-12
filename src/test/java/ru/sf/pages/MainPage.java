package ru.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final String FREE_EVENTS_BUTTON = "//a[contains(text(), 'Бесплатные мероприятия')]";
    private static final String DATA_SCIENCE_BUTTON = "//*[@id='rec456746055']//a[.='Data Science']";
    private static final String COURSES_ACTION_MENU_NAV_BAR = "//a[.='Курсы']";
    private static final String FREE_NAV_BAR = "//a[.='Бесплатно']";
    private static final String CATALOGUE_BUTTON = "//*[@id='rec468113060']//a[@href='https://skillfactory.ru/catalogue']";
    private static final String FOOTER_BUTTON = "//a[.='{TEXT}']";
    private static final String COURSES_ACTION_MENU_COURSE = "//span[contains(text(), '{COURSE_NAME}')]/..";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    // Перейти на главную страницу
    public void openMainPage(String url) {
        driver.get(url);
    }

    public String getUrl() {
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        return driver.getCurrentUrl();
    }

    // Нажать на кнопку 'Бесплатные мероприятия' в основной части страницы
    public void clickFreeEventsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FREE_EVENTS_BUTTON))).click();
    }

    // Нажать на кнопку 'Data Science' в основной части страницы
    public void clickDataScienceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DATA_SCIENCE_BUTTON))).click();
    }

    // Нажать на кнопку 'Бесплатно' в шапке сайта
    public void clickFreeNavBarButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FREE_NAV_BAR))).click();
    }

    // Навести на 'Курсы', чтобы открылся список действий
    public void mouseHoverOnCourses() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(COURSES_ACTION_MENU_NAV_BAR))).perform();
    }

    //  Выбрать в выпадающем списке 'Курсы' курс с названием courseName
    public void clickCourseFromCoursesActionMenu(String courseName) {
        System.out.println(wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(COURSES_ACTION_MENU_COURSE.replace("{COURSE_NAME}", courseName))
        )).getText());

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(COURSES_ACTION_MENU_COURSE.replace("{COURSE_NAME}", courseName))
        )).click();
    }

    // Кнопка 'Посмотреть все направления'
    public void clickCatalogueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CATALOGUE_BUTTON))).click();
    }

    // Нажать на кнопку в футере с названием buttonName
    public void clickFooterButton(String buttonName) {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(FOOTER_BUTTON.replace("{TEXT}", buttonName))
        )).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles()); // указатели на открытые вкладки
        driver.switchTo().window(tabs.get(1));
    }
}

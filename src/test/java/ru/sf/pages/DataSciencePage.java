package ru.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DataSciencePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final String TITLE = "//h1[contains(text(), 'Курсы по Data Science')]";
    private static final String BURGER_MENU = "//div[contains(@class, 't830__side')]/div";
    private static final String BURGER_MENU_OPTION = "//div[contains(@class, 't830m__submenu-item')]/a[contains(text(), '{COURSE_NAME}')]";
    private static final String SKILLFACTORY_HOME = "//*[@id='rec469350955']//a[@href='/']";
    private static final String COURSES_DIFFERENCE_INFO_BUTTON = "//a[@href='#accord']";
    private static final String COURSES_DIFFERENCE_INFO_TEXT = "//div[@id='rec371267788']";

    private static final String CONTACTS_NAV_BAR = "//*[@id='rec469350955']//a[.='Контакты']";

    public DataSciencePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Перейти на страницу 'Курсы по Data Science'
    public void openDataSciencePage(String url) {
        driver.get(url);
    }

    // Возвращает название страницы 'Курсы по Data Science'
    public String getTitle() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TITLE))).getText();
    }

    // Нажать на кнопку 'Контакты' в navigation bar
    public void clickContactsNavBarButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CONTACTS_NAV_BAR))).click();
    }

    // Нажать на иконку бургер-меню на боковой панели
    public void clickBurgerMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BURGER_MENU))).click();
    }

    // Выбрать курс с названием courseName из опций бургер-меню
    public void chooseWebDevOption(String courseName) {
        this.clickBurgerMenu();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(BURGER_MENU_OPTION.replace("{COURSE_NAME}", courseName))
        )).click();
    }

    // Вернуться на главную страницу
    public void openMainPage() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SKILLFACTORY_HOME))).click();
    }

    // Открыть справочную информацию по кнопке 'Чем отличаются профессия, курс и полный курс'
    public void clickInfoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(COURSES_DIFFERENCE_INFO_BUTTON))).click();

    }

    // Получить значение аттрибута style элемента COURSES_DIFFERENCE_INFO_TEXT
    public String getStyleAttributeOfElement() {
        String style = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(COURSES_DIFFERENCE_INFO_TEXT))).getDomAttribute("style");
        System.out.println(style);
        return style;
    }
}

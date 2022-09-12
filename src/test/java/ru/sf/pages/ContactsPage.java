package ru.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final String POPUP_BUTTON = "//div[.='{TEXT}']/../../..";
    private static final String POPUP_1_FORM = "//div[@data-tooltip-hook='#popup:1']";
    private static final String POPUP_2_FORM = "//div[@data-tooltip-hook='#popup:2']";
    private static final String POPUP_4_FORM = "//div[@data-tooltip-hook='#popup:4']";
    private static final String POPUP_1_SEND_BUTTON = "//*[@id='form472342157']//button[.='Отправить']";
    private static final String POPUP_1_ERR_MSG = "//*[@id='form472342157']//div[contains(@class, 't-form__errorbox-middle')]//p[contains(@class, 'js-rule-error-req')]";
    private static final String POPUP_1_EMAIL_ERR_MSG = "//*[@id='form472342157']//input[@name='email']/following-sibling::div";
    private static final String POPUP_1_EMAIL_INPUT = "//*[@id='form472342157']//input[@name='email']";
    private static final String POPUP_1_NAME_INPUT = "//*[@id='form472342157']//input[@name='name']";
    private static final String POPUP_1_CLOSE_BUTTON = "//*[@id=\"rec472342157\"]//button[@aria-label='Закрыть диалог']";

    public ContactsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Перейти на страницу 'Контакты'
    public void openContactsPage(String url) {
        driver.get(url);
    }

    // Нажать на 'Я хочу начать обучение'
    public void clickStartStudyingPopupButton(String popupButtonName) {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(POPUP_BUTTON.replace("{TEXT}", popupButtonName))
        )).click();
    }

    // Получить значение аттрибута style всплывающего окна формы 'Ваш вопрос'
    public String getStyleAttributeOfElement(String popupButtonName) {
        String style= "";
        if(popupButtonName.equals("Я хочу начать обучение")) {
            style = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath(POPUP_1_FORM))).getDomAttribute("style");
        }
        else if(popupButtonName.equals("Я уже прохожу обучение")) {
            style = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath(POPUP_2_FORM))).getDomAttribute("style");
        }
        else if(popupButtonName.equals("Другое")) {
            style = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath(POPUP_4_FORM))).getDomAttribute("style");
        }
        System.out.println(style);
        return style;
    }

    // Нажать кнопку 'Отправить', чтобы отправить данные формы
    public void clickPopupSendButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_1_SEND_BUTTON))).click();
    }

    // Получить значение текста ошибки отправки пустой формы
    public String getErrorMsg() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_1_ERR_MSG))).getText();
    }

    //Ввести тестовый email в input
    public void insertTestEmail(String testEmail) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_1_EMAIL_INPUT))).sendKeys(testEmail);
    }

    // Ввести имя в input
    public void insertTestName(String name) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_1_NAME_INPUT))).sendKeys(name);
    }

    // Получить сообщение-предупреждение о неверном формате эл. почты
    // 'Укажите, пожалуйста, корректный email'
    public String getIncorrectEmailFormatMsg() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_1_EMAIL_ERR_MSG))).getText();
    }

    public void closePopup() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_1_CLOSE_BUTTON))).click();
    }

    // Получить имя из input
    public String getName() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_1_NAME_INPUT)))
                .getAttribute("value");
    }

    // Получить email из input
    public String getEmail() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_1_EMAIL_INPUT))).
                getAttribute("value");
    }
}

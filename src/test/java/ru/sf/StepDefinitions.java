package ru.sf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.sf.pages.*;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    public static final WebDriver driver;
    public static final MainPage mainPage;
    public static final EventsPage eventsPage;
    public static final CataloguePage cataloguePage;
    public static final DataSciencePage dataSciencePage;
    public static final DataScienceProPage dataScienceProPage;
    public static final WebDevPage webDevPage;
    public static final JavaPage javaPage;
    public static final ContactsPage contactsPage;

    static{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Masha\\IdeaProjects\\module-38-homework\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        eventsPage = new EventsPage(driver);
        cataloguePage = new CataloguePage(driver);
        dataSciencePage = new DataSciencePage(driver);
        dataScienceProPage = new DataScienceProPage(driver);
        webDevPage = new WebDevPage(driver);
        javaPage = new JavaPage(driver);
        contactsPage = new ContactsPage(driver);
    }

    // Перейти на главную страницу
    @Given("url of service {string}")
    public void url_of_service(String url) {
        mainPage.openMainPage(url);
    }

    // Нажать кнопку 'Бесплатные мероприятия'
    @Then("click free events button")
    public void click_free_events_button() {
        mainPage.clickFreeEventsButton();
    }

    // Нажать на кнопку 'Бесплатно' в шапке сайта
    @Then("click free nav bar button")
    public void click_free_nav_bar_button() {
        mainPage.clickFreeNavBarButton();
    }

    // Нажать кнопку 'Data Science'
    @Then("click data science button")
    public void click_data_science_button() {
        mainPage.clickDataScienceButton();
    }

    // Подтвердить, что открыта страница {string}
    @And("assert you are on {string} page")
    public void assert_you_are_on_page(String expectedUrl) {
        String actualUrl = "";
        if(expectedUrl.equals("https://skillfactory.ru/events")) {
            actualUrl = eventsPage.getUrl();
        }
        else if(expectedUrl.equals("https://skillfactory.ru/data-scientist-pro")) {
            actualUrl = dataScienceProPage.getUrl();
        }
        else if(expectedUrl.equals("https://skillfactory.ru/java")) {
            actualUrl = javaPage.getUrl();
        }
        else if(expectedUrl.equals("https://skillfactory.ru/web-razrabotka")) {
            actualUrl = webDevPage.getUrl();
        }
        else if(expectedUrl.equals("https://skillfactory.ru/")) {
            actualUrl = mainPage.getUrl();
        }
        else if(expectedUrl.equals("https://skillfactory.ru/catalogue")) {
            actualUrl = mainPage.getUrl();
        }
        System.out.println(actualUrl);
        assertEquals(expectedUrl, actualUrl);
    }

    // Навести курсор на 'Курсы' в navigation bar
    @Then("hover on courses button")
    public void hover_on_courses_button() {
        mainPage.mouseHoverOnCourses();
    }

    // Нажать на курс из выпадающего меню 'Курсы'
    @And("click course {string}")
    public void click_course(String courseName){
        mainPage.clickCourseFromCoursesActionMenu(courseName);
    }

    @And("assert title is {string}")
    public void assert_title_is(String expectedTitle) {
        String actualTitle = dataSciencePage.getTitle();
        assertEquals(expectedTitle, actualTitle);
        System.out.println(actualTitle);
    }

    @Then("open data science section")
    public void open_data_science_section() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cataloguePage.openDataScienceSection();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //
    @Then("click data scientist profession course")
    public void click_data_scientist_profession_course() {
        cataloguePage.openDataScienceProfession();
    }

    // Открыть раздел 'Java' на странице курсов по веб-разработке
    @Then("open Java section")
    public void open_java_section() {
        webDevPage.openJavaSection();
    }

    // Открыть страницу Data Science
    @Given("url of data science page {string}")
    public void url_of_data_science_page(String url) {
        dataSciencePage.openDataSciencePage(url);
    }

    @Then("choose {string} option from burger menu")
    public void choose_option_from_burger_menu(String courseName) {
        dataSciencePage.chooseWebDevOption(courseName);
    }

    // Вернуться на главную страницу
    @Then("go to home page")
    public void go_to_home_page() {
        dataSciencePage.openMainPage();
    }

    @Then("click course difference info")
    public void click_course_difference_info() {
        dataSciencePage.clickInfoButton();
    }

    @Then("click course difference info twice")
    public void click_course_difference_info_twice() throws InterruptedException {
        dataSciencePage.clickInfoButton();
        Thread.sleep(4000);
        dataSciencePage.clickInfoButton();
        Thread.sleep(4000);
    }

    // Элемент со справочной информацией виден
    @Then("assert info text is visible")
    public void assert_info_text_is_visible() {
        String style = dataSciencePage.getStyleAttributeOfElement();
        assertTrue(style.contains("display: block;"));
    }

    // Элемент со справочной информацией скрыт
    @Then("assert info text is invisible")
    public void assert_info_text_is_invisible() {
        String style = dataSciencePage.getStyleAttributeOfElement();
        assertTrue(style.contains("display: none;"));
    }

    // Кнопка 'Посмотреть все направления' на главной
    @Then("click courses catalogue button")
    public void click_courses_catalogue_button() {
        mainPage.clickCatalogueButton();
    }

    // Нажать 'Я хочу начать обучение'
    // или 'Я уже прохожу обучение', появится форма
    @Then("click popup button {string}")
    public void click_popup_button(String popupButtonName) {
        contactsPage.clickStartStudyingPopupButton(popupButtonName);
    }

    // Форма для ввода данных открыта
    @Then("assert popup {string} form is visible")
    public void assert_popup_form_is_visible(String popupButtonName) {
        String style = contactsPage.getStyleAttributeOfElement(popupButtonName);
        assertTrue(style.contains("display: block;"));
    }

    // Нажать 'Контакты' в шапке страницы
    @Then("click contacts nav bar button")
    public void click_contacts_nav_bar_button() {
        dataSciencePage.clickContactsNavBarButton();
    }

    // Перейти на страницу Контакты
    @Given("url of contacts page {string}")
    public void url_of_contacts_page(String url) {
        contactsPage.openContactsPage(url);
    }

    // Нажать кнопку Отправить (данные формы)
    @Then("click send button")
    public void click_send_button() {
        contactsPage.clickPopupSendButton();
    }

    // При отправке формы с пустыми полями
    // сообщение об ошибке имеет текст 'Пожалуйста, заполните все обязательные поля'
    @Then("assert getting error message")
    public void assert_getting_error_message() {
        String actualErrorMsg = contactsPage.getErrorMsg();
        assertEquals("Пожалуйста, заполните все обязательные поля", actualErrorMsg);
    }

    //Ввести тестовый email в input
    @Then("enter email {string}")
    public void enter_email(String testEmail) {
        contactsPage.insertTestEmail(testEmail);
    }

    // Если отправить форму с неверным форматом эл.почты
    // появится предупреждение 'Укажите, пожалуйста, корректный email'
    @Then("assert getting incorrect email error message")
    public void assert_getting_incorrect_email_error_message() {
        String actualErrorMsg = contactsPage.getIncorrectEmailFormatMsg();
        assertEquals("Укажите, пожалуйста, корректный email", actualErrorMsg);
    }

    // Ввести имя и email в форму
    @Then("enter some data {string} {string}")
    public void enter_some_data(String name, String email) {
        contactsPage.insertTestName(name);
        contactsPage.insertTestEmail(email);
    }

    // Закрыть форму
    @Then("close popup form")
    public void close_popup_form() throws InterruptedException {
        Thread.sleep(3000);
        contactsPage.closePopup();
    }

    // Подтвердить, что введенные ранее имя и email сохранены в input-ах
    @Then("assert data is {string} {string}")
    public void assert_data_is(String name, String email) {
        assertEquals(name, contactsPage.getName());
        assertEquals(email, contactsPage.getEmail());
        System.out.println(contactsPage.getName());
        System.out.println(contactsPage.getEmail());
    }

    // Нажать на кнопку в футере с названием buttonName
    @And("click {string} button")
    public void click_button(String buttonName) {
        mainPage.clickFooterButton(buttonName);
    }

    // Подтвердить, что открыта страница с адресом expectedUrl
    @And("assert {string} page opened")
    public void assert_page_opened(String expectedUrl) {
        assertEquals(expectedUrl, driver.getCurrentUrl());
        System.out.println(driver.getCurrentUrl());
    }
}

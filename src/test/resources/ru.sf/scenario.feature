Feature:
    # 1. Позитивный сценарий: с главной страницы открыть страницу 'Бесплатные мероприятия'
    # с помощью кнопки 'Бесплатные мероприятия' в основной области главной страницы
  Scenario: open free events page with 'free events' button
    Given url of service 'https://skillfactory.ru/'
    Then click free events button
    And assert you are on 'https://skillfactory.ru/events' page

    # 2. Позитивный сценарий: с главной страницы открыть страницу 'ВСЕ КУРСЫ'
    # с помощью выпадающего списка 'Курсы' и перейти на курс 'Data Scientist'
  Scenario: open all courses page from action menu and choose data scientist course
    Given url of service 'https://skillfactory.ru/'
    Then hover on courses button
    And click course 'ВСЕ КУРСЫ'
    Then open data science section
    Then click data scientist profession course
    And assert you are on 'https://skillfactory.ru/data-scientist-pro' page

    # 3. Позитивный сценарий: с главной страницы перейти на страницу 'Курсы по Data Science'
    # с помощью выбора соответствующего пункта выпадающего списка 'Курсы'
  Scenario: open data science courses from action menu
    Given url of service 'https://skillfactory.ru/'
    Then hover on courses button
    And click course 'Data Science'
    And assert title is 'Курсы по Data Science'

    # 4. Позитивный сценарий: с главной страницы открыть страницу 'Веб-разработка'
    # и перейти к разделу 'Курсы на Java'
  Scenario: open web development course and go to Java courses section
    Given url of service 'https://skillfactory.ru/'
    Then hover on courses button
    And click course 'Веб-разработка'
    Then open Java section
    Then assert you are on 'https://skillfactory.ru/java' page

    # 5. Позитивный сценарий: со страницы 'Курсы по Data Science'
    # перейти к курсам по веб-разработке с помощью бургер-меню
  Scenario: open Web Development courses from Data Science courses page
    Given url of data science page 'https://skillfactory.ru/data-science'
    Then choose 'Веб-разработка' option from burger menu
    Then assert you are on 'https://skillfactory.ru/web-razrabotka' page

    # 6. Позитивный сценарий: со страницы 'Курсы по Data Science'
    # перейти к курсу 'Data Scientist' с помощью бургер-меню
  Scenario: open Data Scientist course from Data Science courses page
    Given url of data science page 'https://skillfactory.ru/data-science'
    Then choose 'Профессия Data Scientist' option from burger menu
    Then assert you are on 'https://skillfactory.ru/data-scientist-pro' page

    # 7. Позитивный сценарий: вернуться на главную страницу
    # со страницы 'Курсы по Data Science' с помощью кнопки с логотипом SkillFactory
  Scenario: go back to home page
    Given url of service 'https://skillfactory.ru/'
    Then hover on courses button
    And click course 'Data Science'
    And go to home page
    And assert you are on 'https://skillfactory.ru/' page

    # 8. Позитивный сценарий: на странице 'Курсы по Data Science'
    # по нажатию кнопки 'Чем отличаются профессия, курс и полный курс'
    # открывается справочная информация
  Scenario: course difference info opens when click button
    Given url of data science page 'https://skillfactory.ru/data-science'
    Then click course difference info
    And assert info text is visible

    # 9. Позитивный сценарий: на странице 'Курсы по Data Science'
    # по повторному нажатию кнопки 'Чем отличаются профессия, курс и полный курс'
    # закрывается справочная информация
  Scenario: course difference info closes when click button after opening
    Given url of data science page 'https://skillfactory.ru/data-science'
    Then click course difference info twice
    And assert info text is invisible

    # 10. Позитивный сценарий: с главной страницы
    # открыть страницу 'Бесплатные мероприятия' по кнопке 'Бесплатно' в шапке сайта
  Scenario: open free events page with 'Free' navigation bar button
    Given url of service 'https://skillfactory.ru/'
    Then click free nav bar button
    And assert you are on 'https://skillfactory.ru/events' page

    # 11. Позитивный сценарий: с главной страницы
    # открыть страницу 'Курсы по Data Science'
    # по кнопке 'Data Science' в основной области главной страницы
  Scenario: open Data Science courses with 'Data Science' button
    Given url of service 'https://skillfactory.ru/'
    Then click data science button
    And assert title is 'Курсы по Data Science'

    # 12. Позитивный сценарий: с главной страницы
    # открыть каталог всех курсов с помощью кнопки 'Посмотреть все направления'
    # в основной области главной страницы
  Scenario: open courses catalogue with see all courses button
    Given url of service 'https://skillfactory.ru/'
    Then click courses catalogue button
    And assert you are on 'https://skillfactory.ru/catalogue' page

    # 13. Позитивный сценарий: со страницы 'Курсы по Data Science'
    # перейти на страницу 'Контакты' по кнопке в шапке, нажать 'Я хочу начать обучение',
    # появится форма для заполнения
  Scenario: click start studying button on contacts page and get popup form
    Given url of data science page 'https://skillfactory.ru/data-science'
    Then click contacts nav bar button
    Then click popup button 'Я хочу начать обучение'
    And assert popup 'Я хочу начать обучение' form is visible

    # 14. Негативный сценарий: на странице 'Контакты' нажать 'Я хочу начать обучение',
    # оставить появившуюся форму не заполненной и нажать 'Отправить'.
    # Получить сообщение об ошибке отправки формы с незаполненными обязательными полями
  Scenario: get error message from sending empty form
    Given url of contacts page 'https://skillfactory.ru/contacts'
    Then click popup button 'Я хочу начать обучение'
    And click send button
    And assert getting error message

    # 15. Негативный сценарий: на странице 'Контакты' нажать 'Я хочу начать обучение',
    # в появившейся форме ввести некорректный формат эл. почты и нажать 'Отправить'.
    # Получить сообщение 'Укажите, пожалуйста, корректный email'
  Scenario: get error message from sending incorrect email format
    Given url of contacts page 'https://skillfactory.ru/contacts'
    Then click popup button 'Я хочу начать обучение'
    Then enter email 'testemail.com'
    And click send button
    And assert getting incorrect email error message

    # 16. Позитивный сценарий: на странице 'Контакты' нажать 'Я уже прохожу обучение', появится форма для заполнения
  Scenario: click already studying button on contacts page and get popup form
    Given url of contacts page 'https://skillfactory.ru/contacts'
    Then click popup button 'Я уже прохожу обучение'
    And assert popup 'Я уже прохожу обучение' form is visible

    # 17. Позитивный сценарий: на странице 'Контакты' нажать 'Другое', появится форма для заполнения
  Scenario: click business proposal button on contacts page and get popup form
    Given url of contacts page 'https://skillfactory.ru/contacts'
    Then click popup button 'Другое'
    And assert popup 'Другое' form is visible

    # 18. Позитивный сценарий: на странице 'Контакты' нажать 'Я хочу начать обучение',
    # заполнить поля 'Имя', 'Email' появившейся формы. Закрыть форму и открыть заново.
    # Введенные данные остаются сохранены
  Scenario: if insert data and close form then reopen data is saved
    Given url of contacts page 'https://skillfactory.ru/contacts'
    Then click popup button 'Я хочу начать обучение'
    Then enter some data 'Алиса' 'testemail.com'
    Then close popup form
    Then click popup button 'Я хочу начать обучение'
    And assert data is 'Алиса' 'testemail.com'

    # 19. Позитивный сценарий: с главной страницы перейти на страницу ВКонтакте по кнопке 'Vkontakte' в футере
  Scenario: open vkontakte page from main page
    Given url of service 'https://skillfactory.ru/'
    And click 'Vkontakte' button
    And assert 'https://vk.com/skillfactoryschool' page opened

    # 20. Позитивный сценарий: с главной страницы перейти на страницу Яндекс.Дзен по кнопке 'Яндекс.Дзен' в футере
  Scenario: open yandex dzen page from main page
    Given url of service 'https://skillfactory.ru/'
    And click 'Яндекс.Дзен' button
    And assert 'https://dzen.ru/skillfactory' page opened
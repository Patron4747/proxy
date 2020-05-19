**Сервис proxy служит для выполнения запросов в другие микросервисы, агрегирования, обработки этих данных 
и выдача результата клиенту**

# Dev профиль

**Для корректной работы сервиса должен быть поднят:**

+ Сервис discovery (https://github.com/Patron4747/discovery.git)
+ Сервис storage (https://github.com/Patron4747/storage.git) с профилем local-discovery.
+ Необходимо убедиться, что discovery зарегистрировал storage и proxy, просмотрев Eureca dashboard
в браузере http://{discovery.port}:8761/

** Функционал взаимодействия с сервисом proxy**

+ Получение списка всех вопросов
    Пример http-запрос GET http://{proxy.port}:8012/resource/question/getAllQuestions




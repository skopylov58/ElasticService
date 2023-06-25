# ElasticService (Тестовое задание)

Проект Spring Elastic представляет собой веб-приложение, основанное на фреймворке Spring Boot и интегрированное с Elasticsearch. 

  
# Использование API

 • POST /catalog/import - Импорт каталога по URL. Пример: https://front-end.tanuki.ru/feeds/tanuki/voronezh
 
 • GET / - Получить список всех продуктов.
 
 • GET /products/ - Получение списка продуктов с возможностью полнотекстового поиска по полю name и и фильтрация по categoryId (реализована возможность не указывать параметр categoryId)


# Дополнительная информация
 • Вся конфигурация приложения находится в файлах docker-compose.yaml и Dockerfile.

# Scooter, Api-test 
____


## Сводка
- [Скачивание и запуск проекта](#Скачивание-и-запуск-проекта)
- [Информация о проекте](#Информация-о-проекте)
    - [Информация по отчету Allure](#Информация-по-отчету-Allure)
- [Автор](#Автор)
____

## Скачивание и запуск проекта
<a name="Скачивание-и-запуск-проекта"></a>
Возможно скачать архив или клонировать проект при наличии git.
[Ссылка на скачивание архива](https://github.com/ArturMustafin/YandexScooter_api/archive/master.zip)
Команда для клонирования проекта:
```
$ git https://github.com/ArturMustafin/YandexScooter_api.git
```
Для запуска тестового набора необходимо в командной строке перейти в директорию проекта и выполнить команду:
```
mvn clean test 
```
____


## Информация о проекте
<a name="Информация-о-проекте"></a>
1. java 11
2. Maven
3. junit 4
4. rest-assured
5. allure
6. jackson
7. lombok
###### Тесты проходят в несколько потоков
____


### Информация по отчету Allure
<a name="Информация-по-отчету-Allure"></a>
Для просмотра отчета по результатам прохождения тестов используется команда:
```
allure:serve
```

Пример отчета: [Allure Overview ](https://docs.google.com/presentation/d/1NFi1d35rIpHnqxLwFyf7J7A-74Qw8zzyNA1JKWKJyUY/edit?usp=sharing)
____

## Автор
- **Артур Мустафин** - <artur5mustafin@gmail.com>, <artur90mustafin@mail.ru>
# Avialines
Плагин, добавляющий сеть авиалиний на сервер.

## Информация о плагине
Данный плагин реализует систему перелётов на варпы в игре Minecraft, возможность создавать авиакомпании, задавать собственную цену полёта на 1 блок, количество допускаемого багажа, и так далее. 
###### Максимальное количество авиакомпаний: 5.

## Версия плагина
Работает на версии: **Spgiot 1.12.2.**

## Зависимости
  - Vault
  - EssentialsX

## Пример конфигурационного файла и его настройка
После запуска плагина, в каталоге **plugins/Avialines**, создатся файл конфигурации, с названием **config.yml**.  Пример оформления файла:
```yml

avialines: # Список всех авиалиний
  id1: # ID авиалинии
    name: "&6&lАзимут" # Название авиалинии
    price: 5 # Прайс-цена полёта (Указывается на 1 блок полёта)
    bagage: 1 # Количество единиц багажа, допускаемого на борт
    icon: # Иконка авиакомпании в меню 
      material: WOOL # Материал иконки, указывается в формате текста заглавными буквами.
      color: 1 # ID цвета (значение от 0 до 15)
```

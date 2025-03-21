<!-- TOC -->
* [Технологии](#технологии)
  * [Git](#git)
    * [Основные понятия и команды](#основные-понятия-и-команды)
    * [Git Flow](#git-flow)
    * [Графическая оболочка для работы с git](#графическая-оболочка-для-работы-с-git)
    * [Тест для самопроверки по VCS](#тест-для-самопроверки-по-vcs)
  * [Системы сборки](#системы-сборки)
    * [Maven](#maven)
    * [Тест для самопроверки по Maven](#тест-для-самопроверки-по-maven)
  * [Best practices in code and app architecture (pt. 1)](#best-practices-in-code-and-app-architecture-pt-1)
  * [IoC, DI, Spring](#ioc-di-spring)
    * [Теоретическая информация](#теоретическая-информация)
    * [Тест для самопроверки по IoC](#тест-для-самопроверки-по-ioc)
    * [Задание 1](#задание-1)
  * [Spring Boot](#spring-boot)
    * [Почитать про Spring Boot](#почитать-про-spring-boot)
    * [Задание 2](#задание-2)
  * [Best practices in code and app architecture (pt. 2)](#best-practices-in-code-and-app-architecture-pt-2)
    * [Что считаем красивым кодом](#что-считаем-красивым-кодом)
    * [Тест для самопроверки по BP](#тест-для-самопроверки-по-bp)
  * [БД и миграции](#бд-и-миграции)
    * [Почитать о миграциях и системах контроля версий](#почитать-о-миграциях-и-системах-контроля-версий)
    * [Задание 3](#задание-3)
  * [ORM, JPA](#orm-jpa)
    * [Тест для самопроверки по работе с БД](#тест-для-самопроверки-по-работе-с-БД)
    * [Задание 4](#задание-4)
  * [Ресурсы](#ресурсы)
    * [Rest](#rest)
    * [DTO](#dto)
    * [OpenAPI](#openapi)
    * [Тест для самопроверки по ресурсам](#тест-для-самопроверки-по-ресурсам)
    * [Задание 5](#задание-5)
  * [Security (pt.1)](#security-pt1)
    * [Аутентификация](#аутентификация)
    * [Spring Security](#spring-security)
    * [Задание 6](#задание-6)
  * [Security (pt.2)](#security-pt2)
    * [Авторизация](#авторизация)
    * [Тест для самопроверки по Spring Security](#тест-для-самопроверки-по-spring-security)
* [Создание проекта, структура](#создание-проекта-структура)
  * [Создание основного проекта](#создание-основного-проекта)
  * [Многомодульная структура](#многомодульная-структура)
  * [JWT (JSON Web Tokens)](#jwt-json-web-tokens)
  * [Apache Kafka](#apache-kafka)
  * [Spring Security](#spring-security)
  * [FeignClient](#feignclient)
  * [Specifications](#specifications)
  * [Hibernate JPA Model Generator (hibernate-jpamodelgen)](#hibernate-jpa-model-generator-hibernate-jpamodelgen)
  * [Lombok](#lombok)
  * [Spring Email](#spring-email)
  * [JUnit](#junit)
  * [Docker](#docker)
    * [Сборка образа](#сборка-образа)
  * [Docker Compose](#docker-compose)
    * [Запуск сервисов](#запуск-сервисов)
* [Задание](#задание)
  * [User Service](#user-service)
    * [Описание](#описание)
    * [REST API](#rest-api)
    * [База данных](#база-данных)
    * [Подробное описание](#подробное-описание)
  * [Task Service](#task-service)
    * [Описание](#описание-1)
    * [REST API](#rest-api-1)
    * [База данных](#база-данных-1)
    * [Подробное описание](#подробное-описание-1)
    * [Отправка сообщений](#отправка-сообщений)
  * [Notification Service](#notification-service)
    * [Описание](#описание-2)
    * [REST API](#rest-api-2)
    * [База данных](#база-данных-2)
    * [Подробное описание](#подробное-описание-2)
<!-- TOC -->

# Технологии

## Git

Git — это инструмент, который помогает разработчикам управлять изменениями в коде. Представьте себе, что вы пишете
большой проект, и вам нужно отслеживать, кто и какие изменения сделал, а также иметь возможность вернуться к предыдущей
версии кода, если что-то пойдет не так.

Скачать Git — <https://git-scm.com/downloads>

### Основные понятия и команды

- Репозиторий (Repository). Репозиторий — это место, где хранится ваш проект. Он содержит всю историю изменений, файлы и
  метаданные проекта. Репозиторий может быть локальным (на вашем компьютере) или удалённым (например, на GitHub).
- Коммит (Commit). Коммит — это сохранение изменений в репозитории. Каждый коммит содержит снимок состояния вашего
  проекта
  в определённый момент времени. Коммиты имеют уникальные идентификаторы (хэши) и могут включать сообщение, описывающее
  сделанные изменения.
- Ветка (Branch). Ветка — это отдельная линия разработки. Ветки позволяют работать над разными функциями или
  исправлениями
  параллельно. Основная ветка проекта часто называется `master`. Ветки могут быть объединены (слияние) для интеграции
  изменений.
- Слияние (Merge). Слияние — это процесс объединения изменений из одной ветки в другую. Например, после завершения
  работы
  над новой функцией в отдельной ветке, вы можете слить её в основную ветку.
- Конфликт (Conflict). Конфликт возникает, когда Git не может автоматически объединить изменения из разных веток. Это
  может произойти, если изменения были внесены в одну и ту же часть файла. Конфликты нужно решать вручную.
- Удаленный репозиторий (Remote Repository). Удаленный репозиторий — это версия вашего репозитория, которая хранится на
  сервере, таком как `GitHub`, `GitLab` или `Bitbucket`. Удаленные репозитории используются для совместной работы и
  резервного
  копирования.
- Клонирование (Clone). Клонирование — это процесс создания копии удаленного репозитория на вашем локальном компьютере.
  Команда `git clone` используется для клонирования репозитория.
- Фетч (Fetch). Команда `git fetch` загружает изменения из удаленного репозитория, но не объединяет их с вашим локальным
  репозиторием. Это позволяет вам видеть, какие изменения были внесены другими, прежде чем интегрировать их.
- Пулл (Pull). Команда `git pull` загружает изменения из удаленного репозитория и автоматически объединяет их с вашим
  локальным репозиторием. Это сочетание команд `git fetch` и `git merge`.
- Пуш (Push). Команда `git push` отправляет ваши локальные изменения в удаленный репозиторий. Это позволяет другим
  видеть и
  использовать ваши изменения.
- Индекс (Index). Индекс — это область, где хранятся изменения, готовые для коммита. Команда `git add` используется для
  добавления изменений в индекс.
- .gitignore. Файл `.gitignore` содержит список файлов и директорий, которые Git должен игнорировать. Это полезно для
  исключения временных файлов, конфигураций и других ненужных элементов. Файл, как правило, располагается в корневой
  папке
  проекта и в подмодулях.
- Тег (Tag). Тег — это метка, которая используется для обозначения определённых точек в истории коммитов.
  Теги позволяют легко находить и обращаться к версиям проекта.
- Ребейз (Rebase). Команда `git rebase` позволяет перенести или объединить серию коммитов с одной ветки на другую. Это
  может
  помочь сделать историю коммитов более чистой и линейной.
- Чек-аут (Checkout). Команда `git checkout` позволяет переключаться между ветками или восстанавливать файлы до
  определённого состояния из истории коммитов.
- Хед (HEAD). `HEAD` — это указатель на текущий коммит или ветку, на которой вы сейчас находитесь. Обычно `HEAD`
  указывает на
  последний коммит в текущей ветке.

Подробнее о Git:
1) https://skillbox.ru/media/code/chto_takoe_git_obyasnyaem_na_skhemakh/
2) https://habr.com/ru/articles/541258/
3) https://skillbox.ru/media/code/gitlab-chto-eto-takoe-i-kak-im-polzovatsya/

Потренироваться: https://learngitbranching.js.org/?locale=ru_RU

### Git Flow

Есть несколько правил и рекомендаций для организации работы с Git. Как правило, они выбираются в зависимости от проекта
и зависят, например, от размера команды, частоты релизов и т.д. Подробнее про них можно почитать тут <https://bool.dev/blog/detail/git-branching-strategies>.
О GitFlow:
1) https://habr.com/ru/articles/767424/
2) https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow

Ниже перечислены основные названия и применение веток, которые могут быть применимы к разным flow.
- `master`: Основная ветка, содержащая стабильный и готовый к выпуску код.
- `develop`: Ветка для разработки, содержащая последний интегрированный код.
- `feature/*`: Ветки для разработки новых функций. Создаются от `develop` и после завершения работы сливаются обратно в
  `develop`.
- `release/*`: Ветки для подготовки к релизу. Создаются от develop и после завершения работы сливаются в `master` и
  develop.
- `hotfix/*`: Ветки для исправления критических ошибок. Создаются от master и после завершения работы сливаются
  в `master`
  и develop.

### Графическая оболочка для работы с git

Для работы с git можно использовать консоль и писать команды вручную, однако удобнее использовать графические оболочки.
В IntelliJ IDEA есть встроенное GUI для работы с git, но можно рассмотреть и альтернативные варианты, например
Sourcetree.

Скачать <https://www.sourcetreeapp.com>

### Тест для самопроверки по VCS

[https://forms.gle/z8ai7Mrc4KqYrg5X9](https://forms.gle/RbBJpjFyN8Rco3Dp9)

## Системы сборки
Системы сборки — это такие программные продукты, которые на основе некоторой конфигурации могут «собрать» ваш проект.
Под словом «собрать» здесь может скрываться очень обширный объем работы, который при «ручном» подходе требует значительных затрат времени.
Небольшой перечень для ясности:
- загрузить зависимые библиотеки для вашего проекта из сети (репозитория);
- скомпилировать классы модуля или всего проекта;
- сгенерировать дополнительные файлы: SQL-скрипты, XML-конфиги и т.п.;
- удалять/создавать директории и копировать в них указанные файлы;
- упаковка скомпилированных классов проекта в архивы различных форматов: zip, rar, rpm, jar, ear, war и др.;
- компиляция и запуск модульных тестов (unit-test) вашего проекта с результатами выполнения тестов и расчетом процента покрытия;
- установка (deploy) файлов проекта на удаленный сервер;
- генерация документации и отчетов.

Почитать о них можно тут: [https://zhukovsd.github.io/java-backend-learning-course/technologies/build-systems/](https://zhukovsd.github.io/java-backend-learning-course/technologies/build-systems/)

### Maven

**Описание:**
Maven — это инструмент для управления проектами и автоматизации сборки, используемый в Java. Он предоставляет
стандартизированный способ управления зависимостями, компиляции, тестирования и упаковки приложений. Maven использует
файл конфигурации `pom.xml` (Project Object Model), который описывает проект, его зависимости, плагины и цели сборки.
Дополнительно о Maven:
1) [https://skillbox.ru/media/code/osnovy-maven-chto-eto-takoe-i-kak-rabotaet/](https://skillbox.ru/media/code/osnovy-maven-chto-eto-takoe-i-kak-rabotaet/)
2) [https://habr.com/ru/articles/77382/](https://habr.com/ru/articles/77382/)

Пример конфигурации `pom.xml` можно посмотреть в текущем проекте.

### Тест для самопроверки по Maven

[https://forms.gle/Mc9PgED66VZjj5XS6](https://forms.gle/Mc9PgED66VZjj5XS6)

## Best practices in code and app architecture (pt. 1)

Мы стараемся сразу писать красивый и понятный код. Это заключается в
- правильной организации структуры проекта,
- must-have практиках непосредственно написания кода.

Начнем с архитектуры приложения (не путать с "архитектурой решения").

Луковая, гексагональная, чистая архитектура - все эти архитектуры нацелены на создание модульных и масштабируемых приложений. Все они говорят об одном - приложение необходимо делить на слои, каждый из которых выполняет строго определенный набор функций. Главная цель такого подхода - обеспечить независимость и модульность компонентов, а также четкую организацию кода для оптимизации разработки, масштабирования и поддержки приложений.

Подробнее:
1) [https://dzen.ru/a/ZQ4Tl75l7WzI9Oii](https://dzen.ru/a/ZQ4Tl75l7WzI9Oii)
2) [https://ru.hexlet.io/courses/java-web/lessons/mvc/theory_unit](https://ru.hexlet.io/courses/java-web/lessons/mvc/theory_unit)
3) [https://alexkosarev.name/2018/07/27/n-tier-java-part1/](https://alexkosarev.name/2018/07/27/n-tier-java-part1/) (до слов "Разработка бизнес-логики")

## IoC, DI, Spring

Уже много лет "Инверсия управления" считается стандартом разработки. Мы не управляем ЖЦ создания компонентов, передавая эту ответственность различным фреймворкам, мы только указываем какой-то минимальный необходимый набор параметров для создания этих самых компонентов.

### Теоретическая информация

1) Что же такое IoC:
- [https://alexkosarev.name/2019/06/20/ioc-di-and-dl/](https://alexkosarev.name/2019/06/20/ioc-di-and-dl/)
- [https://www.baeldung.com/cs/ioc](https://www.baeldung.com/cs/ioc)
2) DI является реализацией IoC:
- [https://apptractor.ru/info/articles/dependency-injection.html](https://apptractor.ru/info/articles/dependency-injection.html)
- [https://habr.com/ru/articles/434380/](https://habr.com/ru/articles/434380/)
- Краткая сборная солянка: [https://habr.com/ru/articles/131993/](https://habr.com/ru/articles/131993/)
3) Про Spring:
- [https://blog.skillfactory.ru/glossary/spring/](https://blog.skillfactory.ru/glossary/spring/)
- [https://habr.com/ru/articles/490586/](https://habr.com/ru/articles/490586/)
- [https://skillbox.ru/media/code/freymvork-spring-zachem-on-nuzhen-kak-ustroen-i-kak-rabotaet/](https://skillbox.ru/media/code/freymvork-spring-zachem-on-nuzhen-kak-ustroen-i-kak-rabotaet/)

### Тест для самопроверки по IoC

[https://forms.gle/Jf1cNfAFUgjFFFSP9](https://forms.gle/Jf1cNfAFUgjFFFSP9)

### Задание 1

Склонировать репозиторий (https://gitlab.com/kz.osu.cinimex), сделать ветки по GitFlow, все запушить.

В рабочей ветке сделать каркас сервиса (т.е. пустой сервис) <имя>-ed-app на spring boot версии 3.х.х (т.е. любой 3-ий) с использованием maven 3.х.х (GroupId - kz.osu.cinimex) на 17 Java.

В проект добавить 3 модуля:
- Сервисный слой (api),
- Слой доступа к данным (db),
- Слой бизнес-логики (impl).
У вас должно получиться 4 pom.xml - один родительский + 3 в модулях. Модуль бизнес логики должен видеть 2 других. Закомитить изменения, запушить ветку, сделать MR, добавить меня в reviewer.

N.B.:
- Application.java с main методом должен быть только один и располагаться в слое бизнес логики,
- в основном проекте кроме pom.xml и мб README ничего не должно быть,
- в api и db можно грохнуть папку test,
- не переживайте, прямо сейчас приложение не должно ни подниматься, ни билдиться.

## Spring Boot

Spring — это фреймворк для Java, на котором пишут веб-приложения и микросервисы. А Spring Boot — это расширение, которое упрощает и ускоряет работу со Spring. Оно представляет собой набор утилит, автоматизирующих настройки фреймворка.

Spring Boot разработан для ускорения создания веб-приложений. Он отличается от своего «родителя» тем, что не требует сложной настройки и имеет ряд встроенных инструментов, упрощающих написание кода.

В отличие от базового фреймворка, он умеет:
- упаковывать зависимости в стандартные starter-пакеты;
- автоматически конфигурировать приложения с помощью jar-зависимостей;
- использовать JavaConfig, что позволяет отказаться от использования XML;
- не зависеть от множественного импорта Maven и конфликтов версий, связанных с этим;
- обеспечивать мощную пакетную обработку и управлять конечными точками RES;
- упрощать интеграцию с другими Java-фреймворками, такими как JPA / Hibernate ORM, Struts и так далее;
- локально запускать встроенные HTTP-серверы, такие как Tomcat и Jetty, упрощая разработку и тестирование веб-приложений.

### Почитать про Spring Boot

1) [https://topjava.ru/blog/introducing-spring-boot](https://topjava.ru/blog/introducing-spring-boot)
2) [https://gitverse.ru/blog/articles/development/198-chto-takoe-spring-boot-ego-preimushestva-i-kak-nachat-s-nim-rabotat](https://gitverse.ru/blog/articles/development/198-chto-takoe-spring-boot-ego-preimushestva-i-kak-nachat-s-nim-rabotat)
3) [https://www.baeldung.com/spring-boot-start](https://www.baeldung.com/spring-boot-start)

В статьях упоминаются сервлеты и контейнеры сервлетов, котортко о них:
1) [https://blog.skillfactory.ru/glossary/servlet/](https://blog.skillfactory.ru/glossary/servlet/)
2) [https://blog.skillfactory.ru/glossary/apache-tomcat/](https://blog.skillfactory.ru/glossary/apache-tomcat/)

Дополнительно:
1) [https://www.baeldung.com/spring-boot-yaml-vs-properties](https://www.baeldung.com/spring-boot-yaml-vs-properties)
2) [https://habr.com/ru/articles/740802/](https://habr.com/ru/articles/740802/)

### Задание 2

1) от develop сделайте ветку feature/starters и перейдите на нее
2) в pom слоя бизнес логики добавьте spring стартеры: главный, web, jpa, test, security, версии зависимостей должны быть в основном pom проекта, не забудьте про dependency management
3) в папке properties добавьте файл `application.yml`, в нем задайте имя приложения (на ваше усмотрение)
4) измените Application.java: поправьте main метод, чтобы запускалось spring boot приложение, на класс повесьте аннотацию @SpringBootApplication
5) в сервисном и бизнес слоях добавьте зависимость на lombok

## Best practices in code and app architecture (pt. 2)

### Что считаем красивым кодом

1) О коде, все мб и не запомните, но какие-то простые вещи быстро ложатся в голову:
- [https://www.baeldung.com/java-clean-code](https://www.baeldung.com/java-clean-code)
- [https://docs.oracle.com/cd/A97688_16/generic.903/bp/java.htm](https://docs.oracle.com/cd/A97688_16/generic.903/bp/java.htm)
- [https://blog.jetbrains.com/idea/2024/02/java-best-practices/](https://blog.jetbrains.com/idea/2024/02/java-best-practices/)
- [https://www.tatvasoft.com/blog/java-best-practices/](https://www.tatvasoft.com/blog/java-best-practices/)
- [https://habr.com/ru/companies/piter/articles/676394/](https://habr.com/ru/companies/piter/articles/676394/)

Кроме того, нужно в IDEa поставить себе плагин SonarLint - это обертка над SonarQube(платформа для непрерывного анализа и измерения качества программного кода, разработанную компанией SonarSource). Сейчас SonarQube является чем-то вроде отраслевого стандарта. В своей работе SonarQube использует статический анализ кода: реальное его выполнение не требуется, так как анализируются именно «исходники». Предмет анализа этого инструмента — потенциальные ошибки и уязвимости, стандарты оформления кода, наличие тестов и уровень покрытия ими, а также дублирование кода и его поддерживаемость. Будет вам "в прямом эфире" помогать писать красиво.

2) Весьма приветствуется писать код в функциональном стиле.
- [https://skillbox.ru/media/base/funktsionalnye_interfeysy_i_lyambda_vyrazheniya_v_java/](https://skillbox.ru/media/base/funktsionalnye_interfeysy_i_lyambda_vyrazheniya_v_java/)
- [https://struchkov.dev/blog/ru/optional-in-java/](https://struchkov.dev/blog/ru/optional-in-java/)
- [https://habr.com/ru/articles/658457/](https://habr.com/ru/articles/658457/)
- [https://skillbox.ru/media/base/java-stream-api-kopilka-retseptov/](https://skillbox.ru/media/base/java-stream-api-kopilka-retseptov/)
- [https://youtu.be/Fswgne8y0GY?si=tB-DFQ_TupxliaOD](https://youtu.be/Fswgne8y0GY?si=tB-DFQ_TupxliaOD)
- [https://www.youtube.com/live/3qrNlWkJ3ac?si=rA-xBYkFMPWJlG_s](https://www.youtube.com/live/3qrNlWkJ3ac?si=rA-xBYkFMPWJlG_s)
- [https://www.baeldung.com/java-8-streams](https://www.baeldung.com/java-8-streams)
- [https://www.tpointtech.com/java-8-stream](https://www.tpointtech.com/java-8-stream) - как напоминалка, что есть (см. раздел Core Operations Over Streams)

### Тест для самопроверки по BP

[https://forms.gle/t8zrEoNkGX2nArr98](https://forms.gle/t8zrEoNkGX2nArr98)

## БД и миграции

По мере разработки и поддержки приложения база данных изменяется: добавляются таблицы, столбцы и т.д. В современных проектах тех. требования вырабатываются поэтапно, поэтому очень маловероятно, что вы сможете с самого начала точно угадать со структурой модели базы данных. Изменения, которые мы делаем в базе данных, меняют способ хранения в ней информации, устанавливают новые способы хранения или удаляют хранилище, которое больше не нужно. Для упрощения отслеживания этих изменений существуют специальные системы, управляющие миграциями БД.

Самое простое объяснение - это аналог git, только версионированию подвергнута структура базы данных, в некоторых случаях ее базовое наполнение. Миграции слой за слоем последовательно “накатываются” в базу данных в известном порядке. Если в базе уже есть часть выполненных миграций, то будут использоваться только новые.
Информация, какие миграции были применены к базе данных, по умолчанию находится в этой же БД, в специальной таблице.

### Почитать о миграциях и системах контроля версий

- [https://struchkov.dev/blog/ru/get-started-liquibase/](https://struchkov.dev/blog/ru/get-started-liquibase/)
- [https://tproger.ru/articles/migracii-baz-dannyh-s-pomoshhju-biblioteki-liquibase](https://tproger.ru/articles/migracii-baz-dannyh-s-pomoshhju-biblioteki-liquibase)
- [https://habr.com/ru/companies/otus/articles/532978/](https://habr.com/ru/companies/otus/articles/532978/)
- [https://www.baeldung.com/liquibase-vs-flyway](https://www.baeldung.com/liquibase-vs-flyway)
- [https://for-each.dev/lessons/b/-liquibase-refactor-schema-of-java-app](https://for-each.dev/lessons/b/-liquibase-refactor-schema-of-java-app)
- [https://habr.com/ru/articles/540500/](https://habr.com/ru/articles/540500/)

Мы будем работать в наших проектах с liquibase:
- [Liquibase Official Documentation](https://www.liquibase.org/documentation/index.html)

### Задание 3

1) добавьте в проект зависимость на postgres и liquibase
2) в модуле db в пакете resources создайте:
- скрипт с созданием схемы базы данных (назовите на свое усмотрение)
- пакет db_changelog, в котором расположите миграции для БД
3) с помощью liquibase создайте таблицы как на рисунке, продумайте возможные индексы

![](006.png)

P.S.: будет очень хорошо, если вы в docker поднимите контейнер с postgres:

```
docker run --name ed-app -p 5432:5432 -e POSTGRES_USER=sys -e POSTGRES_PASSWORD=password postgres:13.3
```

здесь: ed-app - имя контейнера, 5432 - стандартный порт, который занимает postgres (5432:5432 - это прокидывание порта из контейнера на такой же порт основного пространства вашего компа), POSTGRES_USER - root пользователь, POSTGRES_PASSWORD - root пароль, postgres:13.3 - имя образа с указанием версии

когда поднимите контейнер с postgres, добавьте в application.yml информацию об источнике данных (datasource).

Запустить миграции без запуска проекта можно командой:

```
mvn install liquibase:update -f <имя-модуля-db>/pom.xml -Dliquibase.host=localhost -Dliquibase.port=5432 -Dliquibase.db=postgres -Dliquibase.schema=<имя-схемы-которую-создадите> -Dliquibase.user=sys -Dliquibase.password=password
```

## ORM, JPA

Мы знаем, что в приложениях необходимо обеспечить работу с данными в терминах классов, а не таблиц данных и напротив, преобразовать термины и данные классов в данные, пригодные для хранения в СУБД. Необходимо также обеспечить интерфейс для CRUD-операций над данными. Для этого у нас есть ORM.

Короткая напоминалка:
- [https://blog.skillfactory.ru/glossary/orm/](https://blog.skillfactory.ru/glossary/orm/)

Есть несколько реализаций этой технологии, в Spring мы стандартно пользуемся JPA:
- [https://habr.com/ru/companies/otus/articles/686082/](https://habr.com/ru/companies/otus/articles/686082/)
- [https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa](https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa)
- [https://docs.spring.io/spring-data/jpa/reference/jpa/getting-started.html](https://docs.spring.io/spring-data/jpa/reference/jpa/getting-started.html)

### Тест для самопроверки по работе с БД

[https://forms.gle/xf8Lgn7h5gNHENFy8](https://forms.gle/xf8Lgn7h5gNHENFy8)

### Задание 4

1) необходимо создать классы сущностей для таблиц, которые вы сделали в прошлом задании. Расставьте все аннотации, не забудьте про ограничения
2) сделайте репозитории для созданных сущностей
3) создайте классы (сервисы) с методами под стандартные CRUD операции, реализуйте эти операции

P.S.: стандартно мы располагаем сущности в пакете entity,  репозитории в repository, сервисы в service, вспомогательные классы без бизнес логики в utils, всякие конфигурационные сервисы в config, всё, что связано с закрытием рестов, в security.

## Ресурсы

### REST

REST API (Representational State Transfer) – это архитектурный подход, описывающий рамки взаимодействия с API (распределенного приложения в сети). Это не протокол, а скорее список рекомендаций.

API (Application Programming Interface) представляет собой набор определений и протоколов. Разработчики создают API-интерфейсы для взаимодействия и обмена данными одного приложения или сайта с другими. API функционирует как своеобразный шлюз или посредник между клиентами и сервером.

Интерфейс API разрабатывается таким образом, чтобы программное обеспечение могло запросить определенный тип данных через сеть. Интерфейс совместим с любыми языками программирования, операционными системами, программами, сайтами, приложениями, flash и т.д.

Почитать:
- [https://systems.education/what-is-rest#showmore](https://systems.education/what-is-rest#showmore)
- [https://skillbox.ru/media/code/rest-api-chto-eto-takoe-i-kak-rabotaet/](https://skillbox.ru/media/code/rest-api-chto-eto-takoe-i-kak-rabotaet/)
- [https://blog.skillfactory.ru/glossary/rest-api/](https://blog.skillfactory.ru/glossary/rest-api/)

### DTO

Зачастую, в клиент-серверных приложениях, данные на клиенте (слой представления) и на сервере (слой бизнес логики) структурируются по-разному. На стороне сервера это дает нам возможность комфортно хранить данные в базе данных или оптимизировать использование данных в угоду производительности, в то же время заниматься user-friendly отображением данных на клиенте.

Что такое DTO и чем отличается от других объектов:
- [https://sky.pro/media/razlichiya-mezhdu-dto-vo-pojo-javabeans/](https://sky.pro/media/razlichiya-mezhdu-dto-vo-pojo-javabeans/)

В целом, мы можем перекладывать данные из одного объекта в другой в "ручном" режиме, но можем и автоматизировать этот процесс с помощью библиотек. Например, Mapstruct:
- [https://habr.com/ru/articles/818489/](https://habr.com/ru/articles/818489/)
- [https://www.baeldung.com/mapstruct](https://www.baeldung.com/mapstruct)

### OpenAPI

Springdoc OpenAPI — это библиотека, которая автоматизирует генерацию документации OpenAPI 3.0 для RESTful API, реализованных на основе Spring Boot. Она предоставляет аннотации и конфигурации для легкой интеграции и генерации спецификации API на основе кода. 

В целом, Swagger (a.k.a. OpenAPI) — это набор инструментов, который позволяет автоматически описывать API на основе кода **или** правил. В кросс-функциональных командах, работающих по скраму, важно быстро реализовывать фичи за один спринт. У нас нет времени ждать, когда бэк будет готов, чтобы фронт или мобилка приступили к своей реализации. Тут на помощь аналитикам приходит Swagger: он позволяет публиковать контракт API, что дает возможность всем разработчикам — бэкенд, фронтенд и мобильным — работать параллельно.

Дополнительно:
- [https://community.exolve.ru/blog/swagger-chto-eto-kak-rabotat-s-dokumentatsiey/](https://community.exolve.ru/blog/swagger-chto-eto-kak-rabotat-s-dokumentatsiey/)
- [Springdoc OpenAPI Official Documentation](https://springdoc.org/)
- [Spring Boot + Springdoc OpenAPI Integration Example](https://www.baeldung.com/spring-rest-openapi-documentation)

### Тест для самопроверки по ресурсам

[https://forms.gle/udWxkuBDnZnHytTN9](https://forms.gle/udWxkuBDnZnHytTN9)

### Задание 5

При написании Java-контроллера непосредственно реализующего структуру API следует разделять логику. Контроллеры должны быть ответственны только за прием данных и формирование ответа. Это принцип единственной ответственности или Single Responsibility principle (SOLID). Именно поэтому в модуль api мы не добавляли зависимость на impl. На практике в модуле api модуле мы создаем интерфейс, в котором описываем ресурсы, а в модуле impl - делается реализация этого интерфейса.

1) в модуле api создайте пакет dto, а в нем DTO, представляющие следующие объекты:

Краткая информация об организации:
``` json

{
  "id": "id организации",
  "name": "Название организации",
  "country": {
    "name": "Название старны",
    "capital": "Название столицы"
  },
  "address": "Адрес организации"
}
```

Детальная информация об организации:
```json

{
  "id": "id организации",
  "name": "Название организации",
  "accounts": [
    {
      "number": "Номер счета",
      "currency": {
        "code": "ISO код валюты",
        "digitalCode": "Цифровой код валюты"
      },
      "name": "Название счета",
      "type": "Тип счета"
    }
  ]
}
```

Краткая информация о счете:
```json

{
  "id": "id счета",
  "number": "Номер счета",
  "type": "Тип счета"
}
```

Детальная информация о счете:
```json

{
  "id": "id счета",
  "number": "Номер счета",
  "currency": {
    "code": "ISO код валюты",
    "digitalCode": "Цифровой код валюты"
  },
  "name": "Название счета",
  "type": "Тип счета",
  "organizationId": "id организации, которой принадлежит счет"
}
```

а также DTO, соответствующие моделям organization, account, country, currency.

2) в модуле api в пакете resource/v1 создайте интерфейсы контроллеров для ресурсов "Организации", "Счета", "Страны", "Валюты" в контроллерах реализуйте основные CRUD ресурсы (создать, получить список, получить по id, изменить, удалить):
   - для ресурса "получить список организаций" в ответе используйте модель "Краткая информация об организации",
   - для "получить организацию по id" - "Детальная информация об организации",
   - для "получить список счетов" - "Краткая информация о счете",
   - для "получить счет" - "Детальная информация о счете",
   - для создания/редактирования любого ресурса используйте DTO, соответствующие доменным моделям,
   - для ресурсов "Страны" и "Валюты" используйте DTO, соответствующие доменным моделям.
3) в модуле impl в пакете resource/v1 создайте реализации контроллеров, добавьте в них зависимости на соответствующие сервисы, вызовите методы сервисов для получения ресурсов.
4) доработайте методы сервисов - они должны отдавать DTO, а не entity, для этого:
   - добавьте в impl зависимость на mapstruct,
   - в impl создайте пакет mappers, в нем создайте классы (в виде интерфейсов) мапперов, в классах создайте методы для маппинга из доменной модели в dto и наоборот,
   - в сервисах добавьте зависимость соответствующих мапперов и используйте их в методах для конвертации моделек.
5) задокументируйте ваши ресурсы:
   - в модуль api добавьте зависимости `springdoc-openapi-starter-webmvc-ui` и `springdoc-openapi-starter-webmvc-api`,
   - расставьте нужные аннотации в интерфейсах и DTO, чтобы описать получившиеся ресурсы.

## Security (pt.1)

### Аутентификация

- [https://habr.com/ru/articles/720842/](https://habr.com/ru/articles/720842/)
- [https://www.unisender.com/ru/glossary/chto-takoe-email-autentifikaciya/#anchor-1](https://www.unisender.com/ru/glossary/chto-takoe-email-autentifikaciya/#anchor-1)
- [https://infostart.ru/1c/articles/2035437/](https://infostart.ru/1c/articles/2035437/)
- [https://zuplo.com/blog/2025/01/03/top-7-api-authentication-methods-compared](https://zuplo.com/blog/2025/01/03/top-7-api-authentication-methods-compared)

### Spring Security

Spring Security значительно упрощает защиту корпоративных приложений, разработанных на Java. Этот мощный фреймворк обеспечивает защиту проекта, предоставляя готовые к использованию функции, которые помогут вам реализовать надежную авторизацию и аутентификацию.

Мы сделаем Basic Auth в наших приложениях, как это должно быть в Spring:

- [https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/basic.html](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/basic.html)
- [https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html](https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html)
- [https://jstobigdata.com/spring-security/the-ultimate-guide-to-spring-security-basic-authentication/#toc_5_Integrating_Basic_Authentication_with_a_User_Store](https://jstobigdata.com/spring-security/the-ultimate-guide-to-spring-security-basic-authentication/#toc_5_Integrating_Basic_Authentication_with_a_User_Store)
- [https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html#servlet-authentication-unpwd](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html#servlet-authentication-unpwd) (см. до Create a @RestController for Authentication)

### Задание 6

- добавьте в модуль impl пакет config
- создайте в /config класс SecurityConfig, в нем реализуйте SecurityFilterChain для Basic Auth, используйте InMemoryUserDetailsManager
- логин и пароль не зашивайте в SecurityConfig, а добавьте их в application.yml (переменные назовите сами) и подтяните в поля в SecurityConfig через @Value
- т.к. у вас должен работать swagger, то
1) вам надо добавить его пути в белый список и разрешить к ним доступ без аутентификации (в ссылках на spring поищите permitAll()),
2) в /config надо создать OpenApiConfig, кастомизировав ui swagger'а, см. пример тут: [https://www.baeldung.com/openapi-jwt-authentication](https://www.baeldung.com/openapi-jwt-authentication) (ну только вместо JWT вам надо указать Basic)

## Security (pt.2)

В прошлый раз мы сделали блок по аутентификации пользователя в системе, но никаких прав ему не раздавали, т.е. прямо сейчас любому аутентифицированному пользователю доступны любые ресурсы. Давайте усложним задачу.

### Авторизация

- [https://www.baeldung.com/spring-security-expressions](https://www.baeldung.com/spring-security-expressions)
- [https://docs.spring.io/spring-security/site/docs/4.0.x/reference/html/el-access.html](https://docs.spring.io/spring-security/site/docs/4.0.x/reference/html/el-access.html)
- [https://sysout.ru/zashhita-metodov-annotatsiya-preauthorize/](https://sysout.ru/zashhita-metodov-annotatsiya-preauthorize/)
- [https://www.geeksforgeeks.org/difference-between-hasrole-and-hasauthority-in-spring-security/](https://www.geeksforgeeks.org/difference-between-hasrole-and-hasauthority-in-spring-security/)
- [https://www.baeldung.com/spring-security-custom-filter](https://www.baeldung.com/spring-security-custom-filter)

### Тест для самопроверки по Spring Security

[https://forms.gle/MtdY99JPLitgfkqq6](https://forms.gle/MtdY99JPLitgfkqq6)




# Создание проекта, структура

## Создание основного проекта

Создадим новое Spring Boot приложения с использованием Maven.

Для этого можно воспользоваться сервисом [https://start.spring.io](https://start.spring.io/) или создать новое
приложение сразу в `IntelliJ IDEA`. Будем использовать второй вариант, для этого выберем `File -> New -> Project`. В
диалоговом окне слева выберем Spring Boot и заполним поля.

![](001.png)

**Type**: Maven.  
**Language**: Java.  
**Group**: Группа проекта, например, ru.cinimex  
**Artifact**: Название сервиса, например, firstapp.  
**Name:** Название сервиса, например, firstapp.  
**Description:** Описание, например, First Spring Boot Project.  
**Package name**: По умолчанию будет ru.cinimex. firstapp.  
**Packaging**: Jar.  
**Java**: 17.

На следующем экране можно выбрать версию Spring Boot и дополнительные зависимости.

Нажмем на кнопку Create. Мы должны получить следующую структуру

![](002.png)

### Многомодульная структура

Многомодульная структура позволяет разделить проект на логически изолированные части, что облегчает управление,
тестирование и повторное использование кода. Модули могут иметь разные названия и назначения, но мы будем использовать
три модуля:

- `api` - предназначен для хранения интерфейсов контроллеров и DTO;
- `db` - предназначен для хранения миграций базы данных;
- `impl` - содержит всю остальную логику приложения, включая реализации сервисов, репозиториев и бизнес-логику.

Для добавления модуля щёлкнем правой кнопкой мыши на корневом проекте в дереве проекта и выберите New -> Module. В
диалоговом окне слева выберем Java и заполним поля:

**Group:** ru.cinimex  
**Artifact:** firstapp-api  
**Name:** firstapp-api  
**Parent:** firstapp (должен быть главный модуль)

![](003.png)

Аналогично заполняем для остальных модулей.

После добавления всех модулей нужно провести небольшой рефактор структуры. Удалим папку `src` из модуля `impl` и
перенесем
туда папку `src` из главного модуля. Удалим папку `src/test` из модуля api. Удалим папки `src/test` и `src/main/java` из
модуля
`db`. Скопируем файл `.gitignore` из корневого модуля в три дочерние.

Добавим базовые пакеты в модуль `api` и `impl`. Пакеты можно добавлять по мере их надобности. Пример получившейся
структуры:

![](004.png)

## JWT (JSON Web Tokens)

**Описание:**
JWT (JSON Web Tokens) — это стандарт для создания токенов доступа, которые могут быть использованы для аутентификации и
авторизации. JWT состоит из трех частей: заголовка, полезной нагрузки и подписи.

**Полезные ссылки:**

- [JWT Parser](https://jwt.io)

## Apache Kafka

**Описание:**
Apache Kafka — это распределённая потоковая платформа, которая используется для построения систем реального времени.
Kafka позволяет публиковать и подписываться на потоки записей, сохранять потоки записей и обрабатывать их.

**Полезные ссылки:**

- [Apache Kafka Official Documentation](https://kafka.apache.org/documentation/)
- [Spring Boot + Kafka Integration Example](https://www.baeldung.com/spring-kafka)

## Spring Security

**Описание:**
Spring Security — это мощный и настраиваемый фреймворк для обеспечения безопасности приложений на платформе Spring. Он
предоставляет все необходимые средства для аутентификации и авторизации пользователей, защиты веб-приложений от
различных атак (например, CSRF, XSS) и управления доступом на основе ролей и политик.

**Полезные ссылки:**

- [Spring Security Official Documentation](https://docs.spring.io/spring-security/reference/index.html)
- [Creating a Spring Security Key for Signing a JWT Token](https://www.baeldung.com/spring-security-sign-jwt-token)

## FeignClient

**Описание:**
FeignClient — это декларативный веб-клиент для упрощения вызовов REST API. Он интегрируется с Spring Boot и позволяет
легко взаимодействовать с другими микросервисами, используя аннотации для определения HTTP-запросов.

**Полезные ссылки:**

- [Spring Boot + FeignClient Integration Example](https://www.baeldung.com/spring-cloud-openfeign)

## Specifications

**Описание:**
Specifications — это часть Spring Data JPA, которая позволяет создавать динамические запросы к базе данных с
использованием критериев (Criteria API). Они предоставляют мощный и гибкий способ построения сложных запросов.

Для использования нужно подключить [hibernate-jpamodelgen](#hibernate-jpa-model-generator-hibernate-jpamodelgen).

**Полезные ссылки:**

- [Ищем с помощью Spring Data JPA](https://uthark.github.io/2012/04/24/spring-data-jpa/)

## Hibernate JPA Model Generator (hibernate-jpamodelgen)

**Описание:**
Hibernate JPA Model Generator (hibernate-jpamodelgen) — это инструмент для автоматической генерации метамоделей JPA.
Метамодели используются для создания типобезопасных запросов с использованием Criteria API.

**Подключение:**

```xml

<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-jpamodelgen</artifactId>
</dependency>
```

## Lombok

**Описание:**
Lombok — это библиотека для Java, которая значительно упрощает разработку, устраняя необходимость написания шаблонного
кода. Lombok аннотирует классы и автоматически генерирует код, такой как геттеры, сеттеры, конструкторы,
методы `equals`, `hashCode`, `toString` и многое другое.

**Полезные ссылки:**

- [Lombok Official Documentation](https://projectlombok.org/)
- [Spring Boot + Lombok Integration Example](https://www.baeldung.com/intro-to-project-lombok)

## Spring Email

**Описание:**
Spring Email — это часть Spring Framework, которая предоставляет удобный способ отправки email-сообщений с
использованием JavaMailSender. Spring Email интегрируется с различными email-серверами и позволяет легко конфигурировать
и отправлять email-сообщения в приложениях Spring Boot.

**Полезные ссылки:**

- [Spring Boot + Email Integration Example](https://www.baeldung.com/spring-email)

## JUnit

**Описание:**
JUnit — это популярный фреймворк для написания и выполнения тестов на языке программирования Java. JUnit поддерживает 
создание тестов, выполнение тестов, сбор и анализ результатов тестирования.

**Полезные ссылки:**

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)  
- [Spring Boot Testing](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing)  
- [Testing with Spring Boot](https://spring.io/guides/gs/testing-web/)  
- [Guide to Testing with Spring Boot](https://www.baeldung.com/spring-boot-testing)


## Docker

**Описание:**
Docker - это платформа для автоматизации развёртывания, масштабирования и управления приложениями в контейнерах.
Она позволяет разработчикам упаковывать приложения и все необходимые зависимости в стандартизированные единицы,
которые могут работать в любом окружении, обеспечивая консистентность и изоляцию.

### Сборка образа

В модулях `-db` и `-impl` текущего проекта находятся примеры Dockerfile.  
Для самостоятельной сборки образа нужно сначала собрать проект `mvn package`, после этого в папке `target`
появятся `.jar` файлы, имена которых нужно указать в Dockerfile.
В командной строке, находясь в нужном модуле, выполнить команду `docker build . -t firstapp-db` для сборки образа в
модуле `-db`, и `docker build . -t firstapp` для сборки образа модуле `-impl`.

**Полезные ссылки:**

- [Introduction to Docker](https://habr.com/ru/companies/ruvds/articles/438796/)
- [Docker Documentation](https://docs.docker.com)

## Docker Compose

**Описание:**
Docker Compose - это инструмент, предназначенный для определения и управления многоконтейнерными Docker-приложениями. 
С помощью файла `docker-compose.yml` можно описать конфигурацию всех контейнеров, сетей и томов, 
необходимых для работы приложения, и запускать их одной командой.

### Запуск сервисов
В папке `compose` основного модуля находится пример docker compose файла. Для запуска сервисов выполнить команду
`docker-compose up`. Образы из модулей `-db` и `-impl` должны быть предварительно собраны. 

Для создания схемы БД используется скрипт `compose/postgres/init/init.sql`.  
Задать environment переменные можно в самом `docker-compose.yml`, как это сделано для модуля `-db`, так и в отдельном файле
`compose/firstapp/application.env` как это сделано для модуля `-impl`.

**Полезные ссылки:**

- [Introduction to Docker Compose](https://habr.com/ru/companies/ruvds/articles/450312/)
- [Docker Compose Documentation](https://docs.docker.com/compose/)


# Задание

**Тема:** Система отправки напоминаний пользователям

**Описание:** Система для напоминаний о задачах должна автоматически отправлять пользователям уведомления о предстоящих
задачах. Она должна позволять пользователям настраивать дату и время отправки уведомлений, а так же их периодичность.

Система состоит из трех микросервисов:

- User Service
- Task Service
- Notification Service

![](005.png)

Сервисы, а также необходимые для них компоненты (Postgresql и [Apache Kafka](#apache-kafka)), должны запускаться через [Docker Compose](#docker-compose).


## User Service

### Описание

Сервис должен предоставлять REST API для регистрации и аутентификация пользователей, а так же дополнительные API для
администратора. В сервисе должен быть настроен [spring security](#spring-security) для
выдачи [JWT](#jwt-json-web-tokens) токенов зарегистрированным пользователям.

### REST API

- POST /register - Регистрация нового пользователя.
- POST /register/code - Подтверждение почты с помощью кода.
- POST /auth/login - Аутентификация пользователя
- GET /users/current - Получить информацию о текущем пользователе, логин пользователя брать из jwt токена
- GET /admin/users/{login} - Получить информацию о пользователе по логину администратором или техническим пользователем
- POST /admin/tech/token - Сгенерировать токен технического пользователя

### База данных

Таблица user:

``` postgresql
  id uuid (обязательное, первичный ключ)
  username varchar(100) (обязательное, уникальное, добавить индекс)
  password varchar(255) (обязательное)
  email varchar(200)(обязательное, уникальное)
  role varchar(10) (обязательное, варианты значений [USER, ADMIN])
  is_active boolean (обязательное, по умолчанию false)
  created_at timestamptz (обязательное)
  updated_at timestamptz (обязательное)
```

Таблица temp_code:

``` postgresql
  id uuid (обязательное, первичный ключ)
  user_id uuid (обязательное, внешний ключ на таблицу user)
  code varchar(6) (код подтверждения, обязательное)
```

### Подробное описание

Создать сервис с тремя модулями `-api`, `-db`, `-impl`.

В модуле `-api` должны быть интерфейсы двух контроллеров (контроллер с регистрацией и аутентификацией пользователя,
и контроллер с получением информации о пользователе), а также классы dto, которые используются в интерфейсах.

Модуль `-db` должен содержать файлы миграции [Liquibase](#liquibase) для создания структуры БД. Нужно добавить 2 changeSet - создание
таблицы user и создание таблицы temp_code, каждый changeSet поместить в отдельный файл.
Модуль должен собираться в jar файл.

Модуль `-impl` должен содержать основные класса для работы приложения. В данный модуль должен подключаться модуль `-api`
для реализации интерфейсов. Модуль также должен собираться в jar файл.

В сервис нужно подключить [Lombok](#lombok) и расставить нужные аннотации.
В сервис нужно подключить [Swagger](#swagger-springdoc) и расставить нужные аннотации для описания API.
В сервисе нужно подключить [spring security](#spring-security) и настроить ее для выдачи и
проверки [JWT](#jwt-json-web-tokens) токенов.
Пример можно найти в текущем проекте.
Реализации REST API должны быть помечены аннотацией `@PreAuthorize` с указанием роли.
В сервисе должна быть подключена [Kafka](#apache-kafka) и должен быть сконфигурирован `Producer` для отправки сообщения в топик
`notification.message.in`.

Покрыть все публичные методы классов в папке service `unit` и контроллеры тестами с помощью [JUnit](#junit).

Собрать [Docker](#docker) образ для `-db` и `-impl` модулей.

- #### POST /register
  **Входящие данные:** json c данными пользователя, например
  ```json
  {
    "username": "ivan",
    "password": "123",
    "email": "ivan@gmail.com"
  }
  ```
  **Роли:** доступно всем
  <br><br>
  **Алгоритм работы:**  
  Проверить, что пользователь с таким `username` или `email` не зарегистрирован в системе, то есть нет записей с таким
  `username` или `email` в таблице user и поле `is_active = false`. Если пользователь уже зарегистрирован — выбросить
  исключение.
  Используя Mapstruct, конвертировать входящее DTO в `UserEntity`, использовать аннотацию `@AfterMapping` для
  заполнения остальных полей:
  ```
  id = рандомный UUID
  role = USER
  created_at = текущее дата и время
  updated_at = текущее дата и время
  password = использовать бин PasswordEncoder для хеширования пароля
  ```
  Заполнить таблицу `temp_code` (без маппера):
  ```
  id = рандомный UUID
  user_id = id из UserEntity
  code = случайный 6-значный цифровой код
  ```
  Сохранить изменения в БД. Все действия выше должны быть в одной транзакции.
  Отправить сообщение в сервис `Notification Service` через [Kafka](#apache-kafka). Пример сообщения
  ```json
  {
    "email": "ivan@gmail.com",
    "header": "Подтверждение почты",
    "body": "Ваш код подтверждения - 653218"
  }
  ```

  **Возвращаемое значение:**
    - HTTP code 200 и `id` созданной `UserEntity`, если пользователь успешно создан
    - HTTP code 400 и описание ошибки, если пользователь уже существует
    - HTTP code 500 и описание ошибки, если произошла другая ошибка


- #### POST /register/code
  **Входящие данные:**  
  json c кодом подтверждения и id пользователя, например
  ```json
  {
    "id": "c0c4a8d4-762f-4496-bfe0-06d0c19ebc8c",
    "code": "653218"
  }
  ```
  **Роли:** доступно всем
  <br><br>
  **Алгоритм работы:**  
  По переданному `id` найти пользователя в таблице `user`, проверить, что у данного пользователя стоит
  `is_active = false,` найти связанную таблицу `temp_code`, проверить, что переданный код совпадает с полем code
  в таблице. Если пользователя не существует или последующие проверки не пройдены - выбросить исключение.

  Если все проверки пройдены, установить пользователю `is_active = true,` обновить поле `updated_at`, удалить
  соответствующую
  запись из таблицы `temp_code`.
  <br><br>
  **Возвращаемое значение:**
    - HTTP code 200 если код совпал
    - HTTP code 400, если произошла ошибка из перечисленных
    - HTTP code 400 и описание ошибки, если пользователя с таким id не существует или последующие проверки не пройдены
    - HTTP code 500 и описание ошибки, если произошла другая ошибка


- #### POST /auth/login
  **Входящие данные:**  
  Логин и пароль пользователя, например
  ```json
  {
    "username": "ivan",
    "password": "123"
  }
  ```
  **Роли:** доступно всем
  <br><br>
  **Алгоритм работы:**  
  Выполнить аутентификацию с использованием `username` и `password`. Если аутентификация прошла успешно, сгенерировать
  [JWT](#jwt-json-web-tokens) токен и вернуть его пользователю, иначе выбросить исключение. Подробный пример можно найти
  внутри проекта.
  <br><br>
  **Возвращаемое значение:**
    - HTTP code 200 и [JWT](#jwt-json-web-tokens) token
    - HTTP code 403, если логин и пароль не правильные
    - HTTP code 500 и описание ошибки, если произошла другая ошибка

- #### GET /users/current
  **Входящие данные:**  
  Нет
  <br><br>
  **Роли:** пользователь с ролью USER или ADMIN
  <br><br>
  **Алгоритм работы:**  
  Из [JWT](#jwt-json-web-tokens) токена получить логин пользователя и вернуть json c информацией по нему, например
  ```json
  {
    "username": "ivan",
    "email": "ivan@gmail.com",
    "role": "USER"
  }
  ```
  **Возвращаемое значение:**
    - HTTP code 200 и json c информацией о пользователе
    - HTTP code 401, если не передан [JWT](#jwt-json-web-tokens) токен
    - HTTP code 403, если пользователь не имеет нужной роли
    - HTTP code 500 и описание ошибки, если произошла другая ошибка

- #### GET /admin/users/{login}
  **Входящие данные:**  
  `login` пользователя
  <br><br>
  **Роли:** пользователь с ролью ADMIN или TECH
  <br><br>
  **Алгоритм работы:**  
  По переданному `login` получить информацию о пользователе и вернуть json c информацией по нему, например
  ```json
  {
    "username": "ivan",
    "email": "ivan@gmail.com",
    "role": "USER"
  }
  ```
  <br><br>
  **Возвращаемое значение:**
    - HTTP code 200 и json c информацией о пользователе
    - HTTP code 401, если не передан [JWT](#jwt-json-web-tokens) токен
    - HTTP code 403, если пользователь не имеет нужной роли
    - HTTP code 500 и описание ошибки, если произошла другая ошибка

- #### POST /admin/tech/token
  **Входящие данные:**  
  `expired_date` дата до которой действует токен технического пользователя
  <br><br>

  **Роли:** пользователь с ролью ADMIN
  <br><br>

  **Алгоритм работы:**  
  Сгенерировать технический токен, пример метода `JwtService::generateTechToken(OffsetDateTime)`. Данный пользователь 
  не сохраняется в базе.
  <br><br>

  **Возвращаемое значение:**
  - HTTP code 200 и токен технического пользователя
  - HTTP code 401, если не передан [JWT](#jwt-json-web-tokens) токен
  - HTTP code 403, если пользователь не имеет нужной роли
  - HTTP code 500 и описание ошибки, если произошла другая ошибка

## Task Service

### Описание

Сервис должен предоставлять REST API для создания, получения, обновления и удаления задач.

### REST API

- POST /tasks - Создать новую задачу
- GET /tasks - Получить список задач текущего пользователя
- GET /tasks/{id} - Получить информацию о задаче по ID
- PUT /tasks/{id} - Обновить задачу по ID
- DELETE /tasks/{id} - Удалить задачу по ID

### База данных

Таблица task:

```postgresql
   id uuid (обязательное, первичный ключ)
   title text (обязательное)
   description text (необязательное)
   status varchar(20) (обязательное, варианты значений [CREATED, DONE, ERROR])
   assignee varchar(100) (обязательное, логин пользователя)
   created_at timestamptz (обязательное)
   updated_at timestamptz (обязательное)
   notificate_at timestamptz (обязательное)
```

### Подробное описание

Создать сервис с тремя модулями `-api`, `-db`, `-impl`.

В модуле `-api` должны быть интерфейс контроллера, а также классы dto, которые используются в интерфейсе.

Модуль `-db` должен содержать файлы миграции [Liquibase](#liquibase) для создания структуры БД. Нужно добавить 1 changeSet - создание
таблицы task. Модуль должен собираться в `jar` файл.

Модуль `-impl` должен содержать основные класса для работы приложения. В данный модуль должен подключаться модуль `-api`
для реализации интерфейсов. Модуль также должен собираться в `jar` файл.

В сервис нужно подключить [Lombok](#lombok) и расставить нужные аннотации.
В сервисе нужно подключить [spring security](#spring-security) и настроить ее для проверки [JWT](#jwt-json-web-tokens)
токенов. Пример можно
найти в текущем проекте.
В сервис нужно подключить [Swagger](#swagger-springdoc) и расставить нужные аннотации для описания API.
Реализация всех REST API должны быть помечены аннотацией `@PreAuthorize` с указанием роли USER и ADMIN.
В сервисе должна быть подключена [Kafka](#apache-kafka) и должен быть сконфигурирован `Producer` для отправки сообщения в топик
`notification.message.in`.

Покрыть все публичные методы классов в папке service `unit` и контроллеры тестами с помощью [JUnit](#junit).

Собрать [Docker](#docker) образ для `-db` и `-impl` модулей.

- #### POST /tasks
  **Входящие данные:**  
  json с данными задачи, например
  ```json
  {
    "title": "Название задачи",
    "description": "Описание задачи, может быть null",
    "notificate_at": "2024-08-14T13:52:22"
  }
  ```
  **Роли:** пользователь с ролью USER
  <br><br>
  **Алгоритм работы:**  
  Проверить, что дата из поля `notificate_at` больше текущей, если это не так, выбросить исключение.
  Используя Mapstruct, конвертировать входящее DTO в `TaskEntity`, использовать аннотацию `@AfterMapping` для
  заполнения остальных полей:
  ```
  id = рандомный UUID
  status = CREATED
  created_at = текущее дата и время
  updated_at = текущее дата и время
  assignee = login пользователя из jwt
  ``` 
  Сохранить `TaskEntity` в базу.
  <br><br>
  **Возвращаемое значение:**
    - HTTP code 200 и id созданной задачи
    - HTTP code 401, если не передан [JWT](#jwt-json-web-tokens) токен
    - HTTP code 403, если пользователь не имеет нужной роли
    - HTTP code 500 и описание ошибки, если произошла другая ошибка

- #### GET /tasks
  **Входящие данные:**  
  Поля для фильтра title, status, notificate_at_start, notificate_at_end
  <br><br>
  **Роли:** пользователь с ролью USER
  <br><br>
  **Алгоритм работы:**  
  Получить из таблицы `task` список задач текущего пользователя. Использовать [Specifications](#specifications) для создания запроса к БД
  (поля, по которым проводить фильтрацию взять из входящих параметров), `login` пользователя взять
  из [JWT](#jwt-json-web-tokens).
  <br><br>
  **Возвращаемое значение:**
    - HTTP code 200 и json со списком задач
    - HTTP code 401, если не передан [JWT](#jwt-json-web-tokens) токен
    - HTTP code 403, если пользователь не имеет нужной роли
    - HTTP code 500 и описание ошибки, если произошла другая ошибка

- #### GET /tasks/{id}
  **Входящие данные:**  
  `id` созданной задачи
  <br><br>
  **Роли:** пользователь с ролью USER
  <br><br>
  **Алгоритм работы:**  
  Получить из таблицы `task` запись по `id` из параметров запроса. Если такой задачи не существует выбросить исключение.
  Проверить, что в поле `assignee` равно `login` пользователя из [JWT](#jwt-json-web-tokens), если это не так, выбросить
  исключение.
  <br><br>
  **Возвращаемое значение:**
    - HTTP code 200 и json с данными по задаче
    - HTTP code 400, если произошла ошибка из перечисленных
    - HTTP code 401, если не передан [JWT](#jwt-json-web-tokens) токен
    - HTTP code 403, если пользователь не имеет нужной роли
    - HTTP code 500 и описание ошибки, если произошла другая ошибка

- #### PUT /tasks/{id}
  **Входящие данные:**  
  `id` созданной задачи и json с данными задачи, например
  ```json
   {
     "title": "Название задачи",
     "description": "Описание задачи, может быть null",
     "notificate_at": "2024-08-14T13:52:22"
   }
   ```
  **Роли:** пользователь с ролью USER
  <br><br>
  **Алгоритм работы:**  
  Получить из таблицы `task` запись по `id` из параметров запроса. Если такой задачи не существует, выбросить
  исключение.
  Проверить, что статус задачи равен `CREATED`, если это не так, выбросить исключение.
  Проверить, что в поле `assignee` равно `login` пользователя из [JWT](#jwt-json-web-tokens), если это не так, выбросить
  исключение.
  Обновить значение полей из входящих данных используя Mapstruct, использовать аннотацию `@AfterMapping` для
  заполнения остальных полей:
  ```
    updated_at = текущее дата и время
  ``` 

  **Возвращаемое значение:**
    - HTTP code 200
    - HTTP code 400, если произошла ошибка из перечисленных
    - HTTP code 401, если не передан [JWT](#jwt-json-web-tokens) токен
    - HTTP code 403, если пользователь не имеет нужной роли
    - HTTP code 500 и описание ошибки, если произошла другая ошибка

- #### DELETE /tasks/{id}
  **Входящие данные:**  
  `id` созданной задачи
  <br><br>
  **Роли:** пользователь с ролью USER
  <br><br>
  **Алгоритм работы:**  
  Получить из таблицы `task` запись по `id` из параметров запроса. Если такой задачи не существует, выбросить
  исключение.
  Проверить, что статус задачи равен `CREATED`, если это не так, выбросить исключение.
  Проверить, что в поле `assignee` равно `login` пользователя из [JWT](#jwt-json-web-tokens), если это не так, выбросить
  исключение.
  Удалить запись из БД.

  **Возвращаемое значение:**
    - HTTP code 200
    - HTTP code 400, если произошла ошибка из перечисленных
    - HTTP code 401, если не передан [JWT](#jwt-json-web-tokens) токен
    - HTTP code 403, если пользователь не имеет нужной роли
    - HTTP code 500 и описание ошибки, если произошла другая ошибка

### Отправка сообщений
Реализовать метод отправки сообщений в [Kafka](#apache-kafka) по шедулеру. Использовать `cron` выражения для настройки
интервала отправки, по умолчанию раз в минуту (вынести параметром в `application.yml`).

**Алгоритм работы:**  
Получить и заблокировать `n` записей из таблицы `task` со `status = CREATED` и текущем временем больше notificate_at. 
Получить `email` пользователя, вызвав GET /admin/users/{login} (User service) через [FeignClient](#feignclient), 
указать в качестве jwt токена, технический токен. Технический токен должен быть сгенерирован заранее и вынесен как параметр в `application.yml`.
Сформировать сообщения в [Kafka](#apache-kafka) и отправить. Если отправка прошла успешно, проставить всем записям `status = DONE`. 
Сохранить изменения в БД и отпустить блокировку, если произошла ошибка, проставить записям `status = ERROR` и отпустить блокировку.  
Параметр `n` вынести в `application.yml`, по умолчанию 5.
Блокировку сделать через репозиторий и аннотации
```java
@Lock(LockModeType.PESSIMISTIC_WRITE)
@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "-2")})
```
[Подробнее тут](https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/chapters/locking/Locking.html#locking-LockMode)


## Notification Service

### Описание

Сервис для отправки сообщений по email.

### REST API

Нет.

### База данных

Нет.

### Подробное описание

Создать сервис с одним модулями `-impl`. Настроить отправку email с помощью [Spring Email](#spring-email).
В сервисе должна быть подключена [Kafka](#apache-kafka) и должен быть сконфигурирован `Consumer` для прослушивания сообщений
из топика `notification.message.in`.
В сервис нужно подключить [Lombok](#lombok) и расставить нужные аннотации.

Покрыть все публичные методы классов в папке service `unit` тестами с помощью [JUnit](#junit).

Собрать [Docker](#docker) образ для `-impl` модуля.

# Test automation project for [Reddit](https://reddit.com/)

![Reddit_logo](images/icons/Reddit_logo_new.svg.png)

>Reddit is an American social news aggregation, content rating, and discussion website. Registered users submit content to the site such as links, text posts, images, and videos, which are then voted up or down by other members. Consists of website and mobile applications for Android and iOS. 

# <a name="TableOfContents">Table of contents</a>
* [Description](#Description)
* [Tools and technologies](#Technology)
* [Coverage of tests](#Coverage)
* [How to run](#Jenkins)
    + [Gradle command](#GradleCommand)
    + [Local run](Localrun)
    + [Property files](#PropertyFiles)
        + [Default property files](#PropertyFilesDefaults)
    + [Run in Jenkins](#RunInJenkins)
* [Telegram Notifications](#TelegramNotifications)
* [Test results report in Allure Report](#AllureReport)

# <a name="Description">Description</a>
The test project consists of Web, API and mobile(android) tests.\
A brief list of interesting facts about the project:
- [x] `Page Object` with steps using `Chain of Invocations`
- [x] Fake data generating with `Faker` library
- [x] Parametrized build
- [x] Different configuration files for test running depending on build parameters
- [x] Config with `Owner` library
- [x] `Allure TestOps` integration


# <a name="Technology">Tools and a technologies</a>
<p  align="center">
  <code><img width="5%" title="Java" src="./images/icons/java-logo.svg"></code>
<code><img width="5%" title="IntelliJ IDEA" src="./images/icons/IDEA-logo.svg"></code>
  <code><img width="5%" title="Selenide" src="./images/icons/selenide-logo.svg"></code>
  <code><img width="5%" title="Selenoid" src="./images/icons/selenoid-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="./images/icons/gradle-logo.svg"></code>
  <code><img width="5%" title="JUnit5" src="./images/icons/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="./images/icons/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="./images/icons/allure-ee-logo.svg"></code>
  <code><img width="5%" title="Github" src="./images/icons/git-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="./images/icons/jenkins-logo.svg"></code>
  <code><img width="5%" title="Telegram" src="./images/icons/Telegram.svg"></code>
</p>

The autotests in this project are written in `Java` using `Selenide` framework.\
`Gradle` - is used as a build automation tool.  \
`JUnit5` - to execute tests.\
`Jenkins` - CI/CD for running tests remotely.\
`Selenoid` - to remote launching browsers in `Docker` containers.\
`Allure Report` - for test results visualisation.\
`Telegram Bot` - for test results notifications.\
`Allure TestOps` - as Test Management System.


# <a name="Coverage">Coverage of tests</a>

### <a name="Authorization(positive test)">Authorization(positive test)</a>

+ successful authorization
### <a name="Authorization(negative tests)">Authorization(negative tests)</a>


+ authorization with wrong login
+ authorization with wrong password
+ authorization with wrong login and password
+ authorization with short login (less 3 characters)
+ authorization with long login (more 20 characters)
+ authorization with empty login field
+ authorization with empty password field

# <a name="HowToRun">How to run</a>

## <a name="GradleCommand">Gradle command</a>
To run locally use command:
```bash
gradle clean test -Denv=local
```
To run Jenkins use command:
```bash
gradle clean test -Denv=remote
```
To rut on your own environment:

+ create property file with necessary parameters and put it in test.resources
+ run test with command:
```bash
gradle clean test -Denv={file name}
```
## <a name="Localrun">Local run</a>

Credentials (login/password) from Reddit account haven't upload at GitHub to save sensitive data you need to create property file manually and put file to `src/test/resources` with name `credentials.properties`.
Example of credentials.properties file:
```properties
login = some_login
password = somePassword
```


## <a name="PropertyFiles">Property files</a>
Possible properties in a `${env}.properties` file:
```properties
remoteUrl=
browserSize=
browser=
browserVersion=
baseUrl=
isRemote=
```

>- *remoteUrl* - URL for remote WebDriver
>- *browserSize* - size of browser for Web tests
>- *browser* - browser for Web tests
>- *browserVersion* - version of browser
>- *baseUrl* - base URL for Web tests
>- *isRemote* - flag for local/remote running


### <a name="PropertyFilesDefaults">Default property files</a>

    local.properties

```properties
remoteUrl = https://user1:1234@selenoid.autotests.cloud/
browserSize =1920x1080
browser = chrome
browserVersion = 100.0
baseUrl = https://www.reddit.com/
isRemote = false
```

## <a name="RunInJenkins">Run in [Jenkins](https://jenkins.autotests.cloud/job/reddit_tests//)</a>
Click on "Build with Parameters" button, after that click on "Build":
<p  align="center">
<img src="images/screen/gif_reddit.gif" alt="JenkinsBuildMainPage" width="800">
</p>

File with credentials from Reddit account has already attached.
<p  align="center">
<img src="images/screen/2023-01-10_17-23-21.png" alt="JenkinsBuildMainPage" width="800">
</p>


# <a name="TelegramNotifications">Telegram Notifications</a>
Telegram bot sends a report to a special telegram chat by results of each build. Information about bot setting you can find by link:https://github.com/qa-guru/allure-notifications. Bot also can be use for Slack, Email notifications. 
<p  align="center">
<img src="images/screen/2023-01-10_19-04-54.png" alt="TelegramNotification" width="450">
</p>


# <a name="AllureReport">Test results report in [Allure Report](https://jenkins.autotests.cloud/job/reddit_tests/allure/)</a>

## Main page
Main page of Allure report contains some general information about ran tests.

<p align="center">
  <img src="images/screen/2023-01-10_19-11-29.png" alt="AllureReportMain" width="950">
</p>

## List of tests with steps and test artefacts
On the page the list of the tests grouped by suites with status shown for each test.

<p align="center">
  <img src="images/screen/allure.png" alt="AllureReportSuites" width="1150">
</p>

Each test has artefacts:
>- Screenshot
>- Page Source
>- Browser console log
>- Video

##    Example video of test run from Allure report

<p align="left">
  <img src="images/screen/video.gif" alt="AllureReportSuites2" width="900">
</p>




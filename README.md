# MetricsAgent

This project shows an example of a metric-gathering extension for a web application. 
The “extension” is loosely coupled with the web app to gather metrics on requests and responses served by the application.
The project implements these [requirements](https://contrast-security-oss.github.io/join-the-team/challenges.html#java-instrumentation-engineer-project).  

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them

```
Java8
Gradle
```

### Installing
Steps to install and run the application locally

```
git clone - to get the source code
./gradlew build && java -jar build/libs/java-agent-0.1.0.jar
```


If everything worked correctly you should see the app running on `localhost:8080 ` 

## Running the tests

You can run automated unit tests inside your favorite ide or run ` ./gradlew test` from the root folder


## Built With

* [spring-boot](https://spring.io/projects/spring-boot) - Opinionated spring based framework with embedded web-server
* [AspectJ](https://www.eclipse.org/aspectj/) - Cross cutting concern
* [Gradle](https://gradle.org/) - Dependency Management
* [Travis CI](https://travis-ci.org/) - CI / CD

## Authors

* **Pratik Pandey** - *Initial work* - [Mr. TrouseredApe](https://github.com/TrouseredApe)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details


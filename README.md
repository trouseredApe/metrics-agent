# MetricsAgent

This project shows an example of a metric-gathering extension for a web application based on these [requirements](https://contrast-security-oss.github.io/join-the-team/challenges.html#java-instrumentation-engineer-project). 
The “extension” is loosely coupled with the app to gathers metrics on requests and responses served by the web application.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Here are the pre-requisites for this project.  

```
Java8
Gradle
```

Will update this README file to show how these pre-requisites can be installed. 

### Installing
Steps to install and run the application locally

```
git@github.com:trouseredApe/metrics-agent.git - to get the source code
./gradlew build && java -jar build/libs/java-agent-0.1.0.jar - to get build and run locally
```


If everything worked correctly you should see the app running on `localhost:8080 ` 

## Running the tests

You can run automated unit tests inside your favorite ide or run `./gradlew test` from the project's root folder


## Built With

* [spring-boot](https://spring.io/projects/spring-boot) - Opinionated spring based framework with embedded web-server
* [AspectJ](https://www.eclipse.org/aspectj/) - Cross cutting concern
* [Gradle](https://gradle.org/) - Dependency Management
* [Travis CI](https://travis-ci.org/) - CI / CD

## Authors
* **Pratik Pandey** - *Initial work* - [Mr. TrouseredApe](https://github.com/TrouseredApe)
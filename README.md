# MetricsAgent
This project shows an example of a metric gathering extension for a web application based on these [requirements](https://contrast-security-oss.github.io/join-the-team/challenges.html#java-instrumentation-engineer-project). The “extension” is loosely coupled with the app to gathers metrics on requests and responses handled by the web application.

In the code you'll see the following two projects:  

`meme-app`, a sample web application that serves memes.

`metrics-collection-agent`, an aspectJ based project that is an external dependency to the `meme-app`. The agent collects metrics on the web application's request and response by weaving aspects during compile time. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Here are the pre-requisites for this project.  

```
Java8
Maven
```
### Installing
These instructions applies for *nix based systems. 

`git clone git@github.com:trouseredApe/metrics-agent.git - to get the source code`

`cd metrics-agent/agent`

`mvn install`

Now import meme-app as a maven project in IntellJ and build project and run `Application.java` class.


If everything worked correctly you should see the app running at `localhost:8080`. Click the `Next` link on the page to load a few memes and access the request and response metrics at `localhost:8080/metrics` page

The in-memory database can be accessed at `localhost:8080/h2-console`. Make sure to use `jdbc:h2:mem:testdb` as datasource url.

## Running the tests

You can run the unit tests inside your ide or run `mvn test` from the project's root folder


## Built With

* [spring-boot](https://spring.io/projects/spring-boot) - Opinionated spring based framework with embedded web-server
* [AspectJ](https://www.eclipse.org/aspectj/) - Cross cutting concern
* [Maven](https://maven.apache.org/) - Dependency Management
* [Travis CI](https://travis-ci.org/) - CI / CD

## Author
* [Pratik Pandey](https://github.com/TrouseredApe)
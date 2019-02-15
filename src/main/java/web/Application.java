package web;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication (scanBasePackages={"repository", "service","web", })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

        /**
         * Request Time: measure time spent between when the application starts to process the request and the time when the application sends the response to the client.
         Response Sizes: measure the size of the HTTP response body in bytes.
         Metrics: Calculate minimum, average, and maximum for Request Time and Response Size.
         Identifier: Add a unique identifier to every response via an HTTP header.
         Implement a page that will display the metrics gathered by the extension. The display should include minimum, average, and maximum of both Request Time and Response Size.
         Bonus/Optional: Provide a front-end UI that allows users to look up historical request time/response size by unique identifier.
         Integrate with CI
         Write unit tests
         Write a README, project that explains what you built, why you built it, how to deploy it up and how to use it.
         Use a CI Pipeline to compile, build, test and report in Travis CI which is free for any Open Source project in GitHub Include the Travis build badgein your README to show status.

         */
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
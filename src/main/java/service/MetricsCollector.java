package service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MetricsCollector {

    @Before(value = "execution(* service.*.*(..))")
    public void before(JoinPoint joinPoint){
        //Advice
        System.out.println("<===============> before " + joinPoint);
    }

    @After(value = "execution(* service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        //Advice
        System.out.println("<===============> after " + joinPoint);
    }

}
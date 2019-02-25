package service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import repository.RequestMetrics;
import repository.RequestMetricsRepository;
import repository.ResponseMetrics;
import repository.ResponseMetricsRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Aspect
@Configuration
@ConditionalOnExpression("${endpoint.aspect.enabled:true}")
public class MetricsCollectionAspect {

    @Autowired
    RequestMetricsRepository requestMetricsRepository;

    @Autowired
    ResponseMetricsRepository responseMetricsRepository;

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) && execution(* web.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String uniqueID = UUID.randomUUID().toString();

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request =  requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();
        Object value = null;
        try {
            value =  joinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            if (value != null) {
                long endTime = System.currentTimeMillis();
                RequestMetrics requestMetrics = new RequestMetrics(uniqueID, request.getRequestURI(), Math.toIntExact(endTime - startTime));
                requestMetricsRepository.save(requestMetrics);

                ResponseMetrics responseMetrics = new ResponseMetrics(uniqueID, request.getRequestURI(), value.toString().getBytes("UTF-8").length);
                responseMetricsRepository.save(responseMetrics);

                response.setHeader("agent-id", uniqueID);
            }
        }
        return value;
    }

}
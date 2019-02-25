package service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import repository.RequestMetricsRepository;
import repository.ResponseMetricsRepository;
import web.Application;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MetricsCollectionAspect.class)
@ContextConfiguration(classes = Application.class)

public class MetricsCollectionAspectTest {

    @Autowired
    private MetricsCollectionAspect metricsCollectionAspect;

    @MockBean
    RequestMetricsRepository requestMetricsRepository;

    @MockBean
    ResponseMetricsRepository responseMetricsRepository;

    @Mock
    ProceedingJoinPoint joinPoint;

    @Before
    public void setup() throws Throwable {
        Mockito.when(joinPoint.proceed()).thenReturn(new Object());
    }

    @Test
    public void around() throws Throwable {
        metricsCollectionAspect.around(joinPoint);
        assertThat(requestMetricsRepository.findAll()).isNotNull();
    }
}
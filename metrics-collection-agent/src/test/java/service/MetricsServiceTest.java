package service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import repository.RequestMetrics;
import repository.RequestMetricsRepository;
import repository.ResponseMetrics;
import repository.ResponseMetricsRepository;
import web.Application;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MetricsService.class)
@ContextConfiguration(classes = Application.class)

public class MetricsServiceTest {

    @Autowired
    RequestMetricsRepository requestMetricsRepository;

    @Autowired
    ResponseMetricsRepository responseMetricsRepository;

    @Autowired
    private MetricsService metricsService;

    @Before
    public void setUp() {
        RequestMetrics requestMetrics1 = new RequestMetrics("id-1", "/", 220);
        requestMetrics1.setId(1L);
        requestMetricsRepository.save(requestMetrics1);

        RequestMetrics requestMetrics2 = new RequestMetrics("id-2", "/good", 120);
        requestMetrics2.setId(2L);
        requestMetricsRepository.save(requestMetrics2);

        ResponseMetrics responseMetrics1 = new ResponseMetrics("id-1", "/", 500);
        responseMetrics1.setId(1L);
        responseMetricsRepository.save(responseMetrics1);
    }

    @Test
    public void testAggregateRequestMetrics() throws Exception {
        Map<String, Object> map = metricsService.generateMetrics();
        assertThat(map.get("maxTime")).isEqualTo(220);
        assertThat(map.get("minTime")).isEqualTo(120);
        assertThat(map.get("avgSize")).isEqualTo(500.0);
    }

}

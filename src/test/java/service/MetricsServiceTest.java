package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MetricsService.class)
public class MetricsServiceTest {

    @Autowired
    private MetricsService metricsService;

    @Test
    public void testaggregateRequestMetrics() throws Exception {
        assertThat(metricsService.aggregateRequestMetrics()).isNotNull();
    }
}

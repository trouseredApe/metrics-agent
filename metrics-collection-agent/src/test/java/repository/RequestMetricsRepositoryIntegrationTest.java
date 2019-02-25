package repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import web.Application;


import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest()
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class RequestMetricsRepositoryIntegrationTest {

    @Autowired
    RequestMetricsRepository requestMetricsRepository;


    @Test
    public void whenFindByAll_thenReturnAllRequestMetrics() {
        // given
        RequestMetrics requestMetrics1 = new RequestMetrics();
        requestMetrics1.setId(1L);
        requestMetrics1.setProcessingTime(220);
        requestMetrics1.setResource("/");
        requestMetrics1.setUuid("id-1");
        requestMetricsRepository.save(requestMetrics1);

        RequestMetrics requestMetrics2 = new RequestMetrics();
        requestMetrics2.setId(2L);
        requestMetrics2.setProcessingTime(120);
        requestMetrics2.setResource("/good");
        requestMetrics2.setUuid("id-2");
        requestMetricsRepository.save(requestMetrics2);

        // when
        Iterator<RequestMetrics> metrics = requestMetricsRepository.findAll().iterator();

        // then
        int size =0;
        while(metrics.hasNext()) {
            size++;
            metrics.next();
        }
        assertThat(size).isEqualTo(2);
    }
}

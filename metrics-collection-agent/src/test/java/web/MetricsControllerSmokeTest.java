package web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import service.MetricsService;


import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class MetricsControllerSmokeTest {

    @Mock
    private Model model;

    @MockBean
    private MetricsService metricsService;


    @Autowired
    private MetricsController metricsController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(metricsController).isNotNull();
    }

    @Before
    public void setUp() {
        Map<String, Object> metrics = new HashMap<String, Object>();
        metrics.put("minTime", 100);
        Mockito.when(metricsService.generateMetrics())
                .thenReturn(metrics);
    }

    @Test
    public void testIndex() throws Exception {
        String htmlPage = metricsController.index(model);
        assertThat(htmlPage).isEqualTo("metrics.html");
    }
}
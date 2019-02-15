package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import web.MemeController;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MetricsCollector.class)
public class MetricsCollectorTest {

    @Autowired
    private MetricsCollector metricsCollector;

    @Test
    public void before()  {
        //test
    }

    @Test
    public void after()  {
        //test
    }
}



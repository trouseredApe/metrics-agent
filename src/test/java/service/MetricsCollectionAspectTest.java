package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import web.Application;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
//@AutoConfigureTestDatabase
@ContextConfiguration(classes = Application.class)
@SpringBootTest(classes = MetricsCollectionAspect.class)
public class MetricsCollectionAspectTest {

    @Autowired
    private MetricsCollectionAspect metricsCollectionAspect;

    @Test
    public void around()  {
        //test
    }
}



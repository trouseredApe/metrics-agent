package web;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemeControllerSmokeTest {

    @Autowired
    private MemeController memeController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(memeController).isNotNull();
    }

    @Test
    @Ignore
    public void indexTest() throws Exception {
        System.out.println(memeController.index(null));
        assertThat(memeController.index(null)).contains("good");
    }

}
package service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = MemeService.class)

public class MemeServiceTest {

    @Autowired
    private MemeService memeService;

    @Test
    public void testGenerateGoodMeme() throws Exception {
        assertThat(memeService.generateGoodMeme()).contains("<img");
    }

    @Test
    public void testGenerateGreatMeme() throws Exception {
        assertThat(memeService.generateGreatMeme()).contains("<img");
    }

    @Test
    public void testGenerateAwesomeMeme() throws Exception {
        assertThat(memeService.generateAwesomeMeme()).contains("<img");
    }
}
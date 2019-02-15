package service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MemeService.class)

public class MemeServiceTest {

    @Autowired
    private MemeService memeService;

    @Test
    public void testGenerateMeme() throws Exception {
        System.out.println("===================> " + memeService.generateMeme());
        assertEquals("meme-url", memeService.generateMeme());
    }
}
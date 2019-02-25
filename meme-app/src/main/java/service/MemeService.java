package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MemeService {

    @Value("${meme.html}")
    private String html;

    public String generateGoodMeme() {
        return String.format(html, new String[]{"good news", "/", "good news", "goodnews.jpg"});
    }

    public String generateGreatMeme() {
        return String.format(html, new String[]{"that would be great", "/good", "that would be great", "thatwouldbegreat.jpg"});
    }

    public String generateSuccessMeme() {
        return String.format(html, new String[]{"success", "/great", "success", "success.jpg"});
    }

}

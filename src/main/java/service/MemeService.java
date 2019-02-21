package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import repository.RequestMetricsRepository;

@Service
public class MemeService {

    @Autowired
    RequestMetricsRepository requestMetricsRepository;

    @Value("${meme.html}")
    private String html;

    public String generateGoodMeme() {
        return String.format(html, new String[]{"good news", "good news", "goodnews.jpg", "/great"});
    }

    public String generateGreatMeme() {
        return String.format(html, new String[]{"that would be great", "that would be great", "thatwouldbegreat.jpg", "/success"});
    }

    public String generateAwesomeMeme() {
        return String.format(html, new String[]{"success", "success", "success.jpg", "/"});
    }

}

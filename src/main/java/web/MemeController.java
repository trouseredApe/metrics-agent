package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import service.MemeService;

@RestController
public class MemeController {

    @Autowired
    MemeService memeService;

    @RequestMapping("/")
    public String index() {
        return "Here's today's meme for you " + memeService.generateMeme();
    }

}
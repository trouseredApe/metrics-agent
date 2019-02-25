package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import service.MemeService;

@RestController
public class MemeController {

    @Autowired
    MemeService memeService;

    @RequestMapping("/")
    public String index(Model model) {
        return memeService.generateSuccessMeme();
    }

    @RequestMapping("/great")
    public String great() {
        return memeService.generateGreatMeme();
    }

    @RequestMapping("/good")
    public String awesome() {
        return memeService.generateGoodMeme();
    }

}
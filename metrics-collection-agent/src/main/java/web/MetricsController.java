package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.MetricsService;

@Controller
public class MetricsController {
    @Autowired
    MetricsService metricsService;

    @RequestMapping("/metrics")
    public String index(Model model) {
        model.addAttribute("map", metricsService.generateMetrics());
        return "metrics.html";
    }
}

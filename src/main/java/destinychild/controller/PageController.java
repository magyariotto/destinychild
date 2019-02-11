package destinychild.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/home")
    public String index(){ return "home"; }

    @GetMapping("/map")
    public String map(){ return "map"; }

    @GetMapping("/")
    public String login(){ return "index"; }
}
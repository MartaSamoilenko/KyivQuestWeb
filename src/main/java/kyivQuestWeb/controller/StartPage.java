package kyivQuestWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPage {
    @GetMapping(value = "/start")
    public String startPage(){
        return "Start";
    }
}

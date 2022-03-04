package kyivQuestWeb.controller;

import kyivQuestWeb.model.Route;
import kyivQuestWeb.model.User;
import kyivQuestWeb.service.RouteService;
import kyivQuestWeb.service.UserService;
import kyivQuestWeb.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private RouteService routeService;

    @GetMapping(value = "/test")
    public String testPage(Model model, HttpServletRequest request){
        Cookie cookie = AppUtils.getLoginCookie(request);
        User user = userService.findByEmail(cookie.getValue());
        List<Route> routes = routeService.findAll();
        model.addAttribute("routes", routes);
        model.addAttribute("user", user);
        return "UserRouteChoiceTest";
    }

    @PostMapping(value = "/test")
    public String testPage(HttpServletRequest request, String name){
        System.out.println(name);
        return "redirect:/test1";
    }
}

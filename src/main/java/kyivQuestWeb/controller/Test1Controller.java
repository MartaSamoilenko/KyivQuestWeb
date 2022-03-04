package kyivQuestWeb.controller;

import kyivQuestWeb.model.User;
import kyivQuestWeb.service.UserService;
import kyivQuestWeb.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class Test1Controller {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/test1")
    public String test1Page(Model model, HttpServletRequest request){
        Cookie cookie = AppUtils.getLoginCookie(request);
        User user = userService.findByEmail(cookie.getValue());
        model.addAttribute("user", user);
        return "AchievmentsTest";
    }
}

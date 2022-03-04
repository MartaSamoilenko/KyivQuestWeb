package kyivQuestWeb.controller;

import kyivQuestWeb.service.UserService;
import kyivQuestWeb.utils.AppUtils;
import kyivQuestWeb.utils.CookieCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminShowUsers  extends CookieCheck {
    @Autowired
    private UserService userService;

    public Boolean check(HttpServletRequest request) {
        if (AppUtils.getLoginCookie(request) == null) {
            return false;
        }
        return true;
    }

    @GetMapping(value = "/admin/showUsers")
    public String showUsers(Model model, HttpServletRequest request){
        Cookie cookie = AppUtils.getLoginCookie(request);
        if (check(request)) {
            if (!StringUtils.isEmpty(cookie.getValue()) && !(userService.findByEmail(cookie.getValue()) == null) && (userService.findByEmail(cookie.getValue()).getRoleid() == 0)) {
                var users = userService.findAll();

                model.addAttribute("users", users);
                return "AdminShowUsers";
            } else {
                return "redirect:/loginOfUser";
            }
        }
        return "redirect:/start";
    }
}

package kyivQuestWeb.controller;

import kyivQuestWeb.service.UserService;
import kyivQuestWeb.utils.AppUtils;
import kyivQuestWeb.utils.CookieCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminMainPage extends CookieCheck {

    public Boolean check(HttpServletRequest request) {
        if (AppUtils.getLoginCookie(request) == null) {
            return false;
        }
        return true;
    }

    @Autowired
    private UserService userService;

    @GetMapping(value = "/admin/mainPage")
    public String mainPage(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = AppUtils.getLoginCookie(request);
        if (check(request)) {
            if (!StringUtils.isEmpty(cookie.getValue()) && !(userService.findByEmail(cookie.getValue()) == null) && (userService.findByEmail(cookie.getValue()).getRoleid() == 0)) {
                return "MainPageAdmin";
            } else {
                return "redirect:/loginOfUser";
            }
        }
        return "redirect:/start";
    }

    @PostMapping(value = "admin/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = AppUtils.getLoginCookie(request);
        if (cookie != null) {
            AppUtils.deleteLoginCookie(request, response);
        }
        return "redirect:/start";
    }
}

package kyivQuestWeb.controller;

import kyivQuestWeb.service.UserService;
import kyivQuestWeb.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    public Boolean check(HttpServletRequest request) {
        if (AppUtils.getLoginCookie(request) == null) {
            return false;
        }
        return true;
    }

    @Autowired
    private UserService userService;

    @GetMapping(value = "/loginOfUser")
    public String login(HttpServletRequest request) {
        if (check(request)) {
            Cookie cookie = AppUtils.getLoginCookie(request);
            if (!StringUtils.isEmpty(cookie.getValue()) && !(userService.findByEmail(cookie.getValue()) == null) && (userService.findByEmail(cookie.getValue()).getRoleid() == 1)) {
                return "redirect:/user/mainMenu";
            } else if (!StringUtils.isEmpty(cookie.getValue()) && !(userService.findByEmail(cookie.getValue()) == null) && (userService.findByEmail(cookie.getValue()).getRoleid() == 0)) {
                return "redirect:/admin/mainPage";
            } else {
                return "redirect:/loginOfUser";
            }
        }
        return "LoginPage";
    }

    @PostMapping(value = "/loginOfUser")
    public String loginPage(HttpServletRequest request, HttpServletResponse response,
                            String email, String password) {
            if (userService.findByEmail(email) != null && userService.findByEmail(email).getPassword().equals(password) && userService.findByEmail(email).getRoleid() == 1) {
                AppUtils.addLoginCookie(response, email);
                return "redirect:/user/mainMenu";
            } else if (userService.findByEmail(email) != null && userService.findByEmail(email).getPassword().equals(password) && userService.findByEmail(email).getRoleid() == 0) {
                AppUtils.addLoginCookie(response, email);
                return "redirect:/admin/mainPage";
            } else
                return "LoginPage";
    }
}

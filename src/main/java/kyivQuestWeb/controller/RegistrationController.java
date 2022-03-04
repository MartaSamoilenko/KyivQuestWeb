package kyivQuestWeb.controller;

import kyivQuestWeb.model.User;
import kyivQuestWeb.service.UserService;
import kyivQuestWeb.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class RegistrationController {
    public Boolean check(HttpServletRequest request) {
        if (AppUtils.getLoginCookie(request) == null) {
            return false;
        }
        return true;
    }

    @Autowired
    private UserService userService;

    @GetMapping(value = "/registrationOfUser")
    public String registrationOfUser(HttpServletRequest request) {
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
        return "RegistrationPage";
    }

    @PostMapping(value = "/registrationOfUser")
    public String registrationOfUser(@ModelAttribute("user") User userToAdd, HttpServletRequest request, HttpServletResponse response) {
        if (userService.findByNameAndSurname(userToAdd.getName(), userToAdd.getSurname()) == null && userService.findByEmail(userToAdd.getEmail()) == null) {
            userToAdd.setRoleid(1);
            userService.addUser(userToAdd);
            AppUtils.addLoginCookie(response, userToAdd.getEmail());
            return "redirect:/user/mainMenu";
        } else {
            return "redirect:/registrationOfUser";
        }
    }

}

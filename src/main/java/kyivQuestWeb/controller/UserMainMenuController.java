package kyivQuestWeb.controller;

import kyivQuestWeb.model.User;
import kyivQuestWeb.service.UserService;
import kyivQuestWeb.utils.AppUtils;
import kyivQuestWeb.utils.CookieCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserMainMenuController extends CookieCheck {

    @Autowired
    private UserService userService;

    public Boolean check(HttpServletRequest request) {
        if (AppUtils.getLoginCookie(request) == null) {
            return false;
        }
        return true;
    }

    @GetMapping(value = "/user/mainMenu")
    public String mainMenu(HttpServletRequest request, Model model){
        if (check(request)) {
            Cookie cookie = AppUtils.getLoginCookie(request);
            if (userService.findByEmail(cookie.getValue()).getRoleid() == 1) {
                User user = userService.findByEmail(cookie.getValue());
                model.addAttribute("user", user);
                return "UserMenu";
            } else {
                return "redirect:/loginOfUser";
            }
        }
        return "redirect:/start";
    }


}

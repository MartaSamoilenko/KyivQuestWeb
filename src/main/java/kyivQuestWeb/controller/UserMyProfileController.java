package kyivQuestWeb.controller;

import kyivQuestWeb.model.User;
import kyivQuestWeb.model.User2CurrentRoute;
import kyivQuestWeb.service.User2CurrentRouteService;
import kyivQuestWeb.service.UserCompletedRouteService;
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
public class UserMyProfileController extends CookieCheck {

    @Autowired
    private UserService userService;

    @Autowired
    private User2CurrentRouteService user2CurrentRouteService;

    @Autowired
    private UserCompletedRouteService userCompletedRouteService;

    public Boolean check(HttpServletRequest request) {
        if (AppUtils.getLoginCookie(request) == null) {
            return false;
        }
        return true;
    }

    @GetMapping(value = "/user/myProfile")
    public String myProfile(Model model, HttpServletRequest request){
        if (check(request)) {
            Cookie cookie = AppUtils.getLoginCookie(request);
            if (userService.findByEmail(cookie.getValue()).getRoleid() == 1) {
                User user = userService.findByEmail(cookie.getValue());
                User2CurrentRoute user2CurrentRoute = user2CurrentRouteService.findByUserId(user.getId());
                var userCompletedRoutes = userCompletedRouteService.findByUserId(user.getId());

                model.addAttribute("user", user);
                model.addAttribute("currentRoute", user2CurrentRoute);
                model.addAttribute("userCompletedRoutes", userCompletedRoutes);
                return "UserMyProfile";
            } else {
                return "redirect:/loginOfUser";
            }
        }
        return "redirect:/start";
    }
}

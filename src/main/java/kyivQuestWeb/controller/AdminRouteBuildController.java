package kyivQuestWeb.controller;

import kyivQuestWeb.model.Checkpoint;
import kyivQuestWeb.model.Route;
import kyivQuestWeb.service.CheckpointService;
import kyivQuestWeb.service.Route2CheckpointService;
import kyivQuestWeb.service.RouteService;
import kyivQuestWeb.service.UserService;
import kyivQuestWeb.utils.AppUtils;
import kyivQuestWeb.utils.CookieCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AdminRouteBuildController extends CookieCheck {

    @Autowired
    private CheckpointService checkpointService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private UserService userService;

    @Autowired
    private Route2CheckpointService route2CheckpointService;

    public Boolean check(HttpServletRequest request) {
        if (AppUtils.getLoginCookie(request) == null) {
            return false;
        }
        return true;
    }

    @GetMapping(value = "/admin/routeBuild")
    public String showMainPage(Model model, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = AppUtils.getLoginCookie(request);
        if (check(request)) {
            if (!StringUtils.isEmpty(cookie.getValue()) && !(userService.findByEmail(cookie.getValue()) == null) && (userService.findByEmail(cookie.getValue()).getRoleid() == 0)) {
                List<Checkpoint> checkpoints = checkpointService.findAll();
                model.addAttribute("checkpoints", checkpoints);
                return "AdminRouteBuild";
            } else {
                return "redirect:/loginOfUser";
            }
        }
        return "redirect:/start";
    }

    @PostMapping(value = "/admin/routeBuild")
    public String buildRoute(@ModelAttribute("routeName") String routeName, @RequestParam("checkpoints") List<String> checkpoints, Model model, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = AppUtils.getLoginCookie(request);
        if (check(request)) {
            if (!StringUtils.isEmpty(cookie.getValue()) && !(userService.findByEmail(cookie.getValue()) == null) && (userService.findByEmail(cookie.getValue()).getRoleid() == 0)) {
                System.out.println(routeName);
                for (String s : checkpoints) {
                    System.out.println(s);
                }

                Route route = new Route();
                route.setName(routeName);
                routeService.create(route);

                for (String checkpoint : checkpoints) {
                    route2CheckpointService.createWithCheckpoint(route.getId(), checkpointService.findByName(checkpoint).getId());
                }
                return "redirect:/admin/routeBuild";
            } else {
                return "redirect:/loginOfUser";
            }
        }
        return "redirect:/start";
    }
}

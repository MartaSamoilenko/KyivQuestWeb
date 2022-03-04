package kyivQuestWeb.controller;

import kyivQuestWeb.model.Checkpoint;
import kyivQuestWeb.model.Route;
import kyivQuestWeb.model.User;
import kyivQuestWeb.model.User2CurrentRoute;
import kyivQuestWeb.service.Route2CheckpointService;
import kyivQuestWeb.service.RouteService;
import kyivQuestWeb.service.User2CurrentRouteService;
import kyivQuestWeb.service.UserService;
import kyivQuestWeb.utils.AppUtils;
import kyivQuestWeb.utils.CookieCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserCurrentQuestController extends CookieCheck {

    @Autowired
    private UserService userService;

    @Autowired
    private User2CurrentRouteService user2CurrentRouteService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private Route2CheckpointService route2CheckpointService;

    public Boolean check(HttpServletRequest request) {
        if (AppUtils.getLoginCookie(request) == null) {
            return false;
        }
        return true;
    }

    @GetMapping(value = "/user/currentQuest")
    public String CurrentQuest(Model model, HttpServletRequest request){
        if (check(request)){
            Cookie cookie = AppUtils.getLoginCookie(request);
            User user = userService.findByEmail(cookie.getValue());
            User2CurrentRoute user2CurrentRoute = user2CurrentRouteService.findByUserId(user.getId());

            Route currentRoute = user2CurrentRoute.getRoute();
            List<Checkpoint> checkpointsOfCurrentRoute = route2CheckpointService.findCheckpointsByRouteId(currentRoute.getId());
            List<String> results = new ArrayList<>();

            for (Checkpoint checkpoint : checkpointsOfCurrentRoute){
                if (checkpointsOfCurrentRoute.indexOf(checkpoint) < checkpointsOfCurrentRoute.indexOf(user2CurrentRoute.getCheckpoint())){
                    results.add("achieved");
                } if (checkpointsOfCurrentRoute.indexOf(checkpoint) == checkpointsOfCurrentRoute.indexOf(user2CurrentRoute.getCheckpoint())){
                    results.add("current position");
                } else {
                    results.add("not achieved");
                }
            }


            model.addAttribute("route", currentRoute);
            model.addAttribute("checkpointsOfCurrentRoute", checkpointsOfCurrentRoute);
            model.addAttribute("result", results);


            return "UserCurrentQuestController";
        }
        return "redirect:/start";
    }
}

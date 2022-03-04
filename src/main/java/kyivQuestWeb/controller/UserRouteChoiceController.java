package kyivQuestWeb.controller;

import freemarker.template.TemplateException;
import kyivQuestWeb.model.*;
import kyivQuestWeb.service.*;
import kyivQuestWeb.utils.AppUtils;
import kyivQuestWeb.utils.CookieCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserRouteChoiceController extends CookieCheck {
    @Autowired
    UserService userService;

    @Autowired
    RouteService routeService;

    @Autowired
    CheckpointService checkpointService;

    @Autowired
    Route2CheckpointService route2CheckpointService;

    @Autowired
    User2CurrentRouteService user2CurrentRouteService;

    public Boolean check(HttpServletRequest request) {
        if (AppUtils.getLoginCookie(request) == null) {
            return false;
        }
        return true;
    }

    @GetMapping(value = "/user/routeChoice")
    public String routeChoice(Model model, HttpServletRequest request) throws IOException, TemplateException {
        if (check(request)) {
            Cookie cookie = AppUtils.getLoginCookie(request);
            if (!StringUtils.isEmpty(cookie.getValue()) && !(userService.findByEmail(cookie.getValue()) == null) && (userService.findByEmail(cookie.getValue()).getRoleid() == 1)) {
                var route2Checkpoints = route2CheckpointService.findAll();

                HashMap<Route, List<Checkpoint>> routes = new HashMap<>();

                for (Route2Checkpoint route2Checkpoint : route2Checkpoints) {
                    Route currentRoute = route2Checkpoint.getRoute();

                    if (routes.containsKey(currentRoute)) {

                        List<Checkpoint> currentRouteCheckpointList = routes.get(currentRoute);
                        currentRouteCheckpointList.add(route2Checkpoint.getCheckpoint());
                        routes.replace(currentRoute, currentRouteCheckpointList);
                    } else {
                        List<Checkpoint> currentRouteCheckpointList = new ArrayList<>();
                        currentRouteCheckpointList.add(route2Checkpoint.getCheckpoint());
                        routes.put(currentRoute, currentRouteCheckpointList);
                    }
                }

                List<Route> listOfRouteObjects = new ArrayList<>(routes.keySet());
                List<List<Checkpoint>> listOfCheckpointLists = new ArrayList<>(routes.values());

                model.addAttribute("routes", routes);
                model.addAttribute("listOfRouteObjects", listOfRouteObjects);
                model.addAttribute("listOfCheckpointLists", listOfCheckpointLists);
                return "UserRouteChoice";
            } else {
                return "redirect:/loginOfUser";
            }
        }
        return "redirect:/start";
    }

    @GetMapping(value = "/user/routeChoice/chosen")
    public String routeChosen(@ModelAttribute("route") Long routeId, HttpServletRequest request){
        if(check(request)){
            Cookie cookie = AppUtils.getLoginCookie(request);
            User user = userService.findByEmail(cookie.getValue());
            Route route = routeService.findById(routeId);
            if (user2CurrentRouteService.findByUserId(user.getId()) == null){
                User2CurrentRoute user2CurrentRoute = new User2CurrentRoute();
                LocalDateTime localDateTime = LocalDateTime.now();

                user2CurrentRoute.setCurrentuserid(user.getId());
                user2CurrentRoute.setCurrentrouteid(route.getId());
                user2CurrentRoute.setCurrentcheckpointid(route2CheckpointService.findByRouteId(route.getId()).get(0).getCheckpointid());

                user2CurrentRoute.setUser(user);
                user2CurrentRoute.setRoute(route);
                user2CurrentRoute.setCheckpoint(route2CheckpointService.findByRouteId(route.getId()).get(0).getCheckpoint());
                user2CurrentRoute.setLocalDateTime(localDateTime);

                user2CurrentRouteService.add(user2CurrentRoute);
                System.out.println("Got new Route");
                return "redirect:/user/mainMenu";
            }
            System.out.println("Finish current route!");
        }
        return "redirect:/loginOfUser";
    }
}

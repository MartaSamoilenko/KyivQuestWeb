package kyivQuestWeb.controller;

import kyivQuestWeb.model.Checkpoint;
import kyivQuestWeb.service.CheckpointService;
import kyivQuestWeb.service.UserService;
import kyivQuestWeb.utils.AppUtils;
import kyivQuestWeb.utils.CookieCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminAddCheckpointController extends CookieCheck {

    public Boolean check(HttpServletRequest request) {
        if (AppUtils.getLoginCookie(request) == null) {
            return false;
        }
        return true;
    }

    @Autowired
    private CheckpointService checkpointService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/admin/addCheckpoint")
    public String addCheckpoint(Model model, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = AppUtils.getLoginCookie(request);
        if (check(request)) {
            if (userService.findByEmail(cookie.getValue()).getRoleid() == 0) {
                var checkpoints = checkpointService.findAll();
                model.addAttribute("checkpoints", checkpoints);

                return "AdminAddCheckpoint";
            } else {
                return "redirect:/loginOfUser";
            }
        }
        return "redirect:/loginOfUser";
    }

    @PostMapping(value = "/admin/addCheckpoint")
    public String addCheckpoint(@ModelAttribute("checkpoint") Checkpoint checkpoint, HttpServletRequest request, HttpServletResponse response) {
        if (check(request)) {
            if (checkpointService.findByName(checkpoint.getName()) == null) {
                checkpointService.addCheckpoint(checkpoint);
            }
            return "redirect:/admin/addCheckpoint";
        }
        return "redirect:/loginOfUser";
    }

    @GetMapping(value = "/admin/deleteCheckpoint/{id}")
    public String deleteCheckpoint(@PathVariable Long id, HttpServletRequest request) {
        if (check(request)) {
            checkpointService.remove(id);
            return "redirect:/admin/addCheckpoint";
        }
        return "redirect:/loginOfUser";
    }
}

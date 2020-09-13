package JM.Task242.controller;

import JM.Task242.model.User;
import JM.Task242.service.UserServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private UserServiceImpl userService;


    @GetMapping(value = "/")
    public String getHomePage() {

        return "index";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }



    @GetMapping(value = "/user")
    public ModelAndView getUserPage(@AuthenticationPrincipal User user) {
        ModelAndView modelAndView = new ModelAndView("user-details");
        modelAndView.addObject("user",user);
        return modelAndView;
        //model.addAttribute("user", user);
        //return "user-details";
    }


}


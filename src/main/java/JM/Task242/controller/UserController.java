package JM.Task242.controller;

import JM.Task242.model.User;
import JM.Task242.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String getHomePage() {

        return "index";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }


    @GetMapping(value = "/user")
    public String getUserPage(Model model) {
         UserDetails user = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        User user1 = userService.getUserByName(user.getUsername());
        model.addAttribute("user", user1);
        return "user-details";
    }


}


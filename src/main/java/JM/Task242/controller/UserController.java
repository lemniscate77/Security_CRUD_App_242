package JM.Task242.controller;

import JM.Task242.model.User;
import JM.Task242.service.UserServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
    public String getUserPage(Model model) {
         User user = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        User user1 = userService.getByName(user.getUsername());
        User user2 = new User();
        user2.setId(159);
        user2.setFirstName("USER2-NAME");
        user2.setLastName("USER2-LASTNAME");
        user2.setEmail("USER2@EMAIL.EMAIL");
        user2.setPassword("USER2-PASS");
        model.addAttribute("user", user1);
        return "user-details";
    }


}


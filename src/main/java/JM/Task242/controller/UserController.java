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
    public String getUserPage(ModelMap model) {
         UserDetails user = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
         User user1 = userService.getUserByName(user.getUsername());
         model.addAttribute("name", user1.getFirstName());
         model.addAttribute("password",user1.getPassword());
//        ModelAndView modelAndView = new ModelAndView("user-details");
//        modelAndView.addObject("user",user);

        //model.addAttribute("user", user);
        return "user-details";
    }


}


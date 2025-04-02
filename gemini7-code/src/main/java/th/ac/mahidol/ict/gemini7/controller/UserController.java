package th.ac.mahidol.ict.gemini7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.ac.mahidol.ict.gemini7.model.User;
import th.ac.mahidol.ict.gemini7.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String getRegisterPage(Model model) {
        model.addAttribute("signupRequest", new User());
        return "signup-page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new User());
        return "login-page";
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        return "home-page";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        System.out.println("Signup Request: " + user);
        User signupUser = userService.signupUser(user.getName(), user.getPassword(), user.getEmail());
        if (signupUser != null) {
            return "redirect:/login";
        } else {
            System.out.println("Signup failed: already exists");
            redirectAttributes.addFlashAttribute("signupRequest", new User());
            redirectAttributes.addFlashAttribute("errorMessage", "This name or email is already registered.");
            return "redirect:/signup";
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, RedirectAttributes redirectAttributes){
        System.out.println("Login Request: " + user);
        User loginUser = userService.loginUser(user.getName(), user.getPassword());
        if(loginUser != null){
            redirectAttributes.addFlashAttribute("loginUser", loginUser.getName());
            return "redirect:/home";
        } else {
            redirectAttributes.addFlashAttribute("loginRequest", new User());
            redirectAttributes.addFlashAttribute("errorMessage", "Login failed. Please try again.");
            return "redirect:/login";
        }
    }

}

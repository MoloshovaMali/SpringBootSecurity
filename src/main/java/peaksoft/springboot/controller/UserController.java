package peaksoft.springboot.controller;

import peaksoft.springboot.entity.User;
import peaksoft.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    @GetMapping("/profile")
    public String profile(HttpServletRequest request,Model model){
        Principal principal=request.getUserPrincipal();
        User user=userRepository.getUserByName(principal.getName());
        model.addAttribute("user",user);
        return "profile";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}

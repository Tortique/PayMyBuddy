package com.paymybuddy.p6.Controller;

import com.paymybuddy.p6.DAO.UserDAO;
import com.paymybuddy.p6.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class RegisterController {

    @GetMapping("/register")
    public ModelAndView register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView registerProcess(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            UserDAO.saveUser(user);
            modelAndView.setViewName("/registerSuccess");
        return modelAndView;
    }
}

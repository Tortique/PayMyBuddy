package com.paymybuddy.p6.Controller;

import com.paymybuddy.p6.DAO.UserDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class ProfileController {
    @GetMapping("/profile")
    public ModelAndView profile() {
        return new ModelAndView("profile");
    }

}

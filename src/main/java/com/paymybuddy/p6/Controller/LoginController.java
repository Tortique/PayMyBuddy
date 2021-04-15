package com.paymybuddy.p6.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
}

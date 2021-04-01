package com.paymybuddy.p6.Controller;

import com.paymybuddy.p6.DAO.FriendsDAO;
import com.paymybuddy.p6.DAO.UserDAO;
import com.paymybuddy.p6.Database.DatabaseConfig;
import com.paymybuddy.p6.Model.Friend;
import com.paymybuddy.p6.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class MainController {
    @Autowired
    UserDAO userDAO;

    @Autowired
    FriendsDAO friendsDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(Model model, Principal principal) {
        User userLogged = userDAO.getUser(principal.getName());
        String name = userLogged.getName();
        model.addAttribute("name", name);
        String email = new String();
        model.addAttribute("email", email );
        return new ModelAndView("home");
    }

    @PostMapping("/home")
    public ModelAndView addFriend(@ModelAttribute("email") String email, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User userLogged = userDAO.getUser(principal.getName());
        User user = userDAO.getUser(email);
        Friend friend = new Friend();
        friend.setUserId(userLogged.getId());
        friend.setFriendId(user.getId());
        friendsDAO.saveFriend(friend);
        modelAndView.addObject("message", "Friend add successfully ! ");
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping(value = "/403")
    public ModelAndView error() {
        return new ModelAndView("403");
    }
}

package com.paymybuddy.p6.Controller;

import com.paymybuddy.p6.DAO.FriendsDAO;
import com.paymybuddy.p6.DAO.UserDAO;
import com.paymybuddy.p6.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class TransferController {
    @Autowired
    UserDAO userDAO;

    @Autowired
    FriendsDAO friendsDAO;

    @GetMapping("/transfer")
    public ModelAndView transfer(Principal principal, Model model) {
        User userLogged = userDAO.getUser(principal.getName());
        ArrayList<User> FriendsList;
        FriendsList = friendsDAO.getFriendsList(userLogged.getId());
        model.addAttribute("FriendsList", FriendsList);
        return new ModelAndView("transfer");
    }
}

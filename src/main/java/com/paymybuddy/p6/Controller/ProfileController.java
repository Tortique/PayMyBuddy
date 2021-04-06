package com.paymybuddy.p6.Controller;

import com.paymybuddy.p6.DAO.AccountDAO;
import com.paymybuddy.p6.DAO.UserDAO;
import com.paymybuddy.p6.Model.Account;
import com.paymybuddy.p6.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;

import static java.lang.Integer.parseInt;

@Controller
@AllArgsConstructor
public class ProfileController {
    @Autowired
    UserDAO userDAO;

    @Autowired
    AccountDAO accountDAO;

    @GetMapping("/profile")
    public ModelAndView profile(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User userLogged = userDAO.getUser(principal.getName());
        if(!accountDAO.getExistingAccount(userLogged.getId())) {
            model.addAttribute("test", false);
        } else {
            model.addAttribute("test", true);
            int balance;
            balance = accountDAO.getAccountBalance(userLogged.getId());
            model.addAttribute("balance", balance);
            String update = "";
            model.addAttribute("update", update);
        }
        modelAndView.setViewName("profile");
        return modelAndView;
    }

    @PostMapping(value = "/profile")
    public ModelAndView addAccount(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User userLogged = userDAO.getUser(principal.getName());
        Account account = new Account();
        account.setAccountId(userLogged.getId());
        account.setBalance(0);
        accountDAO.saveAccount(account);
        modelAndView.setViewName("redirect:/profile");
        return modelAndView;
    }

    @PostMapping(value = "/profile", params = "action=update")
    public ModelAndView addBalance(@ModelAttribute("update") String update, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User userLogged = userDAO.getUser(principal.getName());
        int balance = accountDAO.getAccountBalance(userLogged.getId());
        Account account = new Account();
        account.setAccountId(userLogged.getId());
        account.setBalance(balance + parseInt(update));
        accountDAO.updateBalance(account);
        modelAndView.setViewName("redirect:/profile");
        return modelAndView;
    }

}

package com.paymybuddy.p6.Controller;

import com.paymybuddy.p6.DAO.AccountDAO;
import com.paymybuddy.p6.DAO.FriendsDAO;
import com.paymybuddy.p6.DAO.TransactionDAO;
import com.paymybuddy.p6.DAO.UserDAO;
import com.paymybuddy.p6.Model.Account;
import com.paymybuddy.p6.Model.Transaction;
import com.paymybuddy.p6.Model.TransactionHistory;
import com.paymybuddy.p6.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class TransferController {
    @Autowired
    UserDAO userDAO;

    @Autowired
    FriendsDAO friendsDAO;

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    TransactionDAO transactionDAO;

    @GetMapping("/transfer")
    public ModelAndView transfer(Principal principal, Model model) {
        User userLogged = userDAO.getUser(principal.getName());
        ArrayList<User> friendsList;
        friendsList = friendsDAO.getFriendsList(userLogged.getId());
        model.addAttribute("FriendsList", friendsList);
        Transaction transaction = new Transaction();
        model.addAttribute("friend", transaction);
        ArrayList<TransactionHistory> transactions = transactionDAO.getTransactionsList(userLogged.getId());
        model.addAttribute("transactions", transactions);
        return new ModelAndView("transfer");
    }

    @RequestMapping(value = "/transfer", method = {RequestMethod.POST, RequestMethod.PUT})
    public ModelAndView transferMoney(@ModelAttribute("transaction") Transaction transaction, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User userLogged = userDAO.getUser(principal.getName());
        transaction.setTransactionUserId(userLogged.getId());
        int balance = accountDAO.getAccountBalance(userLogged.getId());
        Account userAccount = new Account();
        userAccount.setAccountId(userLogged.getId());
        userAccount.setBalance(balance - transaction.getValue());
        balance = accountDAO.getAccountBalance(transaction.getTransactionFriendId());
        Account friendAccount = new Account();
        friendAccount.setAccountId(transaction.getTransactionFriendId());
        friendAccount.setBalance(balance + transaction.getValue());
        transactionDAO.payFriend(transaction, userAccount, friendAccount);
        RedirectView redirectView = new RedirectView("/transfer");
        redirectView.setExposeModelAttributes(false);
        modelAndView.setView(redirectView);
        return modelAndView;
    }
}


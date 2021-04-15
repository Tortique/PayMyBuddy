package com.paymybuddy.p6.Controller;

import com.paymybuddy.p6.DAO.FriendsDAO;
import com.paymybuddy.p6.DAO.TransactionDAO;
import com.paymybuddy.p6.DAO.UserDAO;
import com.paymybuddy.p6.Model.Transaction;
import com.paymybuddy.p6.Model.TransactionHistory;
import com.paymybuddy.p6.Model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.security.Principal;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(TransferController.class)
public class TransferControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDAO userDAO;

    @MockBean
    private FriendsDAO friendsDAO;

    @MockBean
    private TransactionDAO transactionDAO;

    @Mock
    private Principal principal;

    @Test
    public void getTransferTest() throws Exception {
        principal = () -> "Jean";
        User user = new User(1, "Jean@gmail.com", "pass", "Jean", 1);
        ArrayList<User> friendsList = new ArrayList<>();
        friendsList.add(new User(2, "Bob@gmail.com", "pass", "Bob", 1));
        ArrayList<TransactionHistory> transactionHistories = new ArrayList<>();
        transactionHistories.add(new TransactionHistory("Bob", 100, "comment"));
        when(userDAO.getUser(anyString())).thenReturn(user);
        when(friendsDAO.getFriendsList(user.getId())).thenReturn(friendsList);
        when(transactionDAO.getTransactionsList(anyInt())).thenReturn(transactionHistories);

        ArrayList<User> expectedFriendsList = new ArrayList<>();
        expectedFriendsList.add(new User(2, "Bob@gmail.com", "pass", "Bob", 1));

        ResultMatcher list = MockMvcResultMatchers.model().attribute("FriendsList", expectedFriendsList);

        mockMvc.perform(get("/transfer").principal(principal))
                .andExpect(status().isOk())
                .andExpect(list)
                .andExpect(view().name("transfer"));
    }

    @Test
    public void postTransferMoney() throws Exception {
        principal = () -> "Jean";
        User user = new User(1, "Jean@gmail.com", "pass", "Jean", 1);
        Transaction transaction = new Transaction(1, 1, 2, 100, "hello");

        when(userDAO.getUser(anyString())).thenReturn(user);

        mockMvc.perform(post("/transfer").principal(principal).flashAttr("transaction", transaction))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/transfer"));
    }
}

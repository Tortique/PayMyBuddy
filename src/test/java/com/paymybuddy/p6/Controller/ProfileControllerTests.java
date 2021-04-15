package com.paymybuddy.p6.Controller;

import com.paymybuddy.p6.DAO.AccountDAO;
import com.paymybuddy.p6.DAO.UserDAO;
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

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(ProfileController.class)
public class ProfileControllerTests {
    @MockBean
    private UserDAO userDAO;

    @MockBean
    private AccountDAO accountDAO;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private Principal principal;

    @Test
    public void getProfileTest() throws Exception {
        principal = () -> "Jean";
        User user = new User(1, "Jean@gmail.com", "pass", "Jean", 1);
        when(userDAO.getUser(anyString())).thenReturn(user);
        when(accountDAO.getExistingAccount(anyInt())).thenReturn(true);
        when(accountDAO.getAccountBalance(anyInt())).thenReturn(100);

        ResultMatcher test = MockMvcResultMatchers.model().attribute("test", true);
        ResultMatcher balance = MockMvcResultMatchers.model().attribute("balance", 100);

        mockMvc.perform(get("/profile").principal(principal))
                .andExpect(status().isOk())
                .andExpect(test)
                .andExpect(balance)
                .andExpect(view().name("profile"));
    }

    @Test
    public void postAddAccountTest() throws Exception {
        principal = () -> "Jean";
        User user = new User(1, "Jean@gmail.com", "pass", "Jean", 1);
        when(userDAO.getUser(anyString())).thenReturn(user);

        mockMvc.perform(post("/profile").principal(principal))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/profile"));
    }

    @Test
    public void postAddBalance() throws Exception {
        principal = () -> "Jean";
        User user = new User(1, "Jean@gmail.com", "pass", "Jean", 1);
        when(userDAO.getUser(anyString())).thenReturn(user);

        mockMvc.perform(post("/profile").param("action", "update").param("update", "10")
                .principal(principal))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/profile"));
    }
}

package com.paymybuddy.p6.Controller;

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

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(MainController.class)
public class MainControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDAO userDAO;

    @Mock
    private Principal principal;

    @Test
    public void getIndexTest() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getHomeTest() throws Exception {
        principal = () -> "Jean";
        User user = new User(1, "Jean@gmail.com", "pass", "Jean", 1);

        ResultMatcher name = MockMvcResultMatchers.model().attribute("name", "Jean");

        when(userDAO.getUser(anyString())).thenReturn(user);
        mockMvc.perform(get("/home").principal(principal))
                .andExpect(status().isOk())
                .andExpect(name)
                .andExpect(view().name("home"));
    }

    @Test
    public void postAddFriend() throws Exception {
        principal = () -> "Jean";
        User user = new User(1, "Jean@gmail.com", "pass", "Jean", 1);
        when(userDAO.getUser(principal.getName())).thenReturn(user);
        User friend = new User(2, "Bob@gmail.com", "pass", "Bob", 1);
        when(userDAO.getUser(anyString())).thenReturn(friend);
        mockMvc.perform(post("/home").param("email", friend.getEmail()).principal(principal))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/home?email=Bob%40gmail.com&message=Friend+add+successfully+%21+"));
    }
}

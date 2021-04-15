package com.paymybuddy.p6.Controller;

import com.paymybuddy.p6.Model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(RegisterControllerTests.class)
public class RegisterControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRegisterTest() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    @Test
    public void getRegisterProcessTest() throws Exception {
        User user = new User(1, "Jean@gmail.com", "pass", "Jean", 1);

        mockMvc.perform(post("/register").flashAttr("user", user))
                .andExpect(status().isOk())
                .andExpect(view().name("/registerSuccess"));
    }
}

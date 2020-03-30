package com.example.BlogSpring.controller;

import com.example.BlogSpring.constants.Constants;
import com.example.BlogSpring.ui.model.request.UserDetailsRequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getUsersShouldReturnAllUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(Constants.USER_PATH))
                .andExpect(status().isOk());
    }
//    @Test
//    void createUserShouldReturnCreatedUser() throws Exception {
//        UserDetailsRequestModel userDetails = new UserDetailsRequestModel();
//        userDetails.setFirstName("TestFirstName");
//        userDetails.setLastName("TestLastName");
//        userDetails.setEmail("TestEmail");
//        userDetails.setPassword("TestPassword");
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .post(Constants.USER_PATH)
//                .content(asJsonString(userDetails))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("firstName").value(userDetails.getFirstName()))
//                .andExpect(jsonPath("lastName").value(userDetails.getLastName()))
//                .andExpect(jsonPath("email").value(userDetails.getEmail()));
//    }
//
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

}
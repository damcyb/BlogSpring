package com.example.BlogSpring.controller;


import com.example.BlogSpring.constants.Constants;
import com.example.BlogSpring.service.UserService;
import com.example.BlogSpring.shared.dto.UserDto;
import com.example.BlogSpring.ui.model.request.UserDetailsRequestModel;
import com.example.BlogSpring.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.USER_PATH)
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String getUser() {
        return "Hello world!";
    }

    @PostMapping()
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserDto userDto = new UserDto();
        UserRest returnValue = new UserRest();

        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }
}

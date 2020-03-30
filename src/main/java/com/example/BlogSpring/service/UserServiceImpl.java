package com.example.BlogSpring.service;

import com.example.BlogSpring.io.entity.UserEntity;
import com.example.BlogSpring.io.repository.UserRepository;
import com.example.BlogSpring.shared.dto.UserDto;
import com.example.BlogSpring.shared.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        if (userRepository.findUserByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Duplicated email");
        } else {
            UserDto returnValue = new UserDto();
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(user, userEntity);

            String publicUserId = utils.generateUserId(30);
            userEntity.setUserId(publicUserId);
            userEntity.setEncryptedPassword("Test");

            UserEntity storedUserDetails = userRepository.save(userEntity);
            BeanUtils.copyProperties(storedUserDetails, returnValue);
            return returnValue;
        }
    }
}

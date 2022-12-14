package com.forexservice.service;

import com.forexservice.model.User;
import com.forexservice.model.UserDto;
import com.forexservice.model.UserInfo;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);

    List<User> getAllUsers();

    User getUserById(Integer id);


    void deleteUser(Integer id);

    UserInfo getUserByName(String username);
}

package com.faraponoff.demo.dao;


import com.faraponoff.demo.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);

    User saveUser(User user, String[] roleNames);

    User updateUser(User user, String[] roleNames);

    User getUserByEmail(String username);

}

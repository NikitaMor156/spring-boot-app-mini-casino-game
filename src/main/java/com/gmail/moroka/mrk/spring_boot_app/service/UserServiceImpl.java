package com.gmail.moroka.mrk.spring_boot_app.service;

import com.gmail.moroka.mrk.spring_boot_app.dao.UserDAO;
import com.gmail.moroka.mrk.spring_boot_app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Override
    public User getUser(int id) {
       return userDAO.gerUser(id);
    }
}

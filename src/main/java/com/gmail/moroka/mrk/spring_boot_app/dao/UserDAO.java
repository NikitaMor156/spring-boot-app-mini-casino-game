package com.gmail.moroka.mrk.spring_boot_app.dao;

import com.gmail.moroka.mrk.spring_boot_app.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public void deleteUser(int id);

    public User gerUser(int id);
}

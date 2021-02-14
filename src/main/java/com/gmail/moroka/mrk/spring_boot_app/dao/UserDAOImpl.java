package com.gmail.moroka.mrk.spring_boot_app.dao;

import com.gmail.moroka.mrk.spring_boot_app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("from User");
        List<User> allUsers = query.getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        User userWithId = entityManager.merge(user);
        user.setId(userWithId.getId());
    }

    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("delete from User where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

    @Override
    public User gerUser(int id) {
        User user = entityManager.find(User.class,id);
        return user;
    }
}

package com.smith.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smith.dao.UserDAO;
import com.smith.entity.User;
import com.smith.util.HibernateUtil;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createUser(User user) {        
        return (Long) hibernateUtil.create(user);
    }
    
    @Override
    public User updateUser(User user) {        
        return hibernateUtil.update(user);
    }
    
    @Override
    public void deleteUser(long id) {
        User user = new User();
        user.setId(id);
        hibernateUtil.delete(user);
    }
    
    @Override
    public List<User> getAllUsers() {        
        return hibernateUtil.fetchAll(User.class);
    }
    
    @Override
    public User getUser(long id) {
        return hibernateUtil.fetchById(id, User.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers(String userName) { 
        String query = "SELECT e.* FROM User e WHERE e.username like '%"+ userName +"%'";
        List<Object[]> userObjects = hibernateUtil.fetchAll(query);
        List<User> users = new ArrayList<User>();
        for(Object[] userObject: userObjects) {
            User user = new User();
            long id = ((BigInteger) userObject[0]).longValue();         
            String name = (String) userObject[1];
            String email = (String) userObject[2];
            String username = (String) userObject[3];
            String phone = (String) userObject[4];
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setUsername(username);
            user.setPhone(phone);
            users.add(user);
        }
        return users;
    }
}

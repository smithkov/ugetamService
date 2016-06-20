package com.smith.service;

import java.util.List;

import com.smith.entity.User;

public interface UserService {

	public long createUser(User user);
    public User updateUser(User user);
    public void deleteUser(long id);
    public List<User> getAllUsers();
    public User getUser(long id);   
    public List<User> getAllUsers(String userName);
}

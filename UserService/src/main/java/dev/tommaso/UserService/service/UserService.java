package dev.tommaso.UserService.service;

import dev.tommaso.UserService.domain.User;

import java.util.List;

public interface UserService{
    public List<User> getAllUsers();
    public User createUser(User user);
    public void updateUser(String id, User user);
    public void deleteUserById(String id);
}

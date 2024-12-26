package dev.tommaso.UserService.service;

import dev.tommaso.UserService.domain.User;
import dev.tommaso.UserService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("User already exists");
        }
        return userRepository.save(user);
    }

    public void updateUser(String id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User doesn't exists"));
        if (existingUser.getUsername().equals(user.getUsername()) && user.getId().equals(id)) {
            throw new IllegalArgumentException("Cannot have multiple users with same username");
        }
        userRepository.save(user);
    }

    public void deleteUserById(String id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User doesn't exists");
        }
        userRepository.deleteById(id);
    }
}

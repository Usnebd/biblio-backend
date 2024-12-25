package dev.tommaso.UserService.service;

import dev.tommaso.UserService.domain.User;
import dev.tommaso.UserService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserRepository {

    @Autowired
    public UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }
}

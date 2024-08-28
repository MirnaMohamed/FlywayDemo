package com.example.flywayjpademo.service.impl;

import com.example.flywayjpademo.model.User;
import com.example.flywayjpademo.repository.UserRepository;
import com.example.flywayjpademo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException("User with id " + userId + " not found"));
    }

    @Override
    public User updateUser(int userId, User user) {

        User userObj = userRepository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException("User with id " + userId + " not found"));
        if (Objects.nonNull(user.getFirstName())
                && !"".equalsIgnoreCase(
                user.getFirstName())) {
            userObj.setFirstName(user.getFirstName());
        }

        if (Objects.nonNull(user.getLastName())
                && !"".equalsIgnoreCase(
                user.getLastName())) {
            userObj.setLastName(user.getLastName());
        }
        if (Objects.nonNull(user.getGender())
                && !"".equalsIgnoreCase(
                user.getGender().name())) {
            userObj.setGender(user.getGender());
        }
        return userRepository.save(userObj);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}

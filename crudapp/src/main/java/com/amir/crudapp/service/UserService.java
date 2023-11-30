package com.amir.crudapp.service;

import com.amir.crudapp.entity.User;
import com.amir.crudapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User getById(Long id) {
        User user =userRepository.findById(id).orElseThrow(()-> new RuntimeException("Kullanıcı bulunamadı."));
        return user;
    }
    public User updateUserById(Long id, User user) {
        Optional<User> originalUser = userRepository.findById(id);
        if (originalUser.isEmpty()){
            throw new RuntimeException("Kullanıcı bulunamadı.");
        }
        user.setId(id);
        userRepository.save(user);
        return getById(id);
    }
    public User deleteUserById(Long id) {
        User user = getById(id);
        userRepository.deleteById(id);
        return user;
    }
}

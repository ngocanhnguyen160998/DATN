package com.service.impl;

import com.model.Product;
import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateById(Long id, User user) {
        User tmp = userRepository.findById(id).get();
        if (tmp == null) {
            return null;
        }
        tmp.setUserName(user.getUserName());
        tmp.setPassword(user.getPassword());
        tmp.setFullName(user.getFullName());
        tmp.setPhone(user.getPhone());
        tmp.setEmail(user.getEmail());
        tmp.setRoleId(user.getRoleId());
        return userRepository.save(tmp);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }
}

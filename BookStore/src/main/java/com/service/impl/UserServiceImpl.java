package com.service.impl;

import com.model.Product;
import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;
import com.util.PasswordHasher;
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
        if (!tmp.getPassword().equals(user.getPassword())) {
            tmp.setPassword(PasswordHasher.hash(user.getPassword()));
        }
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
        user.setPassword(PasswordHasher.hash(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Long count() {
        return userRepository.count();
    }

    @Override
    public Long countByUserNameLike(String userName) {
        return userRepository.countByUserNameLike(userName);
    }

    @Override
    public Optional<User> getByUserNameAndPassword(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }

    @Override
    public Optional<User> getByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}

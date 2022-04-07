package com.service;

import com.model.Product;
import com.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    Optional<User> getById(Long id);

    Product updateById(Long id, User user);

    void deleteById(Long id);

    User insert(User user);

}

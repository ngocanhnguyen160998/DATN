package com.service;

import com.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAll();

    Optional<Role> getById(Long id);
}

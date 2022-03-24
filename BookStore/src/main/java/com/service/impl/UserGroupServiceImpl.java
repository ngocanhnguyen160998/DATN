package com.service.impl;

import com.repository.UserGroupRepository;
import com.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGroupServiceImpl implements UserGroupService {
    @Autowired
    private UserGroupRepository userGroupRepository;
}

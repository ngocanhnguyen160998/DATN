package com.service.impl;

import com.repository.WardRepository;
import com.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WardServiceImpl implements WardService {
    @Autowired
    private WardRepository wardRepository;

}

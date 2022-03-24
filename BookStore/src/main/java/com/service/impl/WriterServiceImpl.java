package com.service.impl;

import com.repository.WriterRepository;
import com.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriterServiceImpl implements WriterService {
    @Autowired
    private WriterRepository writerRepository;
}

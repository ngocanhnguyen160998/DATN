package com.service;

import java.util.Map;

public interface DistrictService {
    Map<String, String> findById(String provinceId);

    Map<String, String> findAll();
}

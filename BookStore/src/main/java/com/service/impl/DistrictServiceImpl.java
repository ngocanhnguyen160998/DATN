package com.service.impl;

import com.model.District;
import com.repository.DistrictRepository;
import com.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public Map<String, String> findById(String provinceId) {
        List<District> districts = districtRepository.findAllByProvinceId(provinceId);
        Map<String, String> stringMap = new HashMap<>();
        for (District district : districts) {
            stringMap.put(district.getId(),district.getName());
        }
        return stringMap;
    }

    @Override
    public Map<String, String> findAll() {
        List<District> districts = districtRepository.findAll();
        Map<String, String> stringMap = new HashMap<>();
        for (District district : districts
        ) {
            stringMap.put(district.getId(),district.getName());
        }
        return stringMap;
    }
}

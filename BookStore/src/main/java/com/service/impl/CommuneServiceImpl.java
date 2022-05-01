package com.service.impl;

import com.model.Commune;
import com.repository.CommuneRepository;
import com.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommuneServiceImpl implements CommuneService {

    @Autowired
    private CommuneRepository communeRepository;

    @Override
    public Map<String, String> findAllByDistrictId(String districtId) {
        List<Commune> communes = communeRepository.findAllByDistrictId(districtId);
        Map<String, String> stringMap = new HashMap<>();
        for (Commune commune : communes) {
            stringMap.put(commune.getId(), commune.getName());
        }
        return stringMap;
    }

    @Override
    public Map<String, String> findAll() {
        List<Commune> wards = communeRepository.findAll();
        Map<String, String> stringMap = new HashMap<>();
        for (Commune ward : wards
        ) {
            stringMap.put(ward.getId(),ward.getName());
        }
        return stringMap;
    }

    @Override
    public Commune findByTransportFee(String id) {
        return communeRepository.findOneById(id);
    }
}

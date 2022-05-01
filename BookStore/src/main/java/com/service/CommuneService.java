package com.service;

import com.model.Commune;

import java.util.Map;

public interface CommuneService {
    Map<String, String> findAllByDistrictId(String districtId);

    Map<String, String> findAll();

    Commune findByTransportFee(String id);
}

package com.repository;

import com.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {
    @Query("select e from District e where e.province.id = :provinceId order by e.name asc")
    List<District> findAllByProvinceId(@Param("provinceId") String provinceId);
}

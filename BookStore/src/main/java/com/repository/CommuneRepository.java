package com.repository;

import com.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, String> {
    @Query("select c from Commune c where c.district.id = :districtId")
    List<Commune> findAllByDistrictId(@Param("districtId") String districtId);

    Commune findOneById(String id);
}

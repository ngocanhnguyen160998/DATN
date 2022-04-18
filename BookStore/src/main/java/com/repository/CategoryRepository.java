package com.repository;

import com.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT COUNT(c.id) FROM CATEGORY c WHERE name LIKE %:name%", nativeQuery = true)
    Long countByNameLike(@Param("name") String name);
}

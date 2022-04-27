package com.repository;

import com.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);


    @Query(value = "SELECT COUNT(u.id) FROM USER u WHERE user_name LIKE %:userName%", nativeQuery = true)
    Long countByUserNameLike(@Param("userName") String userName);

    Optional<User> findByUserNameAndPassword(String userName, String password);
}

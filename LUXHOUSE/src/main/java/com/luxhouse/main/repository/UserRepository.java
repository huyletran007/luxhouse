package com.luxhouse.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luxhouse.main.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
//    @Query("SELECT u FROM Users u WHERE u.username = ?1")
//    Users findByUsername(String username);
    
//  @Query("SELECT u FROM Users u WHERE u.username = ?1")
//  Users updateFullname(String username);

    Optional<Users> findByEmail(String email);

    Optional<Users> findByUsernameOrEmail(String username, String email);

    Optional<Users> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
    Boolean existsByPhone(String phone);
    
    
    
}

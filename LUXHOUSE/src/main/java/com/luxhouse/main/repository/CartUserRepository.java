package com.luxhouse.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luxhouse.main.domain.CartUsers;

public interface CartUserRepository extends JpaRepository<CartUsers, Long> {

    @Query("SELECT u FROM CartUsers u WHERE u.users.id = ?1")
    List<CartUsers> findByUserId(Long id);
}

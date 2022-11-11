package com.luxhouse.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luxhouse.main.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
@Query("SELECT u FROM Users u WHERE u.username = ?1")
	Users findByUsername(String username);

}

package com.luxhouse.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxhouse.main.domain.Users;

public interface AccountRepository extends JpaRepository<Users, Long> {

}

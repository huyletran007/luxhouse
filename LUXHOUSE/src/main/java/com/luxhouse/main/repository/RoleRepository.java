package com.luxhouse.main.repository;

import com.luxhouse.main.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import javax.management.relation.Role;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {
    
    Optional<Roles> findByName(String name);

}

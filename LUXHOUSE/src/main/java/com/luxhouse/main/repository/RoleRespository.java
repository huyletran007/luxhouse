package com.luxhouse.main.repository;

import com.luxhouse.main.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.management.relation.Role;

@Repository
public interface RoleRespository extends JpaRepository<Roles,Integer> {

}

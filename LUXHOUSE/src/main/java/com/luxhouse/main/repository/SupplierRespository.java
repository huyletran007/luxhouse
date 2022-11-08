package com.luxhouse.main.repository;

import com.luxhouse.main.domain.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface SupplierRespository extends JpaRepository<Suppliers,Integer> {

}

package com.luxhouse.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luxhouse.main.domain.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

}

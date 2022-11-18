package com.luxhouse.main.repository;

import com.luxhouse.main.domain.CategoryProducts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProducts,Integer> {
    
    @Query("SELECT c FROM CategoryProducts c")
    List<CategoryProducts> selectByCategoryId();
}

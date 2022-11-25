package com.luxhouse.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luxhouse.main.domain.Orders;
import com.luxhouse.main.domain.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    @Query("SELECT o FROM Products o WHERE o.productName like %?1%")
    List<Products> selectsByProductName(String name);
    
    @Query("SELECT o FROM Products o WHERE o.categoryProducts.categoryProductCode like ?1")
    List<Products> selectsByCategoryProductCode(String code);
    
    @Query("SELECT o FROM Products o WHERE o.categoryProducts.categories.categoryCode like ?1")
    List<Products> selectsByCategoryMCode(String code);
}

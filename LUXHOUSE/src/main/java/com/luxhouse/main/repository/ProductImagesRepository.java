package com.luxhouse.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luxhouse.main.domain.ProductImages;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Long>{
    @Query("SELECT p FROM ProductImages p WHERE p.products.id = ?1")
    List<ProductImages> selectsByProductId(Long id);
    
}

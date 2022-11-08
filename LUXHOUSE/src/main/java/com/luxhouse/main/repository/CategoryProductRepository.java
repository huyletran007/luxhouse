package com.luxhouse.main.repository;

import com.luxhouse.main.domain.CategoryProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProducts,Integer> {
}

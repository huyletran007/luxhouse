package com.luxhouse.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luxhouse.main.domain.ProductReviews;
import com.luxhouse.main.domain.Products;

@Repository
public interface ProductReviewsRepository extends JpaRepository<ProductReviews, Long>{

}

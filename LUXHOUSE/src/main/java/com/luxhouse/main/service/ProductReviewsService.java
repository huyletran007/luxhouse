package com.luxhouse.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.luxhouse.main.domain.ProductReviews;
import com.luxhouse.main.domain.Products;

public interface ProductReviewsService {

    void deleteAll();

    void deleteAll(Iterable<? extends ProductReviews> entities);

    void delete(ProductReviews entity);

    <S extends ProductReviews> List<S> findAll(Example<S> example, Sort sort);

    void deleteById(Long id);

    long count();

    <S extends ProductReviews> List<S> findAll(Example<S> example);

    <S extends ProductReviews> boolean exists(Example<S> example);

    <S extends ProductReviews> long count(Example<S> example);

    ProductReviews getOne(Long id);

    void deleteAllInBatch();

    <S extends ProductReviews> Page<S> findAll(Example<S> example, Pageable pageable);

    void deleteInBatch(Iterable<ProductReviews> entities);

    boolean existsById(Long id);

    <S extends ProductReviews> S saveAndFlush(S entity);

    void flush();

    Optional<ProductReviews> findById(Long id);

    <S extends ProductReviews> List<S> saveAll(Iterable<S> entities);

    List<ProductReviews> findAllById(Iterable<Long> ids);

    List<ProductReviews> findAll(Sort sort);

    List<ProductReviews> findAll();

    Page<ProductReviews> findAll(Pageable pageable);

    <S extends ProductReviews> Optional<S> findOne(Example<S> example);

    <S extends ProductReviews> S save(S entity);

   
}

package com.luxhouse.main.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import com.luxhouse.main.domain.ProductImages;


public interface ProductImagesService {

    void deleteAll();

    void deleteAll(Iterable<? extends ProductImages> entities);

    void delete(ProductImages entity);

    <S extends ProductImages> List<S> findAll(Example<S> example, Sort sort);

    void deleteById(Long id);

    long count();

    <S extends ProductImages> List<S> findAll(Example<S> example);

    <S extends ProductImages> boolean exists(Example<S> example);

    <S extends ProductImages> long count(Example<S> example);

    ProductImages getOne(Long id);

    void deleteAllInBatch();

    <S extends ProductImages> Page<S> findAll(Example<S> example, Pageable pageable);

    void deleteInBatch(Iterable<ProductImages> entities);

    boolean existsById(Long id);

    <S extends ProductImages> S saveAndFlush(S entity);

    void flush();

    Optional<ProductImages> findById(Long id);

    <S extends ProductImages> List<S> saveAll(Iterable<S> entities);

    List<ProductImages> findAllById(Iterable<Long> ids);

    List<ProductImages> findAll(Sort sort);

    List<ProductImages> findAll();

    Page<ProductImages> findAll(Pageable pageable);

    <S extends ProductImages> Optional<S> findOne(Example<S> example);

    <S extends ProductImages> S save(S entity);

    List<ProductImages> selectsByProductId(Long id);

}

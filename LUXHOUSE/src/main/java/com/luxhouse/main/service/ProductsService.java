package com.luxhouse.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.luxhouse.main.domain.Orders;
import com.luxhouse.main.domain.Products;

public interface ProductsService {

    void deleteAll();

    void deleteAll(Iterable<? extends Products> entities);

    void delete(Products entity);

    <S extends Products> List<S> findAll(Example<S> example, Sort sort);

    void deleteById(Long id);

    long count();

    <S extends Products> List<S> findAll(Example<S> example);

    <S extends Products> boolean exists(Example<S> example);

    <S extends Products> long count(Example<S> example);

    Products getOne(Long id);

    void deleteAllInBatch();

    <S extends Products> Page<S> findAll(Example<S> example, Pageable pageable);

    void deleteInBatch(Iterable<Products> entities);

    boolean existsById(Long id);

    <S extends Products> S saveAndFlush(S entity);

    void flush();

    Optional<Products> findById(Long id);

    <S extends Products> List<S> saveAll(Iterable<S> entities);

    List<Products> findAllById(Iterable<Long> ids);

    List<Products> findAll(Sort sort);

    List<Products> findAll();

    Page<Products> findAll(Pageable pageable);

    <S extends Products> Optional<S> findOne(Example<S> example);

    <S extends Products> S save(S entity);
    
    List<Products> selectsByProductName(String name);
    
    List<Products> selectsByCategoryProductCode(String code);
    
    List<Products> selectsByCategoryMCode(String code);

}

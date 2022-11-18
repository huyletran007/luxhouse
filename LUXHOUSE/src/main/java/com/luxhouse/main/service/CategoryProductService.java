package com.luxhouse.main.service;

import com.luxhouse.main.domain.CategoryProducts;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CategoryProductService {

    List<CategoryProducts> findAll();

    List<CategoryProducts> findAll(Sort sort);

    List<CategoryProducts> findAllById(Iterable<Integer> iterable);

    <S extends CategoryProducts> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends CategoryProducts> S saveAndFlush(S s);

    void deleteInBatch(Iterable<CategoryProducts> iterable);

    void deleteAllInBatch();

    CategoryProducts getOne(Integer id);

    <S extends CategoryProducts> List<S> findAll(Example<S> example);

    <S extends CategoryProducts> List<S> findAll(Example<S> example, Sort sort);

    Page<CategoryProducts> findAll(Pageable pageable);

    <S extends CategoryProducts> S save(S s);

    Optional<CategoryProducts> findById(Integer id);
    
    List<CategoryProducts> selectByCategoryId();

    boolean existsById(Integer id);

    long count();

    void deleteById(Integer id);

    void delete(CategoryProducts categoryProducts);

    void deleteAll(Iterable<? extends CategoryProducts> iterable);

    void deleteAll();

    <S extends CategoryProducts> Optional<S> findOne(Example<S> example);

    <S extends CategoryProducts> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends CategoryProducts> long count(Example<S> example);

    <S extends CategoryProducts> boolean exists(Example<S> example);

}

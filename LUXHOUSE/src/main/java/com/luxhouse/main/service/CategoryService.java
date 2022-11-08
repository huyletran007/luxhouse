package com.luxhouse.main.service;

import com.luxhouse.main.domain.Categories;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CategoryService {


    List<Categories> findAll();

    List<Categories> findAll(Sort sort);

    List<Categories> findAllById(Iterable<Integer> iterable);

    <S extends Categories> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends Categories> S saveAndFlush(S s);

    void deleteInBatch(Iterable<Categories> iterable);

    void deleteAllInBatch();

    Categories getOne(Integer id);

    <S extends Categories> List<S> findAll(Example<S> example);

    <S extends Categories> List<S> findAll(Example<S> example, Sort sort);

    Page<Categories> findAll(Pageable pageable);

    <S extends Categories> S save(S s);

    Optional<Categories> findById(Integer id);

    boolean existsById(Integer id);

    long count();

    void deleteById(Integer id);

    void delete(Categories categories);

    void deleteAll(Iterable<? extends Categories> iterable);

    void deleteAll();

    <S extends Categories> Optional<S> findOne(Example<S> example);

    <S extends Categories> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Categories> long count(Example<S> example);

    <S extends Categories> boolean exists(Example<S> example);
}

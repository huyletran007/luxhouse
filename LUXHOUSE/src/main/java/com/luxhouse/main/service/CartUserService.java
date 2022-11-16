package com.luxhouse.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.luxhouse.main.domain.CartUsers;

public interface CartUserService {

    void deleteAll();

    void deleteAll(Iterable<? extends CartUsers> entities);

    void delete(CartUsers entity);

    <S extends CartUsers> List<S> findAll(Example<S> example, Sort sort);

    void deleteById(Long id);

    long count();

    <S extends CartUsers> List<S> findAll(Example<S> example);

    <S extends CartUsers> boolean exists(Example<S> example);

    <S extends CartUsers> long count(Example<S> example);

    CartUsers getOne(Long id);

    void deleteAllInBatch();

    <S extends CartUsers> Page<S> findAll(Example<S> example, Pageable pageable);

    void deleteInBatch(Iterable<CartUsers> entities);

    boolean existsById(Long id);

    <S extends CartUsers> S saveAndFlush(S entity);

    void flush();

    Optional<CartUsers> findById(Long id);
    
    List<CartUsers> findByUserId(Long id);

    <S extends CartUsers> List<S> saveAll(Iterable<S> entities);

    List<CartUsers> findAllById(Iterable<Long> ids);

    List<CartUsers> findAll(Sort sort);

    List<CartUsers> findAll();

    Page<CartUsers> findAll(Pageable pageable);

    <S extends CartUsers> Optional<S> findOne(Example<S> example);

    <S extends CartUsers> S save(S entity);
}

package com.luxhouse.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.luxhouse.main.domain.Products;
import com.luxhouse.main.domain.Users;
import com.luxhouse.main.exception.NotFoundEx;

public interface UserService {

    void deleteAll();

    void deleteAll(Iterable<? extends Users> entities);

    void delete(Users entity);

    <S extends Users> List<S> findAll(Example<S> example, Sort sort);

    void deleteById(Long id);

    long count();

    <S extends Users> List<S> findAll(Example<S> example);

    <S extends Users> boolean exists(Example<S> example);

    <S extends Users> long count(Example<S> example);

    Users getOne(Long id);

    void deleteAllInBatch();

    <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable);

    void deleteInBatch(Iterable<Users> entities);

    boolean existsById(Long id);

    <S extends Users> S saveAndFlush(S entity);

    void flush();
    
    Optional<Users> findById(Long id);
    
    Optional<Users> findByUsername(String username);
    
    Optional<Users> findByEmail(String email);

    <S extends Users> List<S> saveAll(Iterable<S> entities);

    List<Users> findAllById(Iterable<Long> ids);

    List<Users> findAll(Sort sort);

    List<Users> findAll();

    Page<Users> findAll(Pageable pageable);

    <S extends Users> Optional<S> findOne(Example<S> example);

    <S extends Users> S save(S entity);
    
    boolean partialUpdate(Long id, String key, String value)throws NotFoundEx;
    
}

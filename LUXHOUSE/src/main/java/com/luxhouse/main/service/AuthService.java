package com.luxhouse.main.service;

import com.luxhouse.main.domain.Authorities;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface AuthService {


    List<Authorities> findAll();

    List<Authorities> findAll(Sort sort);

    List<Authorities> findAllById(Iterable<Long> iterable);

    <S extends Authorities> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends Authorities> S saveAndFlush(S s);

    void deleteInBatch(Iterable<Authorities> iterable);

    void deleteAllInBatch();

    Authorities getOne(Long id);

    <S extends Authorities> List<S> findAll(Example<S> example);

    <S extends Authorities> List<S> findAll(Example<S> example, Sort sort);

    Page<Authorities> findAll(Pageable pageable);

    <S extends Authorities> S save(S s);

    Optional<Authorities> findById(Long id);

    boolean existsById(Long id);

    long count();

    void deleteById(Long id);

    void delete(Authorities authorities);

    void deleteAll(Iterable<? extends Authorities> iterable);

    void deleteAll();

    <S extends Authorities> Optional<S> findOne(Example<S> example);

    <S extends Authorities> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Authorities> long count(Example<S> example);

    <S extends Authorities> boolean exists(Example<S> example);
}

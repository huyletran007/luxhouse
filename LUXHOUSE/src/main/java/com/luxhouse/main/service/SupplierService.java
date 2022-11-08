package com.luxhouse.main.service;

import com.luxhouse.main.domain.Suppliers;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

public interface SupplierService {


    List<Suppliers> findAll();

    List<Suppliers> findAll(Sort sort);

    List<Suppliers> findAllById(Iterable<Integer> iterable);

    <S extends Suppliers> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends Suppliers> S saveAndFlush(S s);

    void deleteInBatch(Iterable<Suppliers> iterable);

    void deleteAllInBatch();

    Suppliers getOne(Integer integer);

    <S extends Suppliers> List<S> findAll(Example<S> example);

    <S extends Suppliers> List<S> findAll(Example<S> example, Sort sort);

    Page<Suppliers> findAll(Pageable pageable);

    <S extends Suppliers> S save(S s);

    Optional<Suppliers> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(Suppliers suppliers);

    void deleteAll(Iterable<? extends Suppliers> iterable);

    void deleteAll();

    <S extends Suppliers> Optional<S> findOne(Example<S> example);

    <S extends Suppliers> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Suppliers> long count(Example<S> example);

    <S extends Suppliers> boolean exists(Example<S> example);
}

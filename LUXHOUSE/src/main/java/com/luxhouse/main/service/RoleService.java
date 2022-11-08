package com.luxhouse.main.service;

import com.luxhouse.main.domain.Roles;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

public interface RoleService {


    List<Roles> findAll();

    List<Roles> findAll(Sort sort);

    List<Roles> findAllById(Iterable<Integer> iterable);

    <S extends Roles> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends Roles> S saveAndFlush(S s);

    void deleteInBatch(Iterable<Roles> iterable);

    void deleteAllInBatch();

    Roles getOne(Integer integer);

    <S extends Roles> List<S> findAll(Example<S> example);

    <S extends Roles> List<S> findAll(Example<S> example, Sort sort);

    Page<Roles> findAll(Pageable pageable);

    <S extends Roles> S save(S s);

    Optional<Roles> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(Roles roles);

    void deleteAll(Iterable<? extends Roles> iterable);

    void deleteAll();

    <S extends Roles> Optional<S> findOne(Example<S> example);

    <S extends Roles> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Roles> long count(Example<S> example);

    <S extends Roles> boolean exists(Example<S> example);
}

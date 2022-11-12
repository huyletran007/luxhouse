package com.luxhouse.main.service.impl;


import com.luxhouse.main.domain.Roles;
import com.luxhouse.main.repository.RoleRepository;
import com.luxhouse.main.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRespository;

    @Override
    public List<Roles> findAll() {
        return roleRespository.findAll();
    }

    @Override
    public List<Roles> findAll(Sort sort) {
        return roleRespository.findAll(sort);
    }

    @Override
    public List<Roles> findAllById(Iterable<Integer> iterable) {
        return roleRespository.findAllById(iterable);
    }

    @Override
    public <S extends Roles> List<S> saveAll(Iterable<S> iterable) {
        return roleRespository.saveAll(iterable);
    }

    @Override
    public void flush() {
        roleRespository.flush();
    }

    @Override
    public <S extends Roles> S saveAndFlush(S s) {
        return roleRespository.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Roles> iterable) {
        roleRespository.deleteInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        roleRespository.deleteAllInBatch();
    }

    @Override
    public Roles getOne(Integer integer) {
        return roleRespository.getOne(integer);
    }

    @Override
    public <S extends Roles> List<S> findAll(Example<S> example) {
        return roleRespository.findAll(example);
    }

    @Override
    public <S extends Roles> List<S> findAll(Example<S> example, Sort sort) {
        return roleRespository.findAll(example, sort);
    }

    @Override
    public Page<Roles> findAll(Pageable pageable) {
        return roleRespository.findAll(pageable);
    }

    @Override
    public <S extends Roles> S save(S s) {
        return roleRespository.save(s);
    }

    @Override
    public Optional<Roles> findById(Integer integer) {
        return roleRespository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return roleRespository.existsById(integer);
    }

    @Override
    public long count() {
        return roleRespository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        roleRespository.deleteById(integer);
    }

    @Override
    public void delete(Roles roles) {
        roleRespository.delete(roles);
    }

    @Override
    public void deleteAll(Iterable<? extends Roles> iterable) {
        roleRespository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        roleRespository.deleteAll();
    }

    @Override
    public <S extends Roles> Optional<S> findOne(Example<S> example) {
        return roleRespository.findOne(example);
    }

    @Override
    public <S extends Roles> Page<S> findAll(Example<S> example, Pageable pageable) {
        return roleRespository.findAll(example, pageable);
    }

    @Override
    public <S extends Roles> long count(Example<S> example) {
        return roleRespository.count(example);
    }

    @Override
    public <S extends Roles> boolean exists(Example<S> example) {
        return roleRespository.exists(example);
    }
}

package com.luxhouse.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.luxhouse.main.domain.Users;
import com.luxhouse.main.repository.UserRepository;
import com.luxhouse.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{
 
    @Autowired
    UserRepository userRepository;

    @Override
    public <S extends Users> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public <S extends Users> Optional<S> findOne(Example<S> example) {
        return userRepository.findOne(example);
    }

    @Override
    public Page<Users> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Users> findAll(Sort sort) {
        return userRepository.findAll(sort);
    }

    @Override
    public List<Users> findAllById(Iterable<Long> ids) {
        return userRepository.findAllById(ids);
    }

    @Override
    public <S extends Users> List<S> saveAll(Iterable<S> entities) {
        return userRepository.saveAll(entities);
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void flush() {
        userRepository.flush();
    }

    @Override
    public <S extends Users> S saveAndFlush(S entity) {
        return userRepository.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public void deleteInBatch(Iterable<Users> entities) {
        userRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable) {
        return userRepository.findAll(example, pageable);
    }

    @Override
    public void deleteAllInBatch() {
        userRepository.deleteAllInBatch();
    }

    @Override
    public Users getOne(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public <S extends Users> long count(Example<S> example) {
        return userRepository.count(example);
    }

    @Override
    public <S extends Users> boolean exists(Example<S> example) {
        return userRepository.exists(example);
    }

    @Override
    public <S extends Users> List<S> findAll(Example<S> example) {
        return userRepository.findAll(example);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public <S extends Users> List<S> findAll(Example<S> example, Sort sort) {
        return userRepository.findAll(example, sort);
    }

    @Override
    public void delete(Users entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends Users> entities) {
        userRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
    
}
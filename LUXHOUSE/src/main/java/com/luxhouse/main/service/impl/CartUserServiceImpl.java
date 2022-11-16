package com.luxhouse.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.luxhouse.main.domain.CartUsers;
import com.luxhouse.main.repository.CartUserRepository;
import com.luxhouse.main.service.CartUserService;

@Service
public class CartUserServiceImpl implements CartUserService {
    @Autowired
    CartUserRepository cartUserRepository;

    @Override
    public <S extends CartUsers> S save(S entity) {
        return cartUserRepository.save(entity);
    }

    @Override
    public <S extends CartUsers> Optional<S> findOne(Example<S> example) {
        return cartUserRepository.findOne(example);
    }

    @Override
    public Page<CartUsers> findAll(Pageable pageable) {
        return cartUserRepository.findAll(pageable);
    }

    @Override
    public List<CartUsers> findAll() {
        return cartUserRepository.findAll();
    }

    @Override
    public List<CartUsers> findAll(Sort sort) {
        return cartUserRepository.findAll(sort);
    }

    @Override
    public List<CartUsers> findAllById(Iterable<Long> ids) {
        return cartUserRepository.findAllById(ids);
    }

    @Override
    public <S extends CartUsers> List<S> saveAll(Iterable<S> entities) {
        return cartUserRepository.saveAll(entities);
    }

    @Override
    public Optional<CartUsers> findById(Long id) {
        return cartUserRepository.findById(id);
    }

    @Override
    public void flush() {
        cartUserRepository.flush();
    }

    @Override
    public <S extends CartUsers> S saveAndFlush(S entity) {
        return cartUserRepository.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return cartUserRepository.existsById(id);
    }

    @Override
    public void deleteInBatch(Iterable<CartUsers> entities) {
        cartUserRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends CartUsers> Page<S> findAll(Example<S> example, Pageable pageable) {
        return cartUserRepository.findAll(example, pageable);
    }

    @Override
    public void deleteAllInBatch() {
        cartUserRepository.deleteAllInBatch();
    }

    @Override
    public CartUsers getOne(Long id) {
        return cartUserRepository.getOne(id);
    }

    @Override
    public <S extends CartUsers> long count(Example<S> example) {
        return cartUserRepository.count(example);
    }

    @Override
    public <S extends CartUsers> boolean exists(Example<S> example) {
        return cartUserRepository.exists(example);
    }

    @Override
    public <S extends CartUsers> List<S> findAll(Example<S> example) {
        return cartUserRepository.findAll(example);
    }

    @Override
    public long count() {
        return cartUserRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        cartUserRepository.deleteById(id);
    }

    @Override
    public <S extends CartUsers> List<S> findAll(Example<S> example, Sort sort) {
        return cartUserRepository.findAll(example, sort);
    }

    @Override
    public void delete(CartUsers entity) {
        cartUserRepository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends CartUsers> entities) {
        cartUserRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        cartUserRepository.deleteAll();
    }

    @Override
    public List<CartUsers> findByUserId(Long id) {
        // TODO Auto-generated method stub
        return cartUserRepository.findByUserId(id);
    }

}

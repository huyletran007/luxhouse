package com.luxhouse.main.service.impl;

import com.luxhouse.main.domain.Authorities;
import com.luxhouse.main.repository.AuthRepository;
import com.luxhouse.main.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthRepository authRepository;

    @Override
    public List<Authorities> findAll() {
        return authRepository.findAll();
    }

    @Override
    public List<Authorities> findAll(Sort sort) {
        return authRepository.findAll(sort);
    }

    @Override
    public List<Authorities> findAllById(Iterable<Long> iterable) {
        return authRepository.findAllById(iterable);
    }

    @Override
    public <S extends Authorities> List<S> saveAll(Iterable<S> iterable) {
        return authRepository.saveAll(iterable);
    }

    @Override
    public void flush() {
        authRepository.flush();
    }

    @Override
    public <S extends Authorities> S saveAndFlush(S s) {
        return authRepository.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Authorities> iterable) {
        authRepository.deleteInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        authRepository.deleteAllInBatch();
    }

    @Override
    public Authorities getOne(Long id) {
        return authRepository.getOne(id);
    }

    @Override
    public <S extends Authorities> List<S> findAll(Example<S> example) {
        return authRepository.findAll(example);
    }

    @Override
    public <S extends Authorities> List<S> findAll(Example<S> example, Sort sort) {
        return authRepository.findAll(example, sort);
    }

    @Override
    public Page<Authorities> findAll(Pageable pageable) {
        return authRepository.findAll(pageable);
    }

    @Override
    public <S extends Authorities> S save(S s) {
        return authRepository.save(s);
    }

    @Override
    public Optional<Authorities> findById(Long id) {
        return authRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return authRepository.existsById(id);
    }

    @Override
    public long count() {
        return authRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        authRepository.deleteById(id);
    }

    @Override
    public void delete(Authorities authorities) {
        authRepository.delete(authorities);
    }

    @Override
    public void deleteAll(Iterable<? extends Authorities> iterable) {
        authRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        authRepository.deleteAll();
    }

    @Override
    public <S extends Authorities> Optional<S> findOne(Example<S> example) {
        return authRepository.findOne(example);
    }

    @Override
    public <S extends Authorities> Page<S> findAll(Example<S> example, Pageable pageable) {
        return authRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Authorities> long count(Example<S> example) {
        return authRepository.count(example);
    }

    @Override
    public <S extends Authorities> boolean exists(Example<S> example) {
        return authRepository.exists(example);
    }
}

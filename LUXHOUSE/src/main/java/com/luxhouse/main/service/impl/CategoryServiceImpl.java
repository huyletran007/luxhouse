package com.luxhouse.main.service.impl;

import com.luxhouse.main.domain.Categories;
import com.luxhouse.main.repository.CategoryRepository;
import com.luxhouse.main.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Categories> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Categories> findAll(Sort sort) {
        return categoryRepository.findAll(sort);
    }

    @Override
    public List<Categories> findAllById(Iterable<Integer> iterable) {
        return categoryRepository.findAllById(iterable);
    }

    @Override
    public <S extends Categories> List<S> saveAll(Iterable<S> iterable) {
        return categoryRepository.saveAll(iterable);
    }

    @Override
    public void flush() {
        categoryRepository.flush();
    }

    @Override
    public <S extends Categories> S saveAndFlush(S s) {
        return categoryRepository.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Categories> iterable) {
        categoryRepository.deleteInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        categoryRepository.deleteAllInBatch();
    }

    @Override
    public Categories getOne(Integer integer) {
        return categoryRepository.getOne(integer);
    }

    @Override
    public <S extends Categories> List<S> findAll(Example<S> example) {
        return categoryRepository.findAll(example);
    }

    @Override
    public <S extends Categories> List<S> findAll(Example<S> example, Sort sort) {
        return categoryRepository.findAll(example, sort);
    }

    @Override
    public Page<Categories> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public <S extends Categories> S save(S s) {
        return categoryRepository.save(s);
    }

    @Override
    public Optional<Categories> findById(Integer integer) {
        return categoryRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return categoryRepository.existsById(integer);
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        categoryRepository.deleteById(integer);
    }

    @Override
    public void delete(Categories categories) {
        categoryRepository.delete(categories);
    }

    @Override
    public void deleteAll(Iterable<? extends Categories> iterable) {
        categoryRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    public <S extends Categories> Optional<S> findOne(Example<S> example) {
        return categoryRepository.findOne(example);
    }

    @Override
    public <S extends Categories> Page<S> findAll(Example<S> example, Pageable pageable) {
        return categoryRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Categories> long count(Example<S> example) {
        return categoryRepository.count(example);
    }

    @Override
    public <S extends Categories> boolean exists(Example<S> example) {
        return categoryRepository.exists(example);
    }
}

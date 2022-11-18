package com.luxhouse.main.service.impl;

import com.luxhouse.main.domain.CategoryProducts;
import com.luxhouse.main.repository.CategoryProductRepository;
import com.luxhouse.main.service.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {
    @Autowired
    CategoryProductRepository categoryProductRepository;

    @Override
    public List<CategoryProducts> findAll() {
        return categoryProductRepository.findAll();
    }

    @Override
    public List<CategoryProducts> findAll(Sort sort) {
        return categoryProductRepository.findAll(sort);
    }

    @Override
    public List<CategoryProducts> findAllById(Iterable<Integer> iterable) {
        return categoryProductRepository.findAllById(iterable);
    }

    @Override
    public <S extends CategoryProducts> List<S> saveAll(Iterable<S> iterable) {
        return categoryProductRepository.saveAll(iterable);
    }

    @Override
    public void flush() {
        categoryProductRepository.flush();
    }

    @Override
    public <S extends CategoryProducts> S saveAndFlush(S s) {
        return categoryProductRepository.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<CategoryProducts> iterable) {
        categoryProductRepository.deleteInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        categoryProductRepository.deleteAllInBatch();
    }

    @Override
    public CategoryProducts getOne(Integer integer) {
        return categoryProductRepository.getOne(integer);
    }

    @Override
    public <S extends CategoryProducts> List<S> findAll(Example<S> example) {
        return categoryProductRepository.findAll(example);
    }

    @Override
    public <S extends CategoryProducts> List<S> findAll(Example<S> example, Sort sort) {
        return categoryProductRepository.findAll(example, sort);
    }

    @Override
    public Page<CategoryProducts> findAll(Pageable pageable) {
        return categoryProductRepository.findAll(pageable);
    }

    @Override
    public <S extends CategoryProducts> S save(S s) {
        return categoryProductRepository.save(s);
    }

    @Override
    public Optional<CategoryProducts> findById(Integer integer) {
        return categoryProductRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return categoryProductRepository.existsById(integer);
    }

    @Override
    public long count() {
        return categoryProductRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        categoryProductRepository.deleteById(integer);
    }

    @Override
    public void delete(CategoryProducts categoryProducts) {
        categoryProductRepository.delete(categoryProducts);
    }

    @Override
    public void deleteAll(Iterable<? extends CategoryProducts> iterable) {
        categoryProductRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        categoryProductRepository.deleteAll();
    }

    @Override
    public <S extends CategoryProducts> Optional<S> findOne(Example<S> example) {
        return categoryProductRepository.findOne(example);
    }

    @Override
    public <S extends CategoryProducts> Page<S> findAll(Example<S> example, Pageable pageable) {
        return categoryProductRepository.findAll(example, pageable);
    }

    @Override
    public <S extends CategoryProducts> long count(Example<S> example) {
        return categoryProductRepository.count(example);
    }

    @Override
    public <S extends CategoryProducts> boolean exists(Example<S> example) {
        return categoryProductRepository.exists(example);
    }

    @Override
    public List<CategoryProducts> selectByCategoryId() {
        // TODO Auto-generated method stub
        return categoryProductRepository.selectByCategoryId();
    }


}

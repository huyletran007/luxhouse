package com.luxhouse.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.luxhouse.main.domain.Products;
import com.luxhouse.main.repository.ProductsRepository;
import com.luxhouse.main.service.ProductsService;

@Service
public class ProductsServiceImlp implements ProductsService{
    @Autowired
    ProductsRepository productsRepository;

    @Override
    public <S extends Products> S save(S entity) {
        return productsRepository.save(entity);
    }

    @Override
    public <S extends Products> Optional<S> findOne(Example<S> example) {
        return productsRepository.findOne(example);
    }

    @Override
    public Page<Products> findAll(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }

    @Override
    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public List<Products> findAll(Sort sort) {
        return productsRepository.findAll(sort);
    }

    @Override
    public List<Products> findAllById(Iterable<Long> ids) {
        return productsRepository.findAllById(ids);
    }

    @Override
    public <S extends Products> List<S> saveAll(Iterable<S> entities) {
        return productsRepository.saveAll(entities);
    }

    @Override
    public Optional<Products> findById(Long id) {
        return productsRepository.findById(id);
    }

    @Override
    public void flush() {
        productsRepository.flush();
    }

    @Override
    public <S extends Products> S saveAndFlush(S entity) {
        return productsRepository.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return productsRepository.existsById(id);
    }

    @Override
    public void deleteInBatch(Iterable<Products> entities) {
        productsRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends Products> Page<S> findAll(Example<S> example, Pageable pageable) {
        return productsRepository.findAll(example, pageable);
    }

    @Override
    public void deleteAllInBatch() {
        productsRepository.deleteAllInBatch();
    }

    @Override
    public Products getOne(Long id) {
        return productsRepository.getOne(id);
    }

    @Override
    public <S extends Products> long count(Example<S> example) {
        return productsRepository.count(example);
    }

    @Override
    public <S extends Products> boolean exists(Example<S> example) {
        return productsRepository.exists(example);
    }

    @Override
    public <S extends Products> List<S> findAll(Example<S> example) {
        return productsRepository.findAll(example);
    }

    @Override
    public long count() {
        return productsRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        productsRepository.deleteById(id);
    }

    @Override
    public <S extends Products> List<S> findAll(Example<S> example, Sort sort) {
        return productsRepository.findAll(example, sort);
    }

    @Override
    public void delete(Products entity) {
        productsRepository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends Products> entities) {
        productsRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        productsRepository.deleteAll();
    }

    @Override
    public List<Products> selectsByProductName(String name) {
        // TODO Auto-generated method stub
        return productsRepository.selectsByProductName(name);
    }

    @Override
    public List<Products> selectsByCategoryProductCode(String code) {
        // TODO Auto-generated method stub
        return productsRepository.selectsByCategoryProductCode(code);
    }

    @Override
    public List<Products> selectsByCategoryMCode(String code) {
        // TODO Auto-generated method stub
        return productsRepository.selectsByCategoryMCode(code);
    }
    
    
}

package com.luxhouse.main.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.luxhouse.main.domain.ProductImages;
import com.luxhouse.main.domain.Products;
import com.luxhouse.main.repository.ProductImagesRepository;
import com.luxhouse.main.service.ProductImagesService;

@Service
public class ProductImagesServiceImpl implements ProductImagesService{
    @Autowired
    ProductImagesRepository productImagesRepository;

    @Override
    public <S extends ProductImages> S save(S entity) {
        return productImagesRepository.save(entity);
    }

    @Override
    public <S extends ProductImages> Optional<S> findOne(Example<S> example) {
        return productImagesRepository.findOne(example);
    }

    @Override
    public Page<ProductImages> findAll(Pageable pageable) {
        return productImagesRepository.findAll(pageable);
    }

    @Override
    public List<ProductImages> findAll() {
        return productImagesRepository.findAll();
    }

    @Override
    public List<ProductImages> findAll(Sort sort) {
        return productImagesRepository.findAll(sort);
    }

    @Override
    public List<ProductImages> findAllById(Iterable<Long> ids) {
        return productImagesRepository.findAllById(ids);
    }

    @Override
    public <S extends ProductImages> List<S> saveAll(Iterable<S> entities) {
        return productImagesRepository.saveAll(entities);
    }

    @Override
    public Optional<ProductImages> findById(Long id) {
        return productImagesRepository.findById(id);
    }

    @Override
    public void flush() {
        productImagesRepository.flush();
    }

    @Override
    public <S extends ProductImages> S saveAndFlush(S entity) {
        return productImagesRepository.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return productImagesRepository.existsById(id);
    }

    @Override
    public void deleteInBatch(Iterable<ProductImages> entities) {
        productImagesRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends ProductImages> Page<S> findAll(Example<S> example, Pageable pageable) {
        return productImagesRepository.findAll(example, pageable);
    }

    @Override
    public void deleteAllInBatch() {
        productImagesRepository.deleteAllInBatch();
    }

    @Override
    public ProductImages getOne(Long id) {
        return productImagesRepository.getOne(id);
    }

    @Override
    public <S extends ProductImages> long count(Example<S> example) {
        return productImagesRepository.count(example);
    }

    @Override
    public <S extends ProductImages> boolean exists(Example<S> example) {
        return productImagesRepository.exists(example);
    }

    @Override
    public <S extends ProductImages> List<S> findAll(Example<S> example) {
        return productImagesRepository.findAll(example);
    }

    @Override
    public long count() {
        return productImagesRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        productImagesRepository.deleteById(id);
    }

    @Override
    public <S extends ProductImages> List<S> findAll(Example<S> example, Sort sort) {
        return productImagesRepository.findAll(example, sort);
    }

    @Override
    public void delete(ProductImages entity) {
        productImagesRepository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends ProductImages> entities) {
        productImagesRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        productImagesRepository.deleteAll();
    }

    @Override
    public List<ProductImages> selectsByProductId(Long id) {
        // TODO Auto-generated method stub
        return productImagesRepository.selectsByProductId(id);
    }

}

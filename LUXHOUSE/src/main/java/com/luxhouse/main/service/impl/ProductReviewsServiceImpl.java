package com.luxhouse.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.luxhouse.main.domain.ProductReviews;
import com.luxhouse.main.domain.Products;
import com.luxhouse.main.repository.ProductReviewsRepository;
import com.luxhouse.main.service.ProductReviewsService;

@Service
public class ProductReviewsServiceImpl implements ProductReviewsService{
    @Autowired
    ProductReviewsRepository productReviewsRepository;

    @Override
    public <S extends ProductReviews> S save(S entity) {
        return productReviewsRepository.save(entity);
    }

    @Override
    public <S extends ProductReviews> Optional<S> findOne(Example<S> example) {
        return productReviewsRepository.findOne(example);
    }

    @Override
    public Page<ProductReviews> findAll(Pageable pageable) {
        return productReviewsRepository.findAll(pageable);
    }

    @Override
    public List<ProductReviews> findAll() {
        return productReviewsRepository.findAll();
    }

    @Override
    public List<ProductReviews> findAll(Sort sort) {
        return productReviewsRepository.findAll(sort);
    }

    @Override
    public List<ProductReviews> findAllById(Iterable<Long> ids) {
        return productReviewsRepository.findAllById(ids);
    }

    @Override
    public <S extends ProductReviews> List<S> saveAll(Iterable<S> entities) {
        return productReviewsRepository.saveAll(entities);
    }

    @Override
    public Optional<ProductReviews> findById(Long id) {
        return productReviewsRepository.findById(id);
    }

    @Override
    public void flush() {
        productReviewsRepository.flush();
    }

    @Override
    public <S extends ProductReviews> S saveAndFlush(S entity) {
        return productReviewsRepository.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return productReviewsRepository.existsById(id);
    }

    @Override
    public void deleteInBatch(Iterable<ProductReviews> entities) {
        productReviewsRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends ProductReviews> Page<S> findAll(Example<S> example, Pageable pageable) {
        return productReviewsRepository.findAll(example, pageable);
    }

    @Override
    public void deleteAllInBatch() {
        productReviewsRepository.deleteAllInBatch();
    }

    @Override
    public ProductReviews getOne(Long id) {
        return productReviewsRepository.getOne(id);
    }

    @Override
    public <S extends ProductReviews> long count(Example<S> example) {
        return productReviewsRepository.count(example);
    }

    @Override
    public <S extends ProductReviews> boolean exists(Example<S> example) {
        return productReviewsRepository.exists(example);
    }

    @Override
    public <S extends ProductReviews> List<S> findAll(Example<S> example) {
        return productReviewsRepository.findAll(example);
    }

    @Override
    public long count() {
        return productReviewsRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        productReviewsRepository.deleteById(id);
    }

    @Override
    public <S extends ProductReviews> List<S> findAll(Example<S> example, Sort sort) {
        return productReviewsRepository.findAll(example, sort);
    }

    @Override
    public void delete(ProductReviews entity) {
        productReviewsRepository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends ProductReviews> entities) {
        productReviewsRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        productReviewsRepository.deleteAll();
    }

    
    
}

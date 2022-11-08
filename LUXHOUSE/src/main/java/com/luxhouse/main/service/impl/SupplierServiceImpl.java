package com.luxhouse.main.service.impl;



import com.luxhouse.main.domain.Suppliers;
import com.luxhouse.main.repository.SupplierRespository;
import com.luxhouse.main.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRespository supplierRespository;

    @Override
    public List<Suppliers> findAll() {
        return supplierRespository.findAll();
    }

    @Override
    public List<Suppliers> findAll(Sort sort) {
        return supplierRespository.findAll(sort);
    }

    @Override
    public List<Suppliers> findAllById(Iterable<Integer> iterable) {
        return supplierRespository.findAllById(iterable);
    }

    @Override
    public <S extends Suppliers> List<S> saveAll(Iterable<S> iterable) {
        return supplierRespository.saveAll(iterable);
    }

    @Override
    public void flush() {
        supplierRespository.flush();
    }

    @Override
    public <S extends Suppliers> S saveAndFlush(S s) {
        return supplierRespository.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Suppliers> iterable) {
        supplierRespository.deleteInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        supplierRespository.deleteAllInBatch();
    }

    @Override
    public Suppliers getOne(Integer integer) {
        return supplierRespository.getOne(integer);
    }

    @Override
    public <S extends Suppliers> List<S> findAll(Example<S> example) {
        return supplierRespository.findAll(example);
    }

    @Override
    public <S extends Suppliers> List<S> findAll(Example<S> example, Sort sort) {
        return supplierRespository.findAll(example, sort);
    }

    @Override
    public Page<Suppliers> findAll(Pageable pageable) {
        return supplierRespository.findAll(pageable);
    }

    @Override
    public <S extends Suppliers> S save(S s) {
        return supplierRespository.save(s);
    }

    @Override
    public Optional<Suppliers> findById(Integer integer) {
        return supplierRespository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return supplierRespository.existsById(integer);
    }

    @Override
    public long count() {
        return supplierRespository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        supplierRespository.deleteById(integer);
    }

    @Override
    public void delete(Suppliers suppliers) {
        supplierRespository.delete(suppliers);
    }

    @Override
    public void deleteAll(Iterable<? extends Suppliers> iterable) {
        supplierRespository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        supplierRespository.deleteAll();
    }

    @Override
    public <S extends Suppliers> Optional<S> findOne(Example<S> example) {
        return supplierRespository.findOne(example);
    }

    @Override
    public <S extends Suppliers> Page<S> findAll(Example<S> example, Pageable pageable) {
        return supplierRespository.findAll(example, pageable);
    }

    @Override
    public <S extends Suppliers> long count(Example<S> example) {
        return supplierRespository.count(example);
    }

    @Override
    public <S extends Suppliers> boolean exists(Example<S> example) {
        return supplierRespository.exists(example);
    }
}

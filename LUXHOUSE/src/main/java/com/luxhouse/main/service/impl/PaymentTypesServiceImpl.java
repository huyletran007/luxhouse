package com.luxhouse.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.luxhouse.main.domain.PaymentTypes;
import com.luxhouse.main.repository.PaymentTypesRespository;
import com.luxhouse.main.service.PaymentTypesService;

@Service
public class PaymentTypesServiceImpl implements PaymentTypesService {
	@Autowired
	PaymentTypesRespository paymentTypesRespository;

	@Override
	public <S extends PaymentTypes> S save(S entity) {
		return paymentTypesRespository.save(entity);
	}

	@Override
	public <S extends PaymentTypes> Optional<S> findOne(Example<S> example) {
		return paymentTypesRespository.findOne(example);
	}

	@Override
	public Page<PaymentTypes> findAll(Pageable pageable) {
		return paymentTypesRespository.findAll(pageable);
	}

	@Override
	public List<PaymentTypes> findAll() {
		return paymentTypesRespository.findAll();
	}

	@Override
	public List<PaymentTypes> findAll(Sort sort) {
		return paymentTypesRespository.findAll(sort);
	}

	@Override
	public List<PaymentTypes> findAllById(Iterable<Integer> ids) {
		return paymentTypesRespository.findAllById(ids);
	}

	@Override
	public <S extends PaymentTypes> List<S> saveAll(Iterable<S> entities) {
		return paymentTypesRespository.saveAll(entities);
	}

	@Override
	public Optional<PaymentTypes> findById(Integer id) {
		return paymentTypesRespository.findById(id);
	}

	@Override
	public void flush() {
		paymentTypesRespository.flush();
	}

	@Override
	public <S extends PaymentTypes> S saveAndFlush(S entity) {
		return paymentTypesRespository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return paymentTypesRespository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<PaymentTypes> entities) {
		paymentTypesRespository.deleteInBatch(entities);
	}

	@Override
	public <S extends PaymentTypes> Page<S> findAll(Example<S> example, Pageable pageable) {
		return paymentTypesRespository.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		paymentTypesRespository.deleteAllInBatch();
	}

	@Override
	public PaymentTypes getOne(Integer id) {
		return paymentTypesRespository.getOne(id);
	}

	@Override
	public <S extends PaymentTypes> long count(Example<S> example) {
		return paymentTypesRespository.count(example);
	}

	@Override
	public <S extends PaymentTypes> boolean exists(Example<S> example) {
		return paymentTypesRespository.exists(example);
	}

	@Override
	public <S extends PaymentTypes> List<S> findAll(Example<S> example) {
		return paymentTypesRespository.findAll(example);
	}

	@Override
	public long count() {
		return paymentTypesRespository.count();
	}

	@Override
	public void deleteById(Integer id) {
		paymentTypesRespository.deleteById(id);
	}

	@Override
	public <S extends PaymentTypes> List<S> findAll(Example<S> example, Sort sort) {
		return paymentTypesRespository.findAll(example, sort);
	}

	@Override
	public void delete(PaymentTypes entity) {
		paymentTypesRespository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends PaymentTypes> entities) {
		paymentTypesRespository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		paymentTypesRespository.deleteAll();
	}
	
}

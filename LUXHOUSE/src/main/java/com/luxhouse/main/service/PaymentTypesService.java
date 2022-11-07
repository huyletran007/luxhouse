package com.luxhouse.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.luxhouse.main.domain.PaymentTypes;

public interface PaymentTypesService {

	void deleteAll();

	void deleteAll(Iterable<? extends PaymentTypes> entities);

	void delete(PaymentTypes entity);

	<S extends PaymentTypes> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Integer id);

	long count();

	<S extends PaymentTypes> List<S> findAll(Example<S> example);

	<S extends PaymentTypes> boolean exists(Example<S> example);

	<S extends PaymentTypes> long count(Example<S> example);

	PaymentTypes getOne(Integer id);

	void deleteAllInBatch();

	<S extends PaymentTypes> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<PaymentTypes> entities);

	boolean existsById(Integer id);

	<S extends PaymentTypes> S saveAndFlush(S entity);

	void flush();

	Optional<PaymentTypes> findById(Integer id);

	<S extends PaymentTypes> List<S> saveAll(Iterable<S> entities);

	List<PaymentTypes> findAllById(Iterable<Integer> ids);

	List<PaymentTypes> findAll(Sort sort);

	List<PaymentTypes> findAll();

	Page<PaymentTypes> findAll(Pageable pageable);

	<S extends PaymentTypes> Optional<S> findOne(Example<S> example);

	<S extends PaymentTypes> S save(S entity);

}

package com.luxhouse.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.luxhouse.main.domain.OrderDetails;

public interface OrderDetailsService {

	void deleteAll();

	void deleteAll(Iterable<? extends OrderDetails> entities);

	void delete(OrderDetails entity);

	<S extends OrderDetails> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Long id);

	long count();

	<S extends OrderDetails> List<S> findAll(Example<S> example);

	<S extends OrderDetails> boolean exists(Example<S> example);

	<S extends OrderDetails> long count(Example<S> example);

	OrderDetails getOne(Long id);

	void deleteAllInBatch();

	<S extends OrderDetails> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<OrderDetails> entities);

	boolean existsById(Long id);

	<S extends OrderDetails> S saveAndFlush(S entity);

	void flush();

	Optional<OrderDetails> findById(Long id);

	<S extends OrderDetails> List<S> saveAll(Iterable<S> entities);

	List<OrderDetails> findAllById(Iterable<Long> ids);

	List<OrderDetails> findAll(Sort sort);

	List<OrderDetails> findAll();

	Page<OrderDetails> findAll(Pageable pageable);

	<S extends OrderDetails> Optional<S> findOne(Example<S> example);

	<S extends OrderDetails> S save(S entity);

}

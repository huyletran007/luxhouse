package com.luxhouse.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.luxhouse.main.domain.Orders;
import com.luxhouse.main.domain.ProductImages;

public interface OrdersService {

	void deleteAll();

	void deleteAll(Iterable<? extends Orders> entities);

	void delete(Orders entity);

	<S extends Orders> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Long id);

	long count();

	<S extends Orders> List<S> findAll(Example<S> example);

	<S extends Orders> boolean exists(Example<S> example);

	<S extends Orders> long count(Example<S> example);

	Orders getOne(Long id);

	void deleteAllInBatch();

	<S extends Orders> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Orders> entities);

	boolean existsById(Long id);

	<S extends Orders> S saveAndFlush(S entity);

	void flush();

	Optional<Orders> findById(Long id);

	<S extends Orders> List<S> saveAll(Iterable<S> entities);

	List<Orders> findAllById(Iterable<Long> ids);

	List<Orders> findAll(Sort sort);

	List<Orders> findAll();

	Page<Orders> findAll(Pageable pageable);

	<S extends Orders> Optional<S> findOne(Example<S> example);

	<S extends Orders> S save(S entity);
	
	List<Orders> selectsByUserIdHi(Long userId);

}

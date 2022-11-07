package com.luxhouse.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.luxhouse.main.domain.OrderDetails;
import com.luxhouse.main.repository.OrdersDetailsRespository;
import com.luxhouse.main.service.OrderDetailsService;

@Service
public class OrdersDetailsServiceImpl implements OrderDetailsService {
	@Autowired
	OrdersDetailsRespository ordersDetailsRespository;

	@Override
	public <S extends OrderDetails> S save(S entity) {
		return ordersDetailsRespository.save(entity);
	}

	@Override
	public <S extends OrderDetails> Optional<S> findOne(Example<S> example) {
		return ordersDetailsRespository.findOne(example);
	}

	@Override
	public Page<OrderDetails> findAll(Pageable pageable) {
		return ordersDetailsRespository.findAll(pageable);
	}

	@Override
	public List<OrderDetails> findAll() {
		return ordersDetailsRespository.findAll();
	}

	@Override
	public List<OrderDetails> findAll(Sort sort) {
		return ordersDetailsRespository.findAll(sort);
	}

	@Override
	public List<OrderDetails> findAllById(Iterable<Long> ids) {
		return ordersDetailsRespository.findAllById(ids);
	}

	@Override
	public <S extends OrderDetails> List<S> saveAll(Iterable<S> entities) {
		return ordersDetailsRespository.saveAll(entities);
	}

	@Override
	public Optional<OrderDetails> findById(Long id) {
		return ordersDetailsRespository.findById(id);
	}

	@Override
	public void flush() {
		ordersDetailsRespository.flush();
	}

	@Override
	public <S extends OrderDetails> S saveAndFlush(S entity) {
		return ordersDetailsRespository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return ordersDetailsRespository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<OrderDetails> entities) {
		ordersDetailsRespository.deleteInBatch(entities);
	}

	@Override
	public <S extends OrderDetails> Page<S> findAll(Example<S> example, Pageable pageable) {
		return ordersDetailsRespository.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		ordersDetailsRespository.deleteAllInBatch();
	}

	@Override
	public OrderDetails getOne(Long id) {
		return ordersDetailsRespository.getOne(id);
	}

	@Override
	public <S extends OrderDetails> long count(Example<S> example) {
		return ordersDetailsRespository.count(example);
	}

	@Override
	public <S extends OrderDetails> boolean exists(Example<S> example) {
		return ordersDetailsRespository.exists(example);
	}

	@Override
	public <S extends OrderDetails> List<S> findAll(Example<S> example) {
		return ordersDetailsRespository.findAll(example);
	}

	@Override
	public long count() {
		return ordersDetailsRespository.count();
	}

	@Override
	public void deleteById(Long id) {
		ordersDetailsRespository.deleteById(id);
	}

	@Override
	public <S extends OrderDetails> List<S> findAll(Example<S> example, Sort sort) {
		return ordersDetailsRespository.findAll(example, sort);
	}

	@Override
	public void delete(OrderDetails entity) {
		ordersDetailsRespository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends OrderDetails> entities) {
		ordersDetailsRespository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ordersDetailsRespository.deleteAll();
	}
}

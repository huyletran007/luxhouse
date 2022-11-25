package com.luxhouse.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.luxhouse.main.domain.Orders;
import com.luxhouse.main.repository.OrdersRespository;
import com.luxhouse.main.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	OrdersRespository ordersRespository;

	@Override
	public <S extends Orders> S save(S entity) {
		return ordersRespository.save(entity);
	}

	@Override
	public <S extends Orders> Optional<S> findOne(Example<S> example) {
		return ordersRespository.findOne(example);
	}

	@Override
	public Page<Orders> findAll(Pageable pageable) {
		return ordersRespository.findAll(pageable);
	}

	@Override
	public List<Orders> findAll() {
		return ordersRespository.findAll();
	}

	@Override
	public List<Orders> findAll(Sort sort) {
		return ordersRespository.findAll(sort);
	}

	@Override
	public List<Orders> findAllById(Iterable<Long> ids) {
		return ordersRespository.findAllById(ids);
	}

	@Override
	public <S extends Orders> List<S> saveAll(Iterable<S> entities) {
		return ordersRespository.saveAll(entities);
	}

	@Override
	public Optional<Orders> findById(Long id) {
		return ordersRespository.findById(id);
	}

	@Override
	public void flush() {
		ordersRespository.flush();
	}

	@Override
	public <S extends Orders> S saveAndFlush(S entity) {
		return ordersRespository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return ordersRespository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Orders> entities) {
		ordersRespository.deleteInBatch(entities);
	}

	@Override
	public <S extends Orders> Page<S> findAll(Example<S> example, Pageable pageable) {
		return ordersRespository.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		ordersRespository.deleteAllInBatch();
	}

	@Override
	public Orders getOne(Long id) {
		return ordersRespository.getOne(id);
	}

	@Override
	public <S extends Orders> long count(Example<S> example) {
		return ordersRespository.count(example);
	}

	@Override
	public <S extends Orders> boolean exists(Example<S> example) {
		return ordersRespository.exists(example);
	}

	@Override
	public <S extends Orders> List<S> findAll(Example<S> example) {
		return ordersRespository.findAll(example);
	}

	@Override
	public long count() {
		return ordersRespository.count();
	}

	@Override
	public void deleteById(Long id) {
		ordersRespository.deleteById(id);
	}

	@Override
	public <S extends Orders> List<S> findAll(Example<S> example, Sort sort) {
		return ordersRespository.findAll(example, sort);
	}

	@Override
	public void delete(Orders entity) {
		ordersRespository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Orders> entities) {
		ordersRespository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ordersRespository.deleteAll();
	}

    @Override
    public List<Orders> selectsByUserIdHi(Long userId) {
        // TODO Auto-generated method stub
        return ordersRespository.selectsByUserIdHi(userId);
    }
}

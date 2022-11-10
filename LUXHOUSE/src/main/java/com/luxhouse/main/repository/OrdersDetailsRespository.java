package com.luxhouse.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luxhouse.main.domain.OrderDetails;

@Repository
public interface OrdersDetailsRespository extends JpaRepository<OrderDetails, Long> {

}

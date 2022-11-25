package com.luxhouse.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luxhouse.main.domain.Orders;
import com.luxhouse.main.domain.ProductImages;

@Repository
public interface OrdersRespository extends JpaRepository<Orders, Long> {
    @Query("SELECT o FROM Orders o WHERE o.users.id = ?1")
    List<Orders> selectsByUserIdHi(Long userId);
}

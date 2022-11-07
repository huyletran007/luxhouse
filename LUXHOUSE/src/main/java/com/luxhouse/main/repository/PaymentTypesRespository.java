package com.luxhouse.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luxhouse.main.domain.PaymentTypes;

@Repository
public interface PaymentTypesRespository extends JpaRepository<PaymentTypes, Integer> {

}

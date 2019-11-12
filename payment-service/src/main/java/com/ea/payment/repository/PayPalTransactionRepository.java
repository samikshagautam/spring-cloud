package com.ea.payment.repository;

import com.ea.payment.entity.PayPalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayPalTransactionRepository extends JpaRepository<PayPalTransaction, Long> {
}

package com.ea.payment.repository;

import com.ea.payment.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    Card findByNumberAndAccountId(String number, Long accountId);

    List<Card> findAllByAccountId(Long accountId);
}

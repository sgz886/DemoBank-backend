package com.gordon.repository;

import com.gordon.model.Card;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

  List<Card> findByCustomerId(Long customerId);
}
package com.citi.training.SpringBoot.repo;

import com.citi.training.SpringBoot.entity.Investment;
import com.citi.training.SpringBoot.entity.MarketMover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketMoverRepo extends JpaRepository<MarketMover, Integer> {
}

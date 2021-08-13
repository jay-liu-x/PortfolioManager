package com.citi.training.SpringBoot.repo;

import com.citi.training.SpringBoot.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Integer> {
//    List<Investment> findByInvestmentAccountName(String investmentAccountName);
//
//    List<Investment> findAllGainers();
//
//    List<Investment> findAllLosers();
//
//    List<Investment> findTopFiveGainers();
//
//    List<Investment> findTopFiveLosers();
}

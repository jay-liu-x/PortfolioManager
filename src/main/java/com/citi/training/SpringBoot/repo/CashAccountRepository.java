package com.citi.training.SpringBoot.repo;

import com.citi.training.SpringBoot.entity.CashAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashAccountRepository extends JpaRepository<CashAccount, Integer> {
}

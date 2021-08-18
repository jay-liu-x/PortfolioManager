package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.CashAccount;
import com.citi.training.SpringBoot.entity.InvestmentAccount;
import com.citi.training.SpringBoot.entity.MarketMover;
import com.citi.training.SpringBoot.repo.MarketMoverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MarketMoverServiceImpl implements MarketMoverService {
    @Autowired
    private MarketMoverRepo marketMoverRepo;

    @Override
    public Collection<MarketMover> getAllMarketMovers() {
        return marketMoverRepo.findAll();
    }

    @Override
    public MarketMover getMarketMoverById(int id) {
        Optional<MarketMover> marketMover = marketMoverRepo.findById(id);
        if (marketMover.isPresent()) {
            return marketMover.get();
        }
        else return null;
    }
}

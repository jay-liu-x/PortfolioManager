package com.citi.training.SpringBoot.service;

import com.citi.training.SpringBoot.entity.MarketMover;

import java.util.Collection;

public interface MarketMoverService {
    Collection<MarketMover> getAllMarketMovers();

    MarketMover getMarketMoverById(int id);
}

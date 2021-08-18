package com.citi.training.SpringBoot.rest;

import com.citi.training.SpringBoot.entity.Investment;
import com.citi.training.SpringBoot.entity.MarketMover;
import com.citi.training.SpringBoot.service.InvestmentService;
import com.citi.training.SpringBoot.service.MarketMoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/marketmover")
public class MarketMoverController {
    @Autowired
    private MarketMoverService marketMoverService;

    @GetMapping
    public Collection<MarketMover> getAllMarketMovers() {
        return marketMoverService.getAllMarketMovers();
    }

    @GetMapping("/{id}")
    public MarketMover getMarketMoverById(@PathVariable int id) {
        return marketMoverService.getMarketMoverById(id);
    }
}

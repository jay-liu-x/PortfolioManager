package com.citi.training.SpringBoot.rest;

import com.citi.training.SpringBoot.entity.Investment;
import com.citi.training.SpringBoot.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/investments")
public class InvestmentController {
    @Autowired
    private InvestmentService investmentService;

    @GetMapping
    public Collection<Investment> getAllInvestments() {
        return investmentService.getAllInvestments();
    }

    @GetMapping("/id/{id}")
    public Collection<Investment> getInvestmentsByInvestmentId(@PathVariable int id) {
        return investmentService.getInvestmentsByInvestmentId(id);
    }

    @GetMapping("/symbol/{symbol}")
    public Collection<Investment> getInvestmentsBySymbol(@PathVariable String symbol) {
        return investmentService.getInvestmentsBySymbol(symbol);
    }

    @DeleteMapping( "/{id}")
    public void deleteInvestmentById(@PathVariable("id") int id) {
        investmentService.deleteInvestmentById(id);
    }

    @GetMapping("/top_five_gainers")
    public Collection<Investment> getTopFiveGainers() {
        return investmentService.getTopFiveGainers();
    }

    @GetMapping("/top_five_losers")
    public Collection<Investment> getTopFiveLosers() {
        return investmentService.getTopFiveLosers();
    }
}

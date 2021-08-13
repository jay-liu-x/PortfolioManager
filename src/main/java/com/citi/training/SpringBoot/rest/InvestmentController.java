package com.citi.training.SpringBoot.rest;

import com.citi.training.SpringBoot.entity.Investment;
import com.citi.training.SpringBoot.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
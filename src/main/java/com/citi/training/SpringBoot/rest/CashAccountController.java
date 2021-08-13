package com.citi.training.SpringBoot.rest;

import com.citi.training.SpringBoot.entity.CashAccount;
import com.citi.training.SpringBoot.service.CashAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/cashAccounts")
public class CashAccountController {
    @Autowired
    private CashAccountService cashAccountService;

    @GetMapping
    public Collection<CashAccount> getAllCashAccounts() {
        return cashAccountService.getAllCashAccounts();
    }
}

package com.citi.training.SpringBoot.rest;

import com.citi.training.SpringBoot.entity.InvestmentAccount;
import com.citi.training.SpringBoot.entity.NetWorth;
import com.citi.training.SpringBoot.service.CashAccountService;
import com.citi.training.SpringBoot.service.InvestmentAccountService;
import com.citi.training.SpringBoot.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/cash_flow")
public class CashFlowController {

    @Autowired
    private InvestmentService investmentService;

    @GetMapping("/income")
    public Double getIncome() {
        return investmentService.calculateIncome();
    }

    @GetMapping("/spending")
    public Double getSpending() {
        return investmentService.calculateSpending();
    }

    @GetMapping("/overall")
    public Double getOverall() {
        return investmentService.calculateOverall();
    }

    /* History of incomes for the last 7 days. */
    @GetMapping("/incomes")
    public ArrayList<Double> getIncomes() {
        return investmentService.calculateIncomes();
    }

    /* History of spendings for the last 7 days. */
    @GetMapping("/spendings")
    public ArrayList<Double> getSpendings() {
        return investmentService.calculateSpendings();
    }
}


package com.naimferati.loancalculator.controllers;

import com.naimferati.loancalculator.models.SimpleLoan;
import com.naimferati.loancalculator.services.interfaces.SimpleLoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/simple-loan")
public class SimpleLoanController {
    private final SimpleLoanService simpleLoanService;

    public SimpleLoanController(SimpleLoanService simpleLoanService) {
        this.simpleLoanService = simpleLoanService;
    }

    @PostMapping("/calc-simple-loan/{personId}")
    public SimpleLoan calculateSimpleLoanForPerson (@PathVariable(name = "personId") Long personId, @RequestParam(name = "loanAmount")Double loanAmount, @RequestParam(name = "interestRate")Double interestRate, @RequestParam(name = "loanTerm") Integer loanTearm, @RequestParam(name = "monthOrYear")String monthOrYear){
        return simpleLoanService.calculateSimpleLoan(personId, loanAmount, interestRate, loanTearm, monthOrYear);
    }

}

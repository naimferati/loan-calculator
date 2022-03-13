package com.naimferati.loancalculator.services.interfaces;

import com.naimferati.loancalculator.models.SimpleLoan;

import java.math.BigDecimal;

public interface SimpleLoanService {

    SimpleLoan calculateSimpleLoan (Long personId, Double loanAmount, Double interestRate, Integer loanTerm, String monthOrYear);

}

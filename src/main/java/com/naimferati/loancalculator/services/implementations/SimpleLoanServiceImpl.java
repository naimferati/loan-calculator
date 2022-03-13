package com.naimferati.loancalculator.services.implementations;

import com.naimferati.loancalculator.exeptions.PersonNotFoundException;
import com.naimferati.loancalculator.models.Person;
import com.naimferati.loancalculator.models.SimpleLoan;
import com.naimferati.loancalculator.repositories.PersonRepository;
import com.naimferati.loancalculator.repositories.SimpleLoanRepository;
import com.naimferati.loancalculator.services.interfaces.SimpleLoanService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SimpleLoanServiceImpl implements SimpleLoanService {

    private final PersonRepository personRepository;
    private final SimpleLoanRepository simpleLoanRepository;

    public SimpleLoanServiceImpl(PersonRepository personRepository, SimpleLoanRepository simpleLoanRepository) {
        this.personRepository = personRepository;
        this.simpleLoanRepository = simpleLoanRepository;
    }

    @Override
    public SimpleLoan calculateSimpleLoan(Long personId, Double loanAmount, Double interestRate, Integer loanTerm, String monthOrYear) {
        Person person = personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);

        Integer months = 0;
        if(monthOrYear.equals("year")){
             months = loanTerm * 12;
        }
        else if (monthOrYear.equals("month")){
             months = loanTerm;
        }

        Double interestRatePerMonth = interestRate / 100 / 12;

        Double payment = (loanAmount * (interestRatePerMonth * Math.pow((1 + interestRatePerMonth), months))) / (Math.pow((1 + interestRatePerMonth), months) - 1);

        Double amountPaidWithInterest = payment * months;
        Double totalInterestPaid = amountPaidWithInterest - loanAmount;

        SimpleLoan simpleLoan = new SimpleLoan();
        simpleLoan.setPerson(person);
        simpleLoan.setLoanAmount(loanAmount);
        simpleLoan.setInterestRate(interestRate);
        simpleLoan.setLoanTerm(loanTerm);
        simpleLoan.setMonthOrYear(monthOrYear);
        simpleLoan.setMonthlyPayment(payment);
        simpleLoan.setTotalInterestPaid(totalInterestPaid);

        return simpleLoanRepository.save(simpleLoan);
    }
}

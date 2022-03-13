package com.naimferati.loancalculator.services.interfaces;

import com.naimferati.loancalculator.models.AmortizationSchedule;

import java.util.List;

public interface AmortizationScheduleService {

    void calculateAmortizationSchedule (Long personId, Double loanAmount, Double interestRate, Integer numberOfPayments);

    List<AmortizationSchedule> findAllAmortizationSchedules(Long personId);
}

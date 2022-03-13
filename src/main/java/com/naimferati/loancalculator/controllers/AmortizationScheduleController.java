package com.naimferati.loancalculator.controllers;

import com.naimferati.loancalculator.models.AmortizationSchedule;
import com.naimferati.loancalculator.services.interfaces.AmortizationScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/amortization-schedule")
public class AmortizationScheduleController {

    private final AmortizationScheduleService amortizationScheduleService;

    public AmortizationScheduleController(AmortizationScheduleService amortizationScheduleService) {
        this.amortizationScheduleService = amortizationScheduleService;
    }

    @PostMapping("/calculation/{personId}")
    public void calculateAmortizationSchedule (@PathVariable(name = "personId")Long personId, @RequestParam(name = "loanAmount")Double loanAmount, @RequestParam(name = "interestRate")Double interestRate, @RequestParam(name = "numberOfPayments")Integer numberOfPayments){
            amortizationScheduleService.calculateAmortizationSchedule(personId, loanAmount, interestRate, numberOfPayments);
    }

    @GetMapping("/all")
    public List<AmortizationSchedule> getAll (@RequestParam(name = "personId")Long personId){
        return amortizationScheduleService.findAllAmortizationSchedules(personId);
    }

}

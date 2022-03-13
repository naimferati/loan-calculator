package com.naimferati.loancalculator.services.implementations;

import com.naimferati.loancalculator.exeptions.PersonNotFoundException;
import com.naimferati.loancalculator.models.AmortizationSchedule;
import com.naimferati.loancalculator.models.Person;
import com.naimferati.loancalculator.repositories.AmortizationScheduleRepository;
import com.naimferati.loancalculator.repositories.PersonRepository;
import com.naimferati.loancalculator.services.interfaces.AmortizationScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmortizationScheduleServiceImpl implements AmortizationScheduleService {

    private final AmortizationScheduleRepository amortizationScheduleRepository;
    private final PersonRepository personRepository;

    public AmortizationScheduleServiceImpl(AmortizationScheduleRepository amortizationScheduleRepository, PersonRepository personRepository) {
        this.amortizationScheduleRepository = amortizationScheduleRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void calculateAmortizationSchedule(Long personId, Double loanAmount, Double interestRate, Integer numberOfPayments) {

        Person person = personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);

        Double interestRatePerMonth = interestRate / 100 / 12;

        Double payment = (loanAmount * (interestRatePerMonth * Math.pow((1 + interestRatePerMonth), numberOfPayments))) / (Math.pow((1 + interestRatePerMonth), numberOfPayments) - 1);

        Double amountPaidWithInterest = payment * numberOfPayments;

        Double paymentAmount = amountPaidWithInterest / numberOfPayments;


        for(int i = 1; i <= numberOfPayments; i++){
            AmortizationSchedule amortizationSchedule = new AmortizationSchedule();
            amortizationSchedule.setPerson(person);
            amortizationSchedule.setNumberOfPayment(i);
            amortizationSchedule.setPaymentAmount(paymentAmount);
            amortizationScheduleRepository.save(amortizationSchedule);
        }

    }

    @Override
    public List<AmortizationSchedule> findAllAmortizationSchedules(Long personId) {
        return amortizationScheduleRepository.findAllByPersonIdOrderByNumberOfPaymentAsc(personId);
    }
}

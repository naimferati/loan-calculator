package com.naimferati.loancalculator.repositories;

import com.naimferati.loancalculator.models.AmortizationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmortizationScheduleRepository extends JpaRepository<AmortizationSchedule, Long> {

    List<AmortizationSchedule> findAllByPersonIdOrderByNumberOfPaymentAsc(Long personId);

}

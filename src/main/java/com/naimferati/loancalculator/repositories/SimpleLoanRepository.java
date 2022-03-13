package com.naimferati.loancalculator.repositories;

import com.naimferati.loancalculator.models.SimpleLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleLoanRepository extends JpaRepository<SimpleLoan, Long> {
}

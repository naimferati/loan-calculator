package com.naimferati.loancalculator;

import com.naimferati.loancalculator.exeptions.PersonNotFoundException;
import com.naimferati.loancalculator.services.implementations.PersonServiceImpl;
import com.naimferati.loancalculator.services.interfaces.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class LoanCalculatorApplicationUnitTests {

    @Autowired
    private PersonService personService;

    @Test
    public void testPersonNotFoundException() {
        PersonNotFoundException personNotFoundException = assertThrows(PersonNotFoundException.class,
                ()-> personService.deletePerson(128L));

        Assertions.assertEquals("Person not found exception!", personNotFoundException.getMessage());
    }

    @Test
    void contextLoads() {
    }

}

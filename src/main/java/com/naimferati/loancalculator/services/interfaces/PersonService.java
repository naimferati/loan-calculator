package com.naimferati.loancalculator.services.interfaces;

import com.naimferati.loancalculator.models.Person;
import com.naimferati.loancalculator.models.dtos.PersonCreationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

    Person createPerson (PersonCreationDTO personCreationDTO);

    void deletePerson (Long id);

    Page<Person> findAllPaged (Pageable pageable);

}

package com.naimferati.loancalculator.controllers;

import com.naimferati.loancalculator.exeptions.PersonNotFoundException;
import com.naimferati.loancalculator.models.Person;
import com.naimferati.loancalculator.models.dtos.PersonCreationDTO;
import com.naimferati.loancalculator.services.interfaces.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create-person")
    public Person createPerson (@RequestBody PersonCreationDTO personCreationDTO){
        return personService.createPerson(personCreationDTO);
    }


    @DeleteMapping("/delete/{id}")
    public void deletePerson (@PathVariable(name = "id")Long id){
        personService.deletePerson(id);
    }

    @GetMapping("/all-paged")
    public Page<Person> getAllPaged (Pageable pageable){
        return personService.findAllPaged(pageable);
    }

}

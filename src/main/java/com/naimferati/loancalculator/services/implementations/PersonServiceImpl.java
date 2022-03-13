package com.naimferati.loancalculator.services.implementations;

import com.naimferati.loancalculator.exeptions.PersonNotFoundException;
import com.naimferati.loancalculator.models.Person;
import com.naimferati.loancalculator.models.dtos.PersonCreationDTO;
import com.naimferati.loancalculator.repositories.PersonRepository;
import com.naimferati.loancalculator.services.interfaces.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(PersonCreationDTO personCreationDTO) {

        Person person = new Person();
        person.setFirstName(personCreationDTO.getFirstName());
        person.setLastName(personCreationDTO.getLastName());
        person.setEmail(personCreationDTO.getEmail());
        return personRepository.save(person);

    }

    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);

        personRepository.delete(person);
    }

    @Override
    public Page<Person> findAllPaged(Pageable pageable) {
        return personRepository.findAllPaged(pageable);
    }
}

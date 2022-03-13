package com.naimferati.loancalculator.repositories;

import com.naimferati.loancalculator.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select p from Person p order by p.dateCreated desc ")
    Page<Person> findAllPaged (Pageable pageable);

}

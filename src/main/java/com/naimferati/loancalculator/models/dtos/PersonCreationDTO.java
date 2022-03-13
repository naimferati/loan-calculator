package com.naimferati.loancalculator.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonCreationDTO {

    private String firstName;

    private String lastName;

    private String email;

}

package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserDto {

    private Long userId;
    private String firstName;
    private String secondName;
    private LocalDate createAccount;

}

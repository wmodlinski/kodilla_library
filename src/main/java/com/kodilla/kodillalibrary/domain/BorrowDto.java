package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BorrowDto {

    private long borrowId;
    private Copy borrowedBook;
    private User user;
    private LocalDate loadDate;
    private LocalDate returnDate;
}

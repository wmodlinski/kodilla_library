package com.kodilla.kodillalibrary.domain;

import java.time.LocalDate;

public class BorrowingDto {

    private long id;
    private CopyOfBook copyOfBook;
    private User user;
    private LocalDate loadDate;
    private LocalDate returnDate;
}

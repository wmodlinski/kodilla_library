package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDto {

    private long bookId;
    private String title;
    private String author;
    private int yearOfPublication;
}

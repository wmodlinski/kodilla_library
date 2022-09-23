package com.kodilla.kodillalibrary.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Data
@Entity(name = "BOOKS")
public class Book {

    @NotNull
    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID", unique = true)
    private long bookId;

    @Column(name = "BOOK_TITLE")
    private String title;

    @Column(name = "BOOK_AUTHOR")
    private String author;

    @Column(name = "YEAR_OF_PUBLICATION")
    private int yearOfPublication;
}

package com.kodilla.kodillalibrary.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity(name = "BORROWED_BOOKS")
public class Borrow {

    @NotNull
    @Id
    @GeneratedValue
    @Column(name = "BORROWING_ID", unique = true)
    private long borrowId;

    @OneToOne
    @JoinColumn(name = "BOOK_ID", nullable = false)
    private Copy borrowedBook;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "LOAD_DATE")
    private LocalDate loadDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

}

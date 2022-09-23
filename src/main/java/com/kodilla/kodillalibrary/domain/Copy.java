package com.kodilla.kodillalibrary.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity(name = "COPY_OF_BOOK")
public class Copy {

    @NotNull
    @Id
    @GeneratedValue
    @Column(name = "COPY_ID", unique = true)
    private long copyId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "BOOK_ID", nullable = false)
    private Book bookId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;
}
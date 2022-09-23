package com.kodilla.kodillalibrary.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Data
@Entity(name = "USERS")
public class User {

    @NotNull
    @Id
    @GeneratedValue
    @Column(name = "USER_ID", unique = true)
    private Long userId;

    @Column(name = "USER_FIRST_NAME")
    private String firstName;

    @Column(name = "USER_SECOND_NAME")
    private String secondName;

    @Column(name = "ACCOUNT_CREATION_DATE")
    private LocalDate createAccount;
}

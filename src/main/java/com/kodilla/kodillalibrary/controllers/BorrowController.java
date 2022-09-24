package com.kodilla.kodillalibrary.controllers;

import com.kodilla.kodillalibrary.domain.Borrow;
import com.kodilla.kodillalibrary.exceptions.BorrowNotFoundException;
import com.kodilla.kodillalibrary.exceptions.CopyNotFoundException;
import com.kodilla.kodillalibrary.exceptions.CopyUnavailableException;
import com.kodilla.kodillalibrary.exceptions.UserNotFoundException;
import com.kodilla.kodillalibrary.services.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/borrowedbooks")
@RequiredArgsConstructor
public class BorrowController {

    private final BorrowService borrowService;

    @GetMapping
    public ResponseEntity<List<Borrow>> getAllBorrowedBooks(){
        return ResponseEntity.ok(borrowService.getAllBorrowing());
    }

    @PostMapping
    public ResponseEntity<Void> borrowedBook(
            @RequestParam(name = "userId") long userId,
            @RequestParam(name = "copyId") long copyId )
        throws UserNotFoundException, CopyNotFoundException, CopyUnavailableException {

        borrowService.borrowedBooks(userId, copyId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{borrowId}")
    public ResponseEntity<Void> returnBook(@PathVariable long borrowId) throws BorrowNotFoundException {

        borrowService.returnBook(borrowId);

        return ResponseEntity.ok().build();
    }
}

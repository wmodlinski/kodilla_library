package com.kodilla.kodillalibrary.controllers;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.exceptions.BookNotFoundException;
import com.kodilla.kodillalibrary.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/books")
@RequiredArgsConstructor
public class BookController {


    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping(value = "{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable long bookId) throws BookNotFoundException {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        return ResponseEntity.ok(bookService.createBook(bookDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) throws BookNotFoundException{
        return ResponseEntity.ok(bookService.updateBook(bookDto));
    }

    @DeleteMapping(value = "{bookId}")
    public ResponseEntity<BookDto> deleteBook(@PathVariable BookDto bookDto) throws BookNotFoundException{
        bookService.deleteBook(bookDto.getBookId());
        return ResponseEntity.ok().build();
    }

}
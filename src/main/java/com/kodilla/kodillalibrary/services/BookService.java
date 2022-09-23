package com.kodilla.kodillalibrary.services;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.exceptions.BookNotFoundException;
import com.kodilla.kodillalibrary.mappers.BookMapper;
import com.kodilla.kodillalibrary.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.kodilla.kodillalibrary.mappers.BookMapper.mapToBook;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public Book getBookById(Long bookId) throws BookNotFoundException {

        return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    public BookDto createBook(BookDto bookDto) {

        Book savedBook = bookRepository.save(mapToBook(bookDto));
        return BookMapper.mapToDto(savedBook);
    }

    public BookDto updateBook(BookDto bookDto) throws BookNotFoundException {
        if(!bookRepository.existsById(bookDto.getBookId()))
            throw new BookNotFoundException();

        Book savedBook = bookRepository.save(mapToBook(bookDto));
        return BookMapper.mapToDto(savedBook);
    }

    public void deleteBook(Long bookId) throws BookNotFoundException {
        if(!bookRepository.existsById(bookId))
            throw new BookNotFoundException();

        bookRepository.deleteById(bookId);
    }
}
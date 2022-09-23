package com.kodilla.kodillalibrary.mappers;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public static BookDto mapToDto(Book book){
        return new BookDto(book.getBookId(),
                book.getTitle(),
                book.getAuthor(),
                book.getYearOfPublication());
    }

    public static Book mapToBook(BookDto bookDto){
        return new Book(bookDto.getBookId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getYearOfPublication());
    }
}

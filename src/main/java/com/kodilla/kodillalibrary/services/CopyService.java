package com.kodilla.kodillalibrary.services;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.Copy;
import com.kodilla.kodillalibrary.domain.Status;
import com.kodilla.kodillalibrary.exceptions.BookNotFoundException;
import com.kodilla.kodillalibrary.exceptions.CopyNotFoundException;
import com.kodilla.kodillalibrary.repositories.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyService {

    private final CopyRepository copyRepository;
    private final BookService bookService;

    public Copy saveCopy(Copy copy){
        return copyRepository.save(copy);
    }

    public List<Copy> getAllCopies(){
        return copyRepository.findAll();
    }

    public Copy getCopy(long copyId) throws CopyNotFoundException {

        return copyRepository.findById(copyId).orElseThrow(CopyNotFoundException::new);
    }

    public long countCopyByStatusAndBookId(Status status, long bookId){
        return copyRepository.countCopyByStatusAndBookId(status.toString(),bookId);
    }

    public Copy addNewCopy(long bookId) throws BookNotFoundException {
        Book book = bookService.getBookById(bookId);
        Copy copy = new Copy(0, book, Status.IN_STOCK);
        return saveCopy(copy);
    }

}

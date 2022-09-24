package com.kodilla.kodillalibrary.services;

import com.kodilla.kodillalibrary.domain.Borrow;
import com.kodilla.kodillalibrary.domain.Copy;
import com.kodilla.kodillalibrary.domain.Status;
import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.exceptions.BorrowNotFoundException;
import com.kodilla.kodillalibrary.exceptions.CopyNotFoundException;
import com.kodilla.kodillalibrary.exceptions.CopyUnavailableException;
import com.kodilla.kodillalibrary.exceptions.UserNotFoundException;
import com.kodilla.kodillalibrary.repositories.BorrowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowService {

    private final BorrowRepository borrowRepository;
    private final UserService userService;
    private final CopyService copyService;

    public List<Borrow> getAllBorrowing(){
        return borrowRepository.findAll();
    }

    public Borrow borrowedBooks(long userId, long copyId) throws UserNotFoundException, CopyNotFoundException, CopyUnavailableException {

        User user = userService.getUserById(userId);
        Copy borrowedBook = copyService.getCopy(copyId);
        if(!borrowedBook.getStatus().equals(Status.IN_STOCK))
            throw new CopyUnavailableException();

        Borrow borrow = new Borrow(0, borrowedBook, user, LocalDate.now(), LocalDate.now().plusDays(30));
        borrowedBook.setStatus(Status.BORROWED);

        copyService.saveCopy(borrowedBook);
        return  borrowRepository.save(borrow);
    }

    public void returnBook(long borrowId) throws BorrowNotFoundException {
        Borrow borrow = borrowRepository.findById(borrowId).orElseThrow(BorrowNotFoundException::new);

        Copy copy = borrow.getBorrowedBook();

        copy.setStatus(Status.IN_STOCK);
        copyService.saveCopy(copy);

        borrowRepository.delete(borrow);
    }
}

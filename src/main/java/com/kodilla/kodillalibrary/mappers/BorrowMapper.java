package com.kodilla.kodillalibrary.mappers;

import com.kodilla.kodillalibrary.domain.Borrow;
import com.kodilla.kodillalibrary.domain.BorrowDto;
import org.springframework.stereotype.Service;

@Service
public class BorrowMapper {

    public static BorrowDto mapToDto(Borrow borrow) {
        return new BorrowDto(borrow.getBorrowId(),
                borrow.getBorrowedBook(),
                borrow.getUser(),
                borrow.getLoadDate(),
                borrow.getReturnDate());
    }

    public static Borrow mapToBorrow(BorrowDto borrowDto) {
        return new Borrow(borrowDto.getBorrowId(),
                borrowDto.getBorrowedBook(),
                borrowDto.getUser(),
                borrowDto.getLoadDate(),
                borrowDto.getReturnDate());
    }

}

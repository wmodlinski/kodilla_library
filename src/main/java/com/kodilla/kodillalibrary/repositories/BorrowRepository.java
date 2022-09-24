package com.kodilla.kodillalibrary.repositories;

import com.kodilla.kodillalibrary.domain.Borrow;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BorrowRepository extends CrudRepository<Borrow, Long> {

    @Override
    List<Borrow> findAll();
}

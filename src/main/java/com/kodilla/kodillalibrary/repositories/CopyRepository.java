package com.kodilla.kodillalibrary.repositories;

import com.kodilla.kodillalibrary.domain.Copy;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CopyRepository extends CrudRepository<Copy, Long> {

    List<Copy> findAll();

    @Query(value = "SELECT count(*) FROM COPY_OF_BOOK where STATUS = :STATUS and COPY_OF_BOOK.COPY_ID = :BOOK_ID")

    long countCopyByStatusAndBookId(
            @Param("STATUS") String status, @Param("BOOK_ID") long bookId);
}

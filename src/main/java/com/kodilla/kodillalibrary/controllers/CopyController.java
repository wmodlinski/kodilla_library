package com.kodilla.kodillalibrary.controllers;

import com.kodilla.kodillalibrary.domain.Copy;
import com.kodilla.kodillalibrary.domain.CopyDto;
import com.kodilla.kodillalibrary.domain.Status;
import com.kodilla.kodillalibrary.exceptions.BookNotFoundException;
import com.kodilla.kodillalibrary.exceptions.CopyNotFoundException;
import com.kodilla.kodillalibrary.exceptions.IllegalBookStatusException;
import com.kodilla.kodillalibrary.mappers.CopyMapper;
import com.kodilla.kodillalibrary.services.CopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/copy")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CopyController {

    private final CopyService copyService;
    private final CopyMapper copyMapper;

    @GetMapping
    public ResponseEntity<List<Copy>> getCopies(){
        return ResponseEntity.ok(copyService.getAllCopies());
    }

    @GetMapping(value = "{copyId}")
    public ResponseEntity<Long> countAvailableCopyByBookId(@PathVariable long bookId){
        return ResponseEntity.ok(copyService.countCopyByStatusAndBookId(Status.IN_STOCK, bookId));
    }

    @PostMapping(value = "{bookId}")
    public ResponseEntity<Void> addNewCopy(@PathVariable Long bookId) throws BookNotFoundException {
        copyService.addNewCopy(bookId);

        return ResponseEntity.ok().build();

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCopyStatus(@RequestBody CopyDto copyDto) throws IllegalBookStatusException, CopyNotFoundException {
        Copy copy = copyMapper.mapToCopy(copyDto);
        copyService.saveCopy(copy);

        return ResponseEntity.ok().build();
    }

}

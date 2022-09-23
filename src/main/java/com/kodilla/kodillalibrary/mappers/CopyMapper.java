package com.kodilla.kodillalibrary.mappers;

import com.kodilla.kodillalibrary.domain.Copy;
import com.kodilla.kodillalibrary.domain.CopyDto;
import com.kodilla.kodillalibrary.domain.Status;
import com.kodilla.kodillalibrary.exceptions.CopyNotFoundException;
import com.kodilla.kodillalibrary.exceptions.IllegalBookStatusException;
import com.kodilla.kodillalibrary.services.CopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CopyMapper {

    private final CopyService copyService;

    public Copy mapToCopy(CopyDto copyDto) throws CopyNotFoundException, IllegalBookStatusException {

        Copy copy = copyService.getCopy(copyDto.getCopyId());

        try {
            Status status = Status.valueOf(copyDto.getStatus());
            copy.setStatus(status);
            return copy;
        }catch (Exception e){
            throw new IllegalBookStatusException();
        }
    }
}

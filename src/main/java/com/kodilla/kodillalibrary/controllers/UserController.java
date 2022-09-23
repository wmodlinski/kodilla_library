package com.kodilla.kodillalibrary.controllers;

import com.kodilla.kodillalibrary.domain.UserDto;
import com.kodilla.kodillalibrary.exceptions.UserNotFoundException;
import com.kodilla.kodillalibrary.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(value = "{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) throws UserNotFoundException{
        return ResponseEntity.ok(userService.updateUser(userDto));
    }

    @DeleteMapping(value = "{userId}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable UserDto userDto) throws UserNotFoundException{
        userService.deleteUser(userDto.getId());
        return ResponseEntity.ok().build();
    }
}
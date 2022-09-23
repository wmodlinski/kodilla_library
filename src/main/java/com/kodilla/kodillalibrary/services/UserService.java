package com.kodilla.kodillalibrary.services;

import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.domain.UserDto;
import com.kodilla.kodillalibrary.exceptions.UserNotFoundException;
import com.kodilla.kodillalibrary.mappers.UserMapper;
import com.kodilla.kodillalibrary.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.kodilla.kodillalibrary.mappers.UserMapper.mapToDto;
import static com.kodilla.kodillalibrary.mappers.UserMapper.mapToUser;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public User getUserById(Long userId) throws UserNotFoundException {

        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    public UserDto createUser(UserDto userDto) {

        User savedUser = userRepository.save(mapToUser(userDto));
        return mapToDto(savedUser);
    }

    public UserDto updateUser(UserDto userDto) throws UserNotFoundException {
        if(!userRepository.existsById(userDto.getUserId()))
            throw new UserNotFoundException();

        User savedUser = userRepository.save(mapToUser(userDto));
        return mapToDto(savedUser);
    }

    public void deleteUser(Long userId) throws UserNotFoundException {
        if(!userRepository.existsById(userId))
            throw new UserNotFoundException();

        userRepository.deleteById(userId);
    }
}
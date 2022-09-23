package com.kodilla.kodillalibrary.mappers;

import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.domain.UserDto;

public class UserMapper {

    public static UserDto mapToDto(User user){
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getSecondName(),
                user.getCreateAccount());
    }

    public static User mapToUser(UserDto userDto){
        return new User(userDto.getId(),
                userDto.getFirstName(),
                userDto.getSecondName(),
                userDto.getCreateAccount());
    }
}

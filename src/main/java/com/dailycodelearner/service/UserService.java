package com.dailycodelearner.service;

import com.dailycodelearner.dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto addUser(UserDto userDto);
    public List<UserDto> getAllUsers();

    public UserDto getUserById(Long id);

    public UserDto updateUserById(Long id,UserDto userDto);

    public String deleteUserById(Long id);

}

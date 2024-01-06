package com.dailycodelearner.controller;

import com.dailycodelearner.dto.UserDto;
import com.dailycodelearner.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto dto = userService.addUser(userDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getAllUserById(@PathVariable("id") Long id){
        UserDto users = userService.getUserById(id);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable("id") Long id,@RequestBody UserDto userDto){
        UserDto users = userService.updateUserById(id,userDto);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        String str = userService.deleteUserById(id);
        return ResponseEntity.ok(str);
    }
}

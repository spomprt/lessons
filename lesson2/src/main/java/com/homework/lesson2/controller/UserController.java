package com.homework.lesson2.controller;

import com.homework.lesson2.entity.UserDto;
import com.homework.lesson2.entity.UserUpdateDto;
import com.homework.lesson2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void create(@RequestBody UserDto user) {
        userService.create(user);
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{username}")
    public UserDto read(@PathVariable("username") String username) {
        return userService.read(username);
    }

    @PutMapping("{username}")
    public void update(@PathVariable("username") String username, @RequestBody UserUpdateDto updateDto) {
        userService.update(username, updateDto);
    }

    @DeleteMapping("{username}")
    public void delete(@PathVariable("username") String username) {
        userService.delete(username);
    }

}

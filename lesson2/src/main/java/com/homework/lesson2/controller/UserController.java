package com.homework.lesson2.controller;

import com.homework.lesson2.entity.User;
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
    public List<User> create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{username}")
    public User read(@PathVariable("username") String username) {
        return userService.read(username);
    }

    @PutMapping("{username}")
    public List<User> update(@PathVariable("username") String username, @RequestBody UserUpdateDto updateDto) {
        return userService.update(username, updateDto);
    }

    @DeleteMapping("{username}")
    public List<User> delete(@PathVariable("username") String username) {
        return userService.delete(username);
    }


}

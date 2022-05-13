package com.homework.lesson2.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.lesson2.entity.User;
import com.homework.lesson2.entity.UserUpdateDto;
import com.homework.lesson2.exception.BadRequestException;
import com.homework.lesson2.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;

    public List<User> create(User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }

    public User read(String username) {
        return userRepository.findById(username).orElseThrow(BadRequestException::new);
    }

    public List<User> update(String username, UserUpdateDto updateDto) {
        User user = userRepository.findById(username).orElseThrow(BadRequestException::new);
        User result;
        try {
            result = objectMapper.updateValue(user, updateDto);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e.getMessage());
        }
        userRepository.save(result);
        return userRepository.findAll();
    }

    public List<User> delete(String username) {
        userRepository.delete(userRepository.findById(username).orElseThrow(BadRequestException::new));
        return userRepository.findAll();
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}

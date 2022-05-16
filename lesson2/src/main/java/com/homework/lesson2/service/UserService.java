package com.homework.lesson2.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.lesson2.entity.User;
import com.homework.lesson2.entity.UserDto;
import com.homework.lesson2.entity.UserUpdateDto;
import com.homework.lesson2.exception.BadRequestException;
import com.homework.lesson2.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;

    public void create(UserDto userDto) {
        User user = objectMapper.convertValue(userDto, User.class);
        userRepository.save(user);
    }

    public UserDto read(String username) {
        User user = userRepository.findById(username).orElseThrow(BadRequestException::new);
        return objectMapper.convertValue(user, UserDto.class);
    }

    public void update(String username, UserUpdateDto updateDto) {
        User user = userRepository.findById(username).orElseThrow(BadRequestException::new);
        User result;
        try {
            result = objectMapper.updateValue(user, updateDto);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e.getMessage());
        }
        userRepository.save(result);
    }

    public void delete(String username) {
        userRepository.delete(userRepository.findById(username).orElseThrow(BadRequestException::new));
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> objectMapper.convertValue(user, UserDto.class))
                .collect(Collectors.toList());
    }
}

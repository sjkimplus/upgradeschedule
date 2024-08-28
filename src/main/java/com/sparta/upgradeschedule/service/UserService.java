package com.sparta.upgradeschedule.service;

import com.sparta.upgradeschedule.dto.UserRequestDto;
import com.sparta.upgradeschedule.dto.UserResponseDto;
import com.sparta.upgradeschedule.entity.User;
import com.sparta.upgradeschedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserRequestDto requestDto) {
        User user = new User();
        user.setUsername(requestDto.getUsername());
        user.setEmail(requestDto.getEmail());
        userRepository.save(user);
    }


    public void updateUser(Long id, String email) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found"));

        user.setEmail(email);
    }

    public UserResponseDto getUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
        return new UserResponseDto(user);
    }

    public User returnUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
        return user;
    }

    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}

package com.sparta.upgradeschedule.controller;

import com.sparta.upgradeschedule.dto.UserRequestDto;
import com.sparta.upgradeschedule.dto.UserResponseDto;
import com.sparta.upgradeschedule.entity.User;
import com.sparta.upgradeschedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    // 저장
    @PostMapping("/users")
    public void createUser(@RequestBody UserRequestDto requestDto) {
          userService.createUser(requestDto);
    }

    // 수정
    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable("id") long id, @RequestParam("email") String email) {
        userService.updateUser(id, email);
    }

    // 단건 조회
    @GetMapping("/users/{id}")
    public UserResponseDto getUser(@PathVariable("id") long id) {
        return userService.getUser(id);
    }

    // 전제 조회
    @GetMapping("/users")
    public List<UserResponseDto> getUsers() {
        return userService.getUsers();
    }

    // 삭제
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }


}

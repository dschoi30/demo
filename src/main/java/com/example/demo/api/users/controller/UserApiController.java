package com.example.demo.api.users.controller;

import com.example.demo.domain.users.dto.UserResponseDto;
import com.example.demo.domain.users.dto.UserSaveDto;
import com.example.demo.domain.users.dto.UserUpdateDto;
import com.example.demo.domain.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/users")
    public Long createUser(@RequestBody UserSaveDto userSaveDto) {

        return userService.save(userSaveDto);
    }

    @PutMapping("/api/v1/users/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) {

        return userService.update(id, userUpdateDto);
    }
}

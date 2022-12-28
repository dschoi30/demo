package com.example.demo.domain.users.controller;

import com.example.demo.domain.users.dto.UserResponseDto;
import com.example.demo.domain.users.dto.UserSaveDto;
import com.example.demo.domain.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/users/new")
    public String createForm(Model model) {

        model.addAttribute("user", new UserSaveDto());

        return "users/userCreationForm";
    }

    @GetMapping("/users/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {

        UserResponseDto dto = userService.findById(id);
        model.addAttribute("user", dto);

        return "users/userUpdateForm";
    }
}

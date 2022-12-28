package com.example.demo.domain.users.service;

import com.example.demo.domain.users.User;
import com.example.demo.domain.users.dto.UserResponseDto;
import com.example.demo.domain.users.dto.UserSaveDto;
import com.example.demo.domain.users.dto.UserUpdateDto;
import com.example.demo.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveDto userSaveDto) {
        return userRepository.save(userSaveDto.toEntity()).getId();
    }

    public Long update(Long id, UserUpdateDto userUpdateDto) {

        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));
        user.update(userUpdateDto.getPassword(), userUpdateDto.getAddress());

        return user.getId();
    }

    public UserResponseDto findById(Long id) {

        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));

        return new UserResponseDto(entity);
    }
}

package com.example.demo.domain.users.service;

import com.example.demo.domain.users.Address;
import com.example.demo.domain.users.User;
import com.example.demo.domain.users.dto.UserResponseDto;
import com.example.demo.domain.users.dto.UserSaveDto;
import com.example.demo.domain.users.dto.UserUpdateDto;
import com.example.demo.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveDto userSaveDto) {
        User user = userSaveDto.toEntity();
        validateDuplicatedUser(user);
        return userRepository.save(userSaveDto.toEntity()).getId();
    }

    private void validateDuplicatedUser(User user) {
        User findUser = userRepository.findByName(user.getName());
        if(findUser != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Transactional
    public Long update(Long id, UserUpdateDto userUpdateDto) {

        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));
        user.update(userUpdateDto.getPassword(), userUpdateDto.getEmail(), new Address(userUpdateDto.getZipCode(), userUpdateDto.getAddress(), userUpdateDto.getSubAddress()));

        return user.getId();
    }

    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));

        return new UserResponseDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
        userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByName(name);

        if(user == null) {
            throw new UsernameNotFoundException(name);
        }

        return User.builder()
                .build();
    }
}

package com.example.demo.domain.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER", "일반 회원"),
    SELLER("ROLE_SELLER", "판매자 회원"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String description;

}

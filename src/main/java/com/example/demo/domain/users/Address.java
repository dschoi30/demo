package com.example.demo.domain.users;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Embeddable
public class Address {

    private int zipCode;
    private String address;
    private String subAddress;

    @Builder
    public Address(int zipCode, String address, String subAddress) {
        this.zipCode = zipCode;
        this.address = address;
        this.subAddress = subAddress;
    }
}

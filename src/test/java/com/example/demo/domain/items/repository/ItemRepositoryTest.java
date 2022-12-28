package com.example.demo.domain.items.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ItemRepositoryTest {

    @Autowired ItemRepository itemRepository;

    @Test
    public void 등록_테스트() throws Exception {
        //given
//        itemRepository.save();
        //when

        //then

    }
}
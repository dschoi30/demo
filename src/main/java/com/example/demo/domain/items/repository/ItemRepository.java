package com.example.demo.domain.items.repository;

import com.example.demo.domain.items.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

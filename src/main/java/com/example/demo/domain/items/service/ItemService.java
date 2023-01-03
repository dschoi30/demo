package com.example.demo.domain.items.service;

import com.example.demo.domain.items.Item;
import com.example.demo.domain.items.dto.ItemResponseDto;
import com.example.demo.domain.items.dto.ItemSaveDto;
import com.example.demo.domain.items.dto.ItemUpdateDto;
import com.example.demo.domain.items.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Long save(ItemSaveDto itemSaveDto) {
        return itemRepository.save(itemSaveDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ItemUpdateDto itemUpdateDto) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id = " + id));
        item.update(itemUpdateDto.getItemName(),
                itemUpdateDto.getPrice(),
                itemUpdateDto.getStockQuantity(),
                itemUpdateDto.getContent(),
                itemUpdateDto.isOnSale(),
                itemUpdateDto.getItemImages());
        return item.getId();
    }

    public ItemResponseDto findById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id = " + id));

        return new ItemResponseDto(item);
    }

    @Transactional
    public void delete(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id = " + id));
        itemRepository.delete(item);
    }
}

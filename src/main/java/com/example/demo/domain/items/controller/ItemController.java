package com.example.demo.domain.items.controller;

import com.example.demo.domain.items.Item;
import com.example.demo.domain.items.dto.ItemSaveDto;
import com.example.demo.domain.items.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/items")
@Controller
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/new")
    public String createForm(Model model) {

        model.addAttribute("item", new ItemSaveDto());
        return "items/itemCreationForm";
    }
}

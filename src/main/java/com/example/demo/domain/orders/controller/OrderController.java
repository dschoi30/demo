package com.example.demo.domain.orders.controller;

import com.example.demo.domain.orders.OrderItem;
import com.example.demo.domain.orders.dto.OrderSaveDto;
import com.example.demo.domain.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order")
    public String createOrder(Model model) {
        model.addAttribute("orderSaveDto", new OrderSaveDto());
        return "order/orderForm";
    }

    @PostMapping("/order")
    public String order(@RequestParam("id") Long id,
                        @RequestParam("orderItems") List<OrderItem> orderItems,
                        @RequestParam("count") int count) {

        orderService.order(id, orderItems, count);
        return "redirect:/orders";
    }
}

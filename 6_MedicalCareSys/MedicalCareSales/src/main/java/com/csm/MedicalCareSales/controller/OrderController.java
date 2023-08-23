package com.csm.MedicalCareSales.controller;

import com.csm.MedicalCareSales.DTO.OrderDTORequest;
import com.csm.MedicalCareSales.DTO.OrderDTOResponse;
import com.csm.MedicalCareSales.Exceptions.NotFoundException;
import com.csm.MedicalCareSales.Messaging.service.OrderMessageService;
import com.csm.MedicalCareSales.Repository.OrderRepository;
import com.csm.MedicalCareSales.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMessageService orderMessageService;

    @GetMapping("list")
    public List<OrderDTOResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderDTOResponse::of)
                .collect(Collectors.toList());

    }

    @GetMapping("{id}")
    public OrderDTOResponse getOrderById(@PathVariable UUID id) {
        return orderRepository.findById(id)
                .map(OrderDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Seller Not Found"));
    }

    @PostMapping
    public OrderDTOResponse SaveOrder(@RequestBody OrderDTORequest request) {
        try {
            OrderDTOResponse order = OrderDTOResponse.of(
                    orderRepository.save(orderService.populate(request)));

            orderMessageService.sendMessage(order.getId(), request);
            return order;
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Order");
        }
    }

    @DeleteMapping("{id}")
    public String deleteOrder(@PathVariable UUID id) {
        try {
            orderRepository.deleteById(id);
            return "Sucesso";
        } catch (Exception e) {
            throw new PersistenceException("Error deleting Seller");
        }
    }

}

package com.csmaster.orderSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csmaster.orderSys.dto.OrderRequest;
import com.csmaster.orderSys.dto.OrderResponse;
import com.csmaster.orderSys.messager.config.DeliveryQueueSender;
import com.csmaster.orderSys.model.Order;
import com.csmaster.orderSys.repository.AddressRepository;
import com.csmaster.orderSys.repository.OrdersRepository;
import com.csmaster.orderSys.util.exceptions.NotFoundException;
import com.csmaster.orderSys.util.exceptions.PersistenceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/pedido")
public class OrdersController {

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private AddressRepository addressRepository;
	

    @Autowired
    private DeliveryQueueSender deliveryQueue;

	@GetMapping("lista")
	public List<Order> findAll() {
		return ordersRepository.findAll();
	}

	@GetMapping("{id}")
	public OrderResponse findById(@PathVariable Integer id) {
		return ordersRepository.findById(id).map(OrderResponse::of)
				.orElseThrow(() -> new NotFoundException("Cliente não encontrado."));
	}
	
	@PostMapping
	public OrderResponse save(@RequestBody OrderRequest request) {
		try {
	        deliveryQueue.send(request);
	    	return OrderResponse.of(ordersRepository.save(Order.of(request)));
    	} catch (Exception e) {
    		e.printStackTrace();
			throw new PersistenceException("Erro ao salvar cliente");
		}
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Integer id) {
		try {
			ordersRepository.deleteById(id);
			return "Sucesso";
		} catch (Exception e) {
			return "Houve um erro ao adicionar";
		}
	}

}

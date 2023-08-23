package com.csmaster.orderSys.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csmaster.orderSys.dto.DeliveryRequest;
import com.csmaster.orderSys.dto.DeliveryResponse;
import com.csmaster.orderSys.model.Delivery;
import com.csmaster.orderSys.model.Order;
import com.csmaster.orderSys.repository.DeliveryRepository;
import com.csmaster.orderSys.repository.OrdersRepository;
import com.csmaster.orderSys.util.exceptions.NotFoundException;
import com.csmaster.orderSys.util.exceptions.PersistenceException;

@RestController
@RequestMapping("/entrega")
public class DeliveryController {

	@Autowired
	private DeliveryRepository deliveryRepository;

	@Autowired
	private OrdersRepository orderRepository;

	@GetMapping("lista")
	public List<DeliveryResponse> findAll() {
		return deliveryRepository.findAll().stream().map(DeliveryResponse::of).collect(Collectors.toList());
	}

	@GetMapping("{id}")
	public DeliveryResponse findById(@PathVariable Integer id) {
		return deliveryRepository.findById(id).map(DeliveryResponse::of)
				.orElseThrow(() -> new NotFoundException("Cliente não encontrado."));
	}

	@PostMapping
	public DeliveryResponse save(@RequestBody DeliveryRequest request) {
		try {
			Order order = orderRepository.findById(request.getOrder().getIdOrder()).get();
			Delivery d = Delivery.builder()
					.idDelivery(request.getIdDelivery())
					.status(request.getStatus())
					.deliveredIn(request.getDeliveredIn())
					.receiver(request.getReceiver())
					.build();
			d.setOrder(order);
			return DeliveryResponse.of(deliveryRepository.save(d));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException("Erro ao salvar cliente");
		}
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Integer id) {
		try {
			deliveryRepository.deleteById(id);
			return "Sucesso";
		} catch (Exception e) {
			return "Houve um erro ao deletar a entrega...";
		}
	}

}

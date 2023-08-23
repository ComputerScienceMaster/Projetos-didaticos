package com.csmaster.orderSys.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.csmaster.orderSys.model.Order;
import com.csmaster.orderSys.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OrderResponse {
	

	private Integer idOrder;
	private Integer idClient;
	private List<Integer> idProduct;
	private AddressResponse address;
	
	
	public static List<OrderResponse> of(List<Order> orders) {
		return Objects.nonNull(orders) ? orders.stream().map(OrderResponse::of).collect(Collectors.toList())
				: null;
	}

	public static OrderResponse of(Order order) {
		return OrderResponse.builder()
				.idOrder(order.getIdOrder())
				.idClient(order.getClient().getIdClient())
				.idProduct(order.getProducts().stream().map(Product::getIdProduct).collect(Collectors.toList()))
				.address(AddressResponse.of(order.getAddress()))
				.build();
	}
}

package com.csmaster.orderSys.dto;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.csmaster.orderSys.model.Delivery;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeliveryResponse {

	private Integer idDelivery;
	private String status;
	private Date deliveredIn;
	private String receiver;
	private Integer idOrder;

	public static List<DeliveryResponse> of(List<Delivery> delivery) {
		return Objects.nonNull(delivery) ? delivery.stream().map(DeliveryResponse::of).collect(Collectors.toList()) : null;
	}

	public static DeliveryResponse of(Delivery delivery) {
		return DeliveryResponse.builder()
				.idDelivery(delivery.getIdDelivery())
				.status(delivery.getStatus())
				.deliveredIn(delivery.getDeliveredIn())
				.receiver(delivery.getReceiver())
				.idOrder(delivery.getOrder().getIdOrder())
				.build();
	}

}

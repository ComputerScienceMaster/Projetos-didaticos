package com.csmaster.orderSys.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DeliveryRequest {

	private Integer idDelivery;
	private String status;
	private Date deliveredIn;
	private String receiver;
	private OrderRequest order;

}

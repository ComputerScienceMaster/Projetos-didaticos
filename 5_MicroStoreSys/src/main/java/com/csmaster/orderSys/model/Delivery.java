package com.csmaster.orderSys.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.ui.ModelMap;

import com.csmaster.orderSys.dto.DeliveryRequest;
import com.csmaster.orderSys.dto.OrderRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@Table(name = "DELIVERY")
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_DELIVERY", sequenceName = "SEQ_DELIVERY", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DELIVERY")
	private Integer idDelivery;
	
	@Column(name="STATUS")
	private String status;
	

	@Temporal(TemporalType.DATE)
	private Date deliveredIn;
	
	@Column(name="RECEIVER")
	private String receiver;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_DELIVERY", referencedColumnName = "ID",
	foreignKey = @ForeignKey(name = "FK_DELIVERY_ORDER"))
	private Order order;

	public Delivery(Integer idDelivery) {
		this.idDelivery = idDelivery;
	}
	
	

	public static Delivery of(DeliveryRequest request) {
		
		return Delivery.builder()
				.idDelivery(request.getIdDelivery())
				.status(request.getStatus())
				.deliveredIn(request.getDeliveredIn())
				.receiver(request.getReceiver())
				.order(Order.of(request.getOrder()))
				.build();
	}
}

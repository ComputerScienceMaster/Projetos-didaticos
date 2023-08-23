package com.csmaster.orderSys.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import com.csmaster.orderSys.dto.OrderRequest;
import com.csmaster.orderSys.dto.ProductResponse;

import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDERS")
public class Order {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_ORDERS", sequenceName = "SEQ_ORDERS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ORDERS")
	private Integer idOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_CLIENT",
			referencedColumnName = "ID",
			foreignKey = @ForeignKey(name = "FK_ORDER_CLIENT"))
	private Client client;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_ADDRESS", referencedColumnName = "ID",
			foreignKey = @ForeignKey(name = "FK_ORDER_ADDRESS"))
	private Address address;

	@ManyToMany(targetEntity = Product.class)
	private List<Product> products;
	

	public Order(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public static Order of(OrderRequest request) {
		return Order.builder()
				.idOrder(request.getIdOrder())
				.client(Client.of(request.getClient()))
				.products(request.getProducts().stream().map(Product::of).collect(Collectors.toList()))
				.address(Address.of(request.getAddress()))
				.build();
	}



}

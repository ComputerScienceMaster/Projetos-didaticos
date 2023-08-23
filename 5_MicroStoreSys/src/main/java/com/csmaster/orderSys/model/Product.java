package com.csmaster.orderSys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.csmaster.orderSys.dto.ProductRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "PRODUCT")
public class Product {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_PRODUCT", sequenceName = "SEQ_PRODUCT", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PRODUCT")
	private Integer idProduct;

	@Column(name = "NAME")
	private String productName;

	@Column(name = "PRICE")
	private Double productValue;

	public Product(Integer id) {
		this.idProduct = id;
	}
	
	
	public static Product of(ProductRequest request) {
		return Product.builder()
				.idProduct(request.getId())
				.productName(request.getProductName())
				.productValue(request.getProductValue())
				.build();
	}


}

package com.csmaster.orderSys.model;

import com.csmaster.orderSys.dto.AddressRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ADDRESS")
public class Address {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_ADDRESS", sequenceName = "SEQ_ADDRESS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ADDRESS")
	private Integer idAddress;

	@Column(name = "STREET")
	private String street;

	@Column(name = "STABLISHMENT_NUMBER")
	private Integer stablishmentNumber;

	@Column(name = "NEIGHBORHOOD")
	private String neighborhood;

	@Column(name = "COMPLEMENT")
	private String complement;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	public static Address of(AddressRequest request) {
		return Address.builder()
				.idAddress(request.getId())
				.street(request.getStreet())
				.stablishmentNumber(request.getStablishmentNumber())
				.neighborhood(request.getNeighborhood())
				.complement(request.getComplement())
				.zipCode(request.getZipCode())
				.build();
	}
}

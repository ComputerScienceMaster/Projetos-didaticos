package com.csmaster.orderSys.model;

import java.util.List;

import javax.persistence.*;

import com.csmaster.orderSys.dto.ClientRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@Table(name = "CLIENT")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_CLIENT", sequenceName = "SEQ_CLIENT", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CLIENT")
	private Integer idClient;

	@Column(name = "NAME")
	private String clientName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders;

	public Client(Integer idClient) {
		this.idClient = idClient;
	}

	public static Client of(ClientRequest request) {
		return Client.builder()
				.idClient(request.getId())
				.clientName(request.getClientName())
				.build();
	}
}

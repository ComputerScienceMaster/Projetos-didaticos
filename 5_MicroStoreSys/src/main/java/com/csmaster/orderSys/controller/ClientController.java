
package com.csmaster.orderSys.controller;

import java.util.List;
import java.util.Optional;

import com.csmaster.orderSys.dto.ClientRequest;
import com.csmaster.orderSys.dto.ClientResponse;
import com.csmaster.orderSys.util.exceptions.NotFoundException;
import com.csmaster.orderSys.util.exceptions.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csmaster.orderSys.model.Client;
import com.csmaster.orderSys.repository.ClientRepository;

@Slf4j
@RestController
@RequestMapping("/cliente")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("listar")
	public List<ClientResponse> findAll() {
		return ClientResponse.of(clientRepository.findAll());
	}

	@GetMapping("{id}")
	public ClientResponse findById(@PathVariable Integer id) {
		return clientRepository.findById(id)
				.map(ClientResponse::of)
				.orElseThrow(() -> new NotFoundException("Cliente não encontrado."));
	}
	
	@PostMapping
	public ClientResponse save(@RequestBody ClientRequest request) {
		try {
			return ClientResponse.of(clientRepository.save(Client.of(request)));
		} catch (Exception e) {
			throw new PersistenceException("Erro ao salver cliente");
		}
	}

	@DeleteMapping("{id}")
	public String update(@PathVariable Integer id) {
		try {
			clientRepository.deleteById(id);
			return "Sucesso";
		} catch (Exception e) {
			return "Houve um erro ao remover o cliente";
		}
	}

}

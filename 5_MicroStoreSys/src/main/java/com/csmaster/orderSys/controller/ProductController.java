package com.csmaster.orderSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csmaster.orderSys.dto.ClientResponse;
import com.csmaster.orderSys.dto.ProductRequest;
import com.csmaster.orderSys.dto.ProductResponse;
import com.csmaster.orderSys.model.Client;
import com.csmaster.orderSys.model.Product;
import com.csmaster.orderSys.repository.ProductRepository;
import com.csmaster.orderSys.util.exceptions.NotFoundException;
import com.csmaster.orderSys.util.exceptions.PersistenceException;

@RestController
@RequestMapping("/produto")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("lista")
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@GetMapping("{id}")
	public ProductResponse findById(@PathVariable Integer id) {
		return productRepository.findById(id).map(ProductResponse::of)
				.orElseThrow(() -> new NotFoundException("Cliente não encontrado."));

	}

	@PostMapping
	public ProductResponse save(@RequestBody ProductRequest request) {
		try {
			return ProductResponse.of(productRepository.save(Product.of(request)));
		} catch (Exception e) {
			throw new PersistenceException("Erro ao salver cliente");
		}
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Integer id) {
		try {
			productRepository.deleteById(id);
			return "Sucesso";
		} catch (Exception e) {
			throw new PersistenceException("Erro ao remover cliente");
		}
	}

}

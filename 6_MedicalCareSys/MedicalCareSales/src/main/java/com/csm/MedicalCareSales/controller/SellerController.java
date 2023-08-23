package com.csm.MedicalCareSales.controller;

import com.csm.MedicalCareSales.DTO.SellerDTORequest;
import com.csm.MedicalCareSales.DTO.SellerDTOResponse;
import com.csm.MedicalCareSales.Exceptions.NotFoundException;
import com.csm.MedicalCareSales.Model.Seller;
import com.csm.MedicalCareSales.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("seller")
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;

    @GetMapping("list")
    public List<SellerDTOResponse> getAllSellers(){
        return sellerRepository.findAll()
                .stream()
                .map(SellerDTOResponse::of)
                .collect(Collectors.toList());

    }

    @GetMapping("{id}")
    public SellerDTOResponse getSellerById(@PathVariable UUID id){
        return sellerRepository.findById(id)
                .map(SellerDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Seller Not Found"));
    }

    @PostMapping
    public SellerDTOResponse SaveSeller(@RequestBody SellerDTORequest request) {
        try {
            return SellerDTOResponse.of(sellerRepository.save(Seller.of(request)));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Seller");
        }
    }

    @DeleteMapping("{id}")
    public String deleteSeller(@PathVariable UUID id){
        try {

            sellerRepository.deleteById(id);
            return "Sucesso";
        }catch (Exception e){
            throw new PersistenceException("Error deleting Seller");
        }
    }

}

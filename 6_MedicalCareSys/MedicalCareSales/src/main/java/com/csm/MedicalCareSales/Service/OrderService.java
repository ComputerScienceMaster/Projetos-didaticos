package com.csm.MedicalCareSales.Service;

import com.csm.MedicalCareSales.DTO.OrderDTORequest;
import com.csm.MedicalCareSales.ENUM.Channel;
import com.csm.MedicalCareSales.Exceptions.PersistenceException;
import com.csm.MedicalCareSales.Model.Order;
import com.csm.MedicalCareSales.Model.Seller;
import com.csm.MedicalCareSales.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {


    @Autowired
    private SellerRepository sellerRepository;


    public Order populate(OrderDTORequest request){
        Channel channel = Channel.valueOf(request.getChannel());
        Optional<Seller> seller = sellerRepository.findById(request.getSeller());
        UUID patient = request.getPatient();

        return Order.builder()
                .id(request.getId())
                .saleDate(request.getSaleDate())
                .channel(channel)
                .seller(seller.orElseThrow( () -> new PersistenceException("Seller Not Found")))
                .patient(patient)
                .build();
    }
}

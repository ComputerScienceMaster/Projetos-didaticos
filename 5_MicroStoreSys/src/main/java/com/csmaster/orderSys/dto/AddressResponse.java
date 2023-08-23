package com.csmaster.orderSys.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.csmaster.orderSys.model.Address;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponse {

    private Integer id;
    private String street;
    private Integer stablishmentNumber;
    private String neighborhood;
    private String complement;
    private String zipCode;
    
    public static List<AddressResponse> of(List<Address> address) {
        return Objects.nonNull(address)
                ? address.stream().map(AddressResponse::of).collect(Collectors.toList())
                : null;
    }

    public static AddressResponse of(Address address) {
        return AddressResponse.builder()
                .id(address.getIdAddress())
                .street(address.getStreet())
                .stablishmentNumber(address.getStablishmentNumber())
                .neighborhood(address.getNeighborhood())
                .complement(address.getComplement())
                .zipCode(address.getZipCode())
                .build();
    }

}

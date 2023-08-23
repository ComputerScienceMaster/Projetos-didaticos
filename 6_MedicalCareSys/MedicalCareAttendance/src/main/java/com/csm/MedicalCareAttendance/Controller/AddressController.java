package com.csm.MedicalCareAttendance.Controller;

import com.csm.MedicalCareAttendance.DTO.AddressDTORequest;
import com.csm.MedicalCareAttendance.DTO.AddressDTOResponse;
import com.csm.MedicalCareAttendance.Model.Address;
import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import com.csm.MedicalCareAttendance.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;


    @GetMapping("list")
    public List<AddressDTOResponse> getAllAddresses(){
        return addressRepository.findAll()
                .stream()
                .map(AddressDTOResponse::of)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public AddressDTOResponse getAddressByID(@PathVariable(value = "id") UUID id){
        return addressRepository.findById(id)
                .map(AddressDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Patient Not Found"));
    }

    @PostMapping
    public AddressDTOResponse saveAddress(@RequestBody AddressDTORequest request) {
        try {
            return AddressDTOResponse.of(addressRepository.save(Address.of(request)));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Patient");
        }
    }


    @DeleteMapping("{id}")
    public String deleteAddress(@PathVariable UUID id){
        try {
            addressRepository.deleteById(id);
            return "Success";
        }catch (Exception e){
            throw new PersistenceException("Error deleting the address");
        }
    }


}

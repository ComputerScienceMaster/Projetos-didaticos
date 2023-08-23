package com.csm.MedicalCareAttendance.Service;

import com.csm.MedicalCareAttendance.DTO.PatientDTORequest;
import com.csm.MedicalCareAttendance.Model.Address;
import com.csm.MedicalCareAttendance.Model.Patient;
import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import com.csm.MedicalCareAttendance.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private AddressRepository addressRepository;

    public Patient populate(PatientDTORequest request) {
        Address address = addressRepository.findById(request.getAddress())
                .orElseThrow(()-> new NotFoundException("Address not found"));
        return Patient.of(request, address);
    }
}

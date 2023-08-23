package com.csm.MedicalCareAttendance.Controller;

import com.csm.MedicalCareAttendance.DTO.DoctorDTORequest;
import com.csm.MedicalCareAttendance.DTO.DoctorDTOResponse;
import com.csm.MedicalCareAttendance.Model.Doctor;
import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import com.csm.MedicalCareAttendance.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("list")
    public List<DoctorDTOResponse> getAllDoctors(){
        return doctorRepository.findAll()
                .stream()
                .map(DoctorDTOResponse::of)
                .collect(Collectors.toList());

    }

    @GetMapping("{id}")
    public DoctorDTOResponse getDoctorById(@PathVariable(value = "id") UUID id){
          return doctorRepository.findById(id)
                    .map(DoctorDTOResponse::of)
                    .orElseThrow(() -> new NotFoundException("Not found"));

    }

    @PostMapping
    public DoctorDTOResponse SaveDoctor(@RequestBody DoctorDTORequest request) {
        try {
            return DoctorDTOResponse.of(doctorRepository.save(Doctor.of(request)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException("Error saving the Doctor");
        }
    }

    @DeleteMapping("{id}")
    public String deleteDoctor(@PathVariable UUID id){
        try {

            doctorRepository.deleteById(id);
            return "Success";
        }catch (Exception e){
            throw new PersistenceException("Error deleting the doctor");
        }
    }

}

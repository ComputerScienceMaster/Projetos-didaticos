package com.csm.MedicalCareAttendance.Controller;

import com.csm.MedicalCareAttendance.DTO.MedicalAppointmentDTORequest;
import com.csm.MedicalCareAttendance.DTO.MedicalAppointmentDTOResponse;
import com.csm.MedicalCareAttendance.Model.MedicalAppointment;
import com.csm.MedicalCareAttendance.Service.MedicalAppointmentService;
import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import com.csm.MedicalCareAttendance.Repository.MedicalAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("appointment")
public class MedicalAppointmentController {

    @Autowired
    private MedicalAppointmentRepository appointmentRepository;



    @Autowired
    private MedicalAppointmentService medicalAppointmentService;

    @GetMapping("list")
    public List<MedicalAppointmentDTOResponse> getAllMedicalAppointment(){
        return appointmentRepository.findAll()
                .stream()
                .map(MedicalAppointmentDTOResponse::of)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public MedicalAppointmentDTOResponse getMedicalAppointmentByID(@PathVariable UUID id){
        return appointmentRepository.findById(id)
                .map(MedicalAppointmentDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Not found"));
    }


    @PostMapping
    public MedicalAppointmentDTOResponse SaveMedicalAppointment(@RequestBody MedicalAppointmentDTORequest request) {
        try {
            MedicalAppointment appointment = medicalAppointmentService.populate(request);
            return MedicalAppointmentDTOResponse
                    .of(appointmentRepository
                            .save(appointment));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Medical Appointment");
        }
    }


    @DeleteMapping("{id}")
    public String deleteMedicalAppointment(@PathVariable(value = "id") UUID id){
        try {
            appointmentRepository.deleteById(id);
            return "Success";
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Error deleting the medical appointment");

        }
    }
}

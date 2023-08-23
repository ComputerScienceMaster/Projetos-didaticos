package com.csm.MedicalCareAttendance.Controller;

import com.csm.MedicalCareAttendance.DTO.ExaminationDTORequest;
import com.csm.MedicalCareAttendance.DTO.ExaminationDTOResponse;
import com.csm.MedicalCareAttendance.Model.Examination;
import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import com.csm.MedicalCareAttendance.Repository.ExaminationRepository;
import com.csm.MedicalCareAttendance.Repository.MedicalAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("examination")
public class ExaminationController {


    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private MedicalAppointmentRepository appointmentRepository;

    @GetMapping("list")
    public List<ExaminationDTOResponse> getAllExamination(){
        return examinationRepository.findAll()
                .stream()
                .map(ExaminationDTOResponse::of)
                .collect(Collectors.toList());

    }

    @GetMapping("{id}")
    public ExaminationDTOResponse getExaminationById(@PathVariable UUID id){
        return examinationRepository.findById(id)
                .map(ExaminationDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Not Found"));
    }

    @PostMapping
    public ExaminationDTOResponse SaveExamination(@RequestBody ExaminationDTORequest request) {
        try {
            Examination ex = Examination.of(request);
            ex.setMedicalAppointment(
                    appointmentRepository.findById(request.getMedicalAppointmentId())
                            .orElseThrow( ()-> new NotFoundException("Medical Appointment Not Found")));
            return ExaminationDTOResponse.of(examinationRepository.save(ex));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Examination");
        }
    }

    @DeleteMapping("{id}")
    public String deleteExamination(@PathVariable UUID id){
        try {

            examinationRepository.deleteById(id);
            return "Sucesso";
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Error deleting the examination");
        }
    }




}

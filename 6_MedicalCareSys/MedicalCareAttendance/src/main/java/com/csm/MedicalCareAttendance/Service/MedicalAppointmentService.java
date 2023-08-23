package com.csm.MedicalCareAttendance.Service;

import com.csm.MedicalCareAttendance.DTO.MedicalAppointmentDTORequest;
import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import com.csm.MedicalCareAttendance.Model.MedicalAppointment;
import com.csm.MedicalCareAttendance.Repository.DoctorRepository;
import com.csm.MedicalCareAttendance.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalAppointmentService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public MedicalAppointment populate(MedicalAppointmentDTORequest request) {
        MedicalAppointment toReturn = MedicalAppointment.of(request);
        toReturn.setDoctor(doctorRepository.findById(request.getDoctor())
                .orElseThrow(() -> new NotFoundException("Doctor Not Found")));
        toReturn.setPatient(patientRepository.findById(request.getPatient())
                .orElseThrow(()-> new NotFoundException("Patient Not Found")));
        return toReturn;
    }
}

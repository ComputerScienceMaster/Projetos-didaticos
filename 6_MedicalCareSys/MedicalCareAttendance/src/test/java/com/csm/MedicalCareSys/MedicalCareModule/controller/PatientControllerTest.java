package com.csm.MedicalCareSys.MedicalCareModule.controller;

import com.csm.MedicalCareAttendance.DTO.PatientDTORequest;
import com.csm.MedicalCareAttendance.Controller.PatientController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PatientControllerTest {

    @Mock
    PatientController patientController;

    PatientDTORequest p;



    @BeforeEach
    public void init(){
        // arrange
        p = PatientDTORequest.builder()
                .name("Vinicius dos Santos")
                .email("vinicius@gmail.com")
                .phone("31853185318")
                .gender("male")
                .build();

    }


    @Test
    @DisplayName("Should Save the patient successfully")
    void savePatient() {


    }
}
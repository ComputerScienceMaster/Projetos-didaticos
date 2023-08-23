package com.csm.MedicalCareSales.Model;

import com.csm.MedicalCareSales.DTO.InsuranceDTORequest;
import com.csm.MedicalCareSales.ENUM.Coverage;
import com.csm.MedicalCareSales.ENUM.InsuranceStatus;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "INSURANCE")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "COVERAGE")
    private Coverage coverage;

    @Column(name = "MONTH_VALUE")
    private Double monthValue;

    @Column(name = "STATUS")
    private InsuranceStatus status;

    public static Insurance of(InsuranceDTORequest d) {
        return Insurance.builder()
                .id(d.getId())
                .coverage(Coverage.valueOf(d.getCoverage()))
                .monthValue(d.getMonthValue())
                .status(InsuranceStatus.valueOf(d.getStatus()))
                .build();
    }


}
package com.csm.MedicalCareSales.Model;

import com.csm.MedicalCareSales.DTO.OrderDTORequest;
import com.csm.MedicalCareSales.ENUM.Channel;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "ORDERS")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "SALE_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate saleDate;


    @Column(name = "CHANNEL")
    @Enumerated(EnumType.STRING)
    private Channel channel;

    @Column(name="PATIENT")
    private UUID patient;

    @ManyToOne
    @JoinColumn(name = "FK_SELLER", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_SELLER"))
    private Seller seller;


    @Nullable
    @OneToOne
    @JoinColumn(name = "FK_INSURANCE", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_INSURANCE"), nullable = true)
    private Insurance insurance;

    public static Order of (OrderDTORequest d){
        return Order.builder()
                .id(d.getId())
                .saleDate(d.getSaleDate())
                .patient(d.getPatient())
                .channel(Channel.valueOf(d.getChannel()))
                .seller(Seller.builder().id(d.getSeller()).build())
                .insurance(Insurance.builder().id(d.getInsurance()).build())
                .build();
    }


}
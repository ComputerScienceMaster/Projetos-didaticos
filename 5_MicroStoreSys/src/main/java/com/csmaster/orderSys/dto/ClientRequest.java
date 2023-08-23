package com.csmaster.orderSys.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClientRequest implements Serializable{

    private Integer id;
    private String clientName;

}

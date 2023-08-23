package com.csmaster.orderSys.dto;

import com.csmaster.orderSys.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class ClientResponse {

    private Integer id;
    private String name;

    public static List<ClientResponse> of(List<Client> clients) {
        return Objects.nonNull(clients)
                ? clients.stream().map(ClientResponse::of).collect(Collectors.toList())
                : null;
    }

    public static ClientResponse of(Client client) {
        return ClientResponse.builder()
                .id(client.getIdClient())
                .name(client.getClientName())
                .build();
    }
}

package com.br.equipamentreader.entrypoint.resource.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class EquipmentResponse {

    private String id;
    private String name;
    private String temp;
}

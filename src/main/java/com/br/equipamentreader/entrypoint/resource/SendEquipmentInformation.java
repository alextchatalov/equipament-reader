package com.br.equipamentreader.entrypoint.resource;

import com.br.equipamentreader.core.usecase.GetAllEquipmentsUseCase;
import com.br.equipamentreader.dataprovider.entity.Equipment;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class SendEquipmentInformation {

    private final GetAllEquipmentsUseCase getAllEquipmentsUseCase;
    private final ObjectMapper objectMapper;

    @GetMapping(value = "/{clientName}/equipments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Equipment> getEquipments(@PathVariable("clientName") final String clientName) {
        
        return getAllEquipmentsUseCase.execute(clientName);

    }
}

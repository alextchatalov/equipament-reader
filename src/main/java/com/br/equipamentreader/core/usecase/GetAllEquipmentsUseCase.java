package com.br.equipamentreader.core.usecase;

import com.br.equipamentreader.dataprovider.entity.Equipment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class GetAllEquipmentsUseCase {

    private final GetAllEquipmentsBoundary getAllEquipmentsBoundary;


    public List<Equipment> execute(final String clientName) {

        return getAllEquipmentsBoundary.execute(clientName);
    }
}

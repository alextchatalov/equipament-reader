package com.br.equipamentreader.dataprovider.gateway;

import com.br.equipamentreader.core.usecase.GetAllEquipmentsBoundary;
import com.br.equipamentreader.dataprovider.entity.Equipment;
import com.br.equipamentreader.dataprovider.repository.MongoDbRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class GetAllEquipmentsGateway implements GetAllEquipmentsBoundary {

    private final MongoDbRepository repository;

    @Override
    public List<Equipment> execute(final String client) {
        return repository.findAll();
    }
}

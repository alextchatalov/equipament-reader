package com.br.equipamentreader.core.usecase;

import com.br.equipamentreader.dataprovider.entity.Equipment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class ReadFromDataBaseUseCase {

    private final FindEquipmentTempBoundary findEquipmentTempBoundary;
    private final MongoTemplate mongoTemplate;

    public void execute() {
        final List<Equipment> equipmentReaders = findEquipmentTempBoundary.execute();
        equipmentReaders.stream().forEach(a -> mongoTemplate.save(a));


    }

}

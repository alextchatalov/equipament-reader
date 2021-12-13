package com.br.equipamentreader.core.usecase;

import com.br.equipamentreader.dataprovider.entity.reader.EquipmentReader;
import com.br.equipamentreader.dataprovider.entity.write.EquipmentWrite;
import com.br.equipamentreader.dataprovider.gateway.FindEquipmentTempGateway;
import com.br.equipamentreader.dataprovider.repository.write.MongoDbRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class ReadFromDataBaseUseCase  {

    private final FindEquipmentTempGateway findEquipmentTempGateway;
    private final MongoTemplate mongoTemplate;

    public void execute() {
        List<EquipmentReader> equipmentReaders = findEquipmentTempGateway.execute();
        equipmentReaders.stream().forEach(a -> mongoTemplate.save(a));


    }

}

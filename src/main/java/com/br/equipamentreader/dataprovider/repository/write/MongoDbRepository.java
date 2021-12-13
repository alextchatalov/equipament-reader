package com.br.equipamentreader.dataprovider.repository.write;

import com.br.equipamentreader.dataprovider.entity.write.EquipmentWrite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDbRepository extends MongoRepository<EquipmentWrite, Long> {
}

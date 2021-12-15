package com.br.equipamentreader.dataprovider.repository.write;

import com.br.equipamentreader.dataprovider.entity.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDbRepository extends MongoRepository<Equipment, Long> {
}

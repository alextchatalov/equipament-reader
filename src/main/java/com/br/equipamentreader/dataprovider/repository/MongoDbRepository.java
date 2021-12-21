package com.br.equipamentreader.dataprovider.repository;

import com.br.equipamentreader.dataprovider.entity.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoDbRepository extends MongoRepository<Equipment, Long> {

    List<Equipment> findAllByClientName(String clientName);
}

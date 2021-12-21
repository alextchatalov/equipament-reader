package com.br.equipamentreader.core.usecase;

import com.br.equipamentreader.dataprovider.entity.Equipment;

import java.util.List;

public interface GetAllEquipmentsBoundary {

    List<Equipment> execute(String client);
}

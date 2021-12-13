package com.br.equipamentreader.core.usecase;

import com.br.equipamentreader.dataprovider.entity.reader.EquipmentReader;

import java.util.List;

public interface FindEquipmentTempBoundary {

    List<EquipmentReader> execute();
}

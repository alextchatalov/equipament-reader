package com.br.equipamentreader.core.usecase;

import com.br.equipamentreader.dataprovider.entity.reader.EquipmentReader;
import com.br.equipamentreader.dataprovider.gateway.FindEquipmentTempGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class ReadFromDataBaseUseCase  {

    private final FindEquipmentTempGateway findEquipmentTempGateway;

    public void execute() {
        List<EquipmentReader> equipmentReaders = findEquipmentTempGateway.execute();
        equipmentReaders.stream().forEach(a -> System.out.println(a.getName() + " - " + a.getTemp()));
    }

}

package com.br.equipamentreader.dataprovider.entity.reader;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentReader {

    private Long id;
    private String name;
    private String temp;
}

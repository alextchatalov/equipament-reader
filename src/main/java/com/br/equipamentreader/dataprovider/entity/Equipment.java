package com.br.equipamentreader.dataprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "equipment")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {

    @Id
    private String id;
    private String name;
    private String temp;
    private String clientName;
}

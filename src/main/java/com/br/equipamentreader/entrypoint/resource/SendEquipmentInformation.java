package com.br.equipamentreader.entrypoint.resource;

import com.br.equipamentreader.core.usecase.FindEquipmentTempBoundary;
import com.br.equipamentreader.dataprovider.entity.Equipment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class SendEquipmentInformation {

    private final FindEquipmentTempBoundary findEquipmentTempBoundary;

    @GetMapping("/temp")
    public List<Equipment> getPessonalAccounts() {
        final List<Equipment> equipmentList = findEquipmentTempBoundary.execute();

        return equipmentList;
    }
}

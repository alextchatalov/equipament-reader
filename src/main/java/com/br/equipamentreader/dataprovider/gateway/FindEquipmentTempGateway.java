package com.br.equipamentreader.dataprovider.gateway;

import com.br.equipamentreader.core.usecase.FindEquipmentTempBoundary;
import com.br.equipamentreader.dataprovider.entity.reader.EquipmentReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class FindEquipmentTempGateway implements FindEquipmentTempBoundary {


    @Value( "${postgres.datasource.url}" )
    private String jdbcUrl;

    @Value( "${postgres.datasource.username}" )
    private String username;

    @Value( "${postgres.datasource.password}" )
    private String password;

    @Value( "${postgres.datasource.query}" )
    private String query;

    @Override
    public List<EquipmentReader> execute() {
        List<EquipmentReader> equipmentReaders = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                jdbcUrl, username, password);
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                String temperature = resultSet.getString("TEMP");

                EquipmentReader equipmentReader = EquipmentReader.builder().id(id).name(name).temp(temperature).build();
                equipmentReaders.add(equipmentReader);

            }
            equipmentReaders.forEach(x -> System.out.println(x));

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipmentReaders;
    }
}

package com.br.equipamentreader.dataprovider.gateway;

import com.br.equipamentreader.core.usecase.FindEquipmentTempBoundary;
import com.br.equipamentreader.dataprovider.entity.Equipment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class FindEquipmentTempGateway implements FindEquipmentTempBoundary {


    @Value("${postgres.datasource.url}")
    private String jdbcUrl;

    @Value("${postgres.datasource.username}")
    private String username;

    @Value("${postgres.datasource.password}")
    private String password;

    @Value("${postgres.datasource.query}")
    private String query;

    @Value("${equipment.client.name}")
    private String clientName;

    @Override
    public List<Equipment> execute() {
        final List<Equipment> equipmentReaders = new ArrayList<>();

        try (final Connection conn = DriverManager.getConnection(
                jdbcUrl, username, password);
             final PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                final Equipment equipment = Equipment.builder()
                        .id(resultSet.getString("id"))
                        .name(resultSet.getString("name"))
                        .temp(resultSet.getString("temperature"))
                        .clientName(clientName)
                        .build();
                equipmentReaders.add(equipment);
            }

        } catch (final SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return equipmentReaders;
    }
}

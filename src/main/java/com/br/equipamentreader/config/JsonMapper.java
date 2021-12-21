package com.br.equipamentreader.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class JsonMapper {

    @Bean
    public static ObjectMapper objectMapper() {

        final var dateTimeSerializerModule =
                new SimpleModule().addSerializer(LocalDateTime.class, new JsonSerializer<>() {
                    @Override
                    public void serialize(final LocalDateTime value,
                                          final JsonGenerator gen,
                                          final SerializerProvider serializers) throws IOException {
                        gen.writeString(value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
                    }
                });

        return new ObjectMapper()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .registerModule(new JavaTimeModule())
                .registerModule(dateTimeSerializerModule);
    }

}

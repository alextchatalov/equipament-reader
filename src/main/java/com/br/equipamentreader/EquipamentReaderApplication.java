package com.br.equipamentreader;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class EquipamentReaderApplication {
//implements CommandLineRunner
//    private final ReadFromDataBaseUseCase readFromDataBaseUseCase;

    public static void main(final String[] args) {
        SpringApplication.run(EquipamentReaderApplication.class, args);
    }

//    @Override
//    public void run(final String... args) {
//        readFromDataBaseUseCase.execute();
//    }

}

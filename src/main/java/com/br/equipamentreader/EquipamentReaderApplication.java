package com.br.equipamentreader;

import com.br.equipamentreader.core.usecase.ReadFromDataBaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class EquipamentReaderApplication implements CommandLineRunner {

	private final ReadFromDataBaseUseCase readFromDataBaseUseCase;

	public static void main(String[] args) {
		SpringApplication.run(EquipamentReaderApplication.class, args);
	}

	@Override
	public void run(String... args) {
		readFromDataBaseUseCase.execute();
	}

}

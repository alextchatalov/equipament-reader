package com.br.equipamentreader.core.job;

import com.br.equipamentreader.core.usecase.ReadFromDataBaseUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableScheduling
@RequiredArgsConstructor
public class ReadFromDatabaseJob {

    private final ReadFromDataBaseUseCase readFromDataBaseUseCase;

    @Scheduled(fixedDelay = 10000)
    private void run() {
        readFromDataBaseUseCase.execute();
    }
}

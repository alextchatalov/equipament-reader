package com.br.equipamentreader.core.job;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableScheduling
@AllArgsConstructor
public class ReadFromDatabaseJob {

    @Scheduled(fixedDelay = 500000)
    private void run() {

    }
}

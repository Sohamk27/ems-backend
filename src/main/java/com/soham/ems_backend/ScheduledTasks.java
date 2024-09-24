package com.soham.ems_backend;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class ScheduledTasks {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(cron = "*/5 * * * * *")
    @ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
    public void scheduleTaskWithCronExpression() {
        System.out.println("Cron Task :: Execution Time - " + dateTimeFormatter.format(LocalDateTime.now()));
    }
}

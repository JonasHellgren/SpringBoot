package org.example.scheduled1;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

//https://www.youtube.com/watch?v=92-qLIxv0JA

@SpringBootApplication
//@EnableScheduling
public class ScheduleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);
    }

    @Scheduled(initialDelay = 1000L, fixedRate = 1000L)
    void printJob() {
        System.out.println("Now is = " + new Date());
       // Thread.sleep(1000L);
    }

}


//makes it possible to disable with property
@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
class SchedulingConfiguration {

}
package org.example.scheduled2;

import jdk.jfr.Threshold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    public static final long CALLING_TIME = 500L;
    public static final long CALC_TIME = 2000L;
    @Autowired
    CalculationService calculationService;

    @Scheduled(initialDelay = CALLING_TIME, fixedRate = CALLING_TIME)
    public void calculate() throws InterruptedException {
        calculationService.setMode(Modes.CALCULATING);
        calculationService.doCalculation();
        Thread.sleep(CALC_TIME);
        calculationService.setMode(Modes.NOT_CALCULATING);
        System.out.println(calculationService.getResult());

    }
}

package org.example.scheduled2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    private Integer input;
    private Integer result;
    Modes mode;

    public CalculationService() {
        input=0;
    }

    public void doCalculation() {
        result=input*input;
    }

    public String getResult() {
        return "Input = "+input+", result = "+Math.pow(input,2);
    }

    public void setInput(Integer input) {
        this.input=input;
    }

    public void setMode(Modes mode) {
        this.mode=mode;
    }

    public Modes getMode() {
        return mode;
    }
}

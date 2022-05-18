package org.example.scheduled2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.logging.Logger;

//web browser: http://localhost:8080/result
//web browser: http://localhost:8080/mode
//postman: http://localhost:8080/input

@RestController
public class Controller {

    private static final Logger logger = Logger.getLogger(Controller.class.getName());

    @Autowired
    CalculationService calculationService;

    @GetMapping(value = "/result")
    public String getResult() {
        return calculationService.getResult();
    }

    @GetMapping(value = "/mode")
    public String getMode() {
        return calculationService.getMode().toString();
    }

    @PostMapping(path = "/input")
    public void postInput(@Valid @NonNull @RequestBody Integer input) {
        logger.info("postInput called, input ="+input);
        if (calculationService.getMode().equals(Modes.CALCULATING)) {
            logger.warning("Calculation in progress");
        }
        calculationService.setInput(input);
    }
}

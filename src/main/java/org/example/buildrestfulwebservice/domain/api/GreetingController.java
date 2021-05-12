package org.example.buildrestfulwebservice.domain.api;

import ch.qos.logback.classic.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.buildrestfulwebservice.domain.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
//This code uses Spring @RestController annotation, which marks the class as a controller where every
// method returns a domain object instead of a view. It is shorthand for including both
// @Controller and @ResponseBody.

//When running, paste following inte browser: http://localhost:8080/greeting?name=Jonas
public class GreetingController {
    private static Logger logger = LogManager.getLogger(GreetingController.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")   //HTTP GET requests to /greeting are mapped to the greeting() method
    //variable name below cant change name !!???
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        //The Greeting object must be converted to JSON. Thanks to Spring’s HTTP message converter
        // support, you need not do this conversion manually. Because Jackson 2 is on the
        // classpath, Spring’s MappingJackson2HttpMessageConverter is automatically chosen to
        // convert the Greeting instance to JSON.
        logger.info("Handling request");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
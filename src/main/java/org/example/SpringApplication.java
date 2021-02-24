package org.example;

import org.apache.logging.log4j.LogManager;
import org.example.domain.api.GreetingController;
import org.example.domain.service.GameDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);


    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);  }

        @Autowired
        GameDataService gameDataService;

        @Bean
        //The demo() method returns a CommandLineRunner bean that automatically runs the code when
        //the application launches
        public CommandLineRunner demo() {
            return (args) -> {


                // fetch all customers
                log.info("-------------------------------");
                //log.info(gameDataService.getGameSetup().toString());

            };
    }



}





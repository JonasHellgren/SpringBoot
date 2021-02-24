package org.example;

import org.example.domain.model.HumanMachinInterface;
import org.example.domain.service.GameDataService;
import org.example.domain.service.GameLogicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringMemoryGameApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringMemoryGameApplication.class);


    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringMemoryGameApplication.class, args);  }

        @Autowired
        GameDataService gameDataService;
        @Autowired
        GameLogicService gameLogicService;

        @Bean
        //The demo() method returns a CommandLineRunner bean that automatically runs the code when
        //the application launches
        public CommandLineRunner runGame() {
            return (args) -> {

                HumanMachinInterface hmi=gameDataService.humanMachinInterface;  //reference to save text

                log.info("Setting up data");
                gameDataService.getGameSetup().setnCols(hmi.readNcolOrNRows("Nof columns"));
                gameDataService.getGameSetup().setnRows(hmi.readNcolOrNRows("Nof rows"));
                gameDataService.getGameSetup().setCardsUsed();

                log.info("Here we go, lets play memory");

                do {  //this outer loop continuos as long as player wants to play
                    hmi.informPlayerSetup();   //inform player about card types of game
                    gameDataService.createPlayField();
                    gameDataService.gameStatus.resetFoundCards();
                    while (gameDataService.gameStatus.getNofCardsFound() < gameDataService.gameSetup.getNofCardsused()) {
                        gameDataService.humanMachinInterface.setHashCodeListForPlayerChosenPos(); //player input
                        gameDataService.showPlayfield();  //show player field
                        gameLogicService.updateStatus();  //update game status accordingly
                    }  //end of while
                hmi.informPlayerAfterGame();
                } while (gameDataService.humanMachinInterface.readnewgamePlayer());  //play again?

            };
    }



}





import org.example.memorygame.model.CardPos;
import org.example.memorygame.model.GameSetup;
import org.example.memorygame.model.GameStatus;
import org.example.memorygame.model.HumanMachinInterface;
import org.example.memorygame.service.GameDataService;
import org.example.memorygame.service.GameLogicService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={GameDataService.class,GameLogicService.class, GameSetup.class, GameStatus.class, HumanMachinInterface.class})
public class gamedatatest {
    private static final Logger logger = LoggerFactory.getLogger(gamedatatest.class);

    @Autowired
    GameDataService gameDataService;
    @Autowired
    GameLogicService gameLogicService;

    @Before
    public void init() {
        logger.info("Tests started");
        gameDataService.getGameSetup().setnCols(2);
        gameDataService.getGameSetup().setnRows(2);
        gameDataService.getGameSetup().setCardsUsed();
        gameDataService.createPlayField();
        //gameDataService.showPlayfield();
    }

    @Test
    public void printgetGameSetup() {
        System.out.println(gameDataService.getGameSetup());
        //Assert.assertTrue(keyStore.isInStore(Arrays.asList(2)));
    }


    @Test
    public void informPlayerSetup() {
        gameDataService.getHumanMachinInterface().informPlayerSetup();

    }

    @Test
    public void informPlayerAfterGame() {
        gameDataService.getHumanMachinInterface().informPlayerAfterGame();
    }

    @Test
    public void showPlayfield() {
        setHashCodesOfPlayerchosenPos();
        gameDataService.showPlayfield();

    }

    public void setHashCodesOfPlayerchosenPos() {
        CardPos pos = new CardPos();  //declaration
        List<Integer> hashCodeList = gameDataService.getGameStatus().getHashCodesOfPlayerchosenPos();  //declaration

        pos.setRiCi(1, 1);
        hashCodeList.add(gameDataService.getGameStatus().calcHashCodePos(pos));  //first
        pos.setRiCi(1, 2);
        hashCodeList.add(gameDataService.getGameStatus().calcHashCodePos(pos));   //second
    }

    @Test
    public void updateStatus() {
        setHashCodesOfPlayerchosenPos();
        gameLogicService.updateStatus();
        gameDataService.showPlayfield();
    }

}



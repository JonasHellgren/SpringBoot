import org.example.datatypes.Card;
import org.example.domain.model.CardPos;
import org.example.domain.model.GameSetup;
import org.example.domain.model.GameStatus;
import org.example.domain.service.GameDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={GameDataService.class, GameSetup.class, GameStatus.class})
public class gamedatatest {
    private static final Logger logger = LoggerFactory.getLogger(gamedatatest.class);

    @Autowired
    GameDataService gameDataService;

    @Before
    public void init() {
        logger.info("Tests started");
    }

    @Test
    public void printgetGameSetup() {
        System.out.println(gameDataService.getGameSetup());
        //Assert.assertTrue(keyStore.isInStore(Arrays.asList(2)));
    }

    @Test
    public void createPlayField() {
        gameDataService.createPlayField();

    }

    @Test
    public void showPlayfield() {
        gameDataService.informPlayerSetup();
        gameDataService.showPlayfield();

    //CardPos pos=new CardPos(1,1);
    //System.out.println(gameDataService.getGameStatus().getCardAtPos(pos));
}
}



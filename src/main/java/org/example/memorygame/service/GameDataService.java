package org.example.memorygame.service;


import org.example.memorygame.enums.Card;
import org.example.memorygame.model.CardPos;
import org.example.memorygame.model.GameSetup;
import org.example.memorygame.model.GameStatus;
import org.example.memorygame.model.HumanMachinInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service //beans with @Service to indicate that it's holding the business logic
public class GameDataService {
    //Service related to data management

    private static final Logger logger = LoggerFactory.getLogger(GameSetup.class);

    @Autowired
    public GameSetup gameSetup;
    @Autowired
    public GameStatus gameStatus;
    @Autowired
    public HumanMachinInterface humanMachinInterface;


    public GameDataService() {
        logger.info("GameDataService created");
    }

    public GameSetup getGameSetup() {
        return gameSetup;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public HumanMachinInterface getHumanMachinInterface() {
        return humanMachinInterface;
    }

    public void   createPlayField() {
        //This function fills playfield with random cards
        Set<Card> cardtypes;
        cardtypes = gameSetup.getCardsUsed();  //Set of card types
        List<Card> cards = new LinkedList<>();  //Set of cards used
        for (Card c : cardtypes) {  //create list with duplicate of every card types
            cards.add(c);     cards.add(c);
        }

        Random rand = new Random();
        Map<Integer, Card> playField = gameStatus.getPlayField(); //reference to variable playField
        CardPos pos=new CardPos();
        for (int ri = 1; ri <= gameSetup.getnRows(); ri++)  //ri corresponds to row
            for (int ci = 1; ci <= gameSetup.getnCols(); ci++)  //ci corresponds to column
            {
                int ridx = rand.nextInt(cards.size()); pos.setRiCi(ri,ci);
                gameStatus.placeCardAtPos(cards.get(ridx),pos);  //add card in playfield
                cards.remove(ridx);  //remove to not select again
            }
    }



    public void showPlayfield() {
        Map<Integer, Card> playField = gameStatus.getPlayField();
        Objects.requireNonNull(playField);  //easier debugging, throws up in the context of the object creation
        List<Integer> poskeylist = gameStatus.getHashCodesOfPlayerchosenPos();
        CardPos pos = new CardPos();
        Integer keypos;
        Card card;
        for (int ri = 1; ri <= gameSetup.getnRows(); ri++) { //ri corresponds to row
            for (int ci = 1; ci <= gameSetup.getnCols(); ci++)  //ci corresponds to column
            {
                pos.setRiCi(ri, ci);
                keypos = gameStatus.calcHashCodePos(pos);
                if (gameStatus.getCardAtPos(pos)==null)
                    logger.error("Error in showPlayfield. Key position not existing.");
                else {
                    card = gameStatus.getCardAtPos(pos);
                    if (gameSetup.alwaysShowCards || poskeylist.contains(keypos) || gameStatus.cardsFound.contains(card))
                        System.out.print(pos + ":" + gameStatus.getCardAtPos(pos) + "   ");
                    else
                        System.out.print("¤" + "   ");
                }
            }
            System.out.println();
        } //end of for ri
    }


}

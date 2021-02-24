package org.example.domain.model;

import org.example.domain.enums.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GameStatus {
    //Data container of variables changing during a game
    private static final Logger logger = LoggerFactory.getLogger(GameSetup.class);

    public Set<Card> cardsFound = new HashSet<>();  //the set of cards founds by the player
    private int nofMoves=0;  //nof game moves
    public List<Integer> hashCodesOfPlayerchosenPos =new ArrayList<>();  //hash numbers of chosen cards
    private Map<Integer, Card> playField = new HashMap<>();  // Creating HashMap for playfield
    @Autowired  //will make object search for gameSetup in spring container, search by type is default
    private GameSetup gameSetup;

    public GameStatus () {
        logger.info("GameStatus created");
    };  //constructor

    public int getNofCardsFound() {     return cardsFound.size();   }
    public List<Integer> getHashCodesOfPlayerchosenPos() {   return hashCodesOfPlayerchosenPos;   }
    public int getNofMoves() {     return nofMoves;   }
    public Map<Integer, Card> getPlayField() {      return playField;   }
    public void setNofMoves(int nofMoves) {     this.nofMoves = nofMoves;     }


    public Integer calcHashCodePos(CardPos pos) {
        return pos.getRi() * gameSetup.getnCols() + pos.getCi();
    }

    public Card getCardAtPos(CardPos pos) { //returns the card at position pos
        Integer hashCodePos=calcHashCodePos(pos);
        return playField.get(hashCodePos);
    }

    public void placeCardAtPos(Card card, CardPos pos) { //returns the card at position pos
        playField.put(calcHashCodePos(pos), card);  //add card in playfield
    }

    public void resetFoundCards() {
        cardsFound.clear();
    }



}

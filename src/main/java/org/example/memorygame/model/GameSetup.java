package org.example.memorygame.model;

import org.example.memorygame.enums.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import java.util.*;

@Component  //make the class available as bean in spring container
public class GameSetup {
    //Data container of parameters not changing during a game
    private static final Logger logger = LoggerFactory.getLogger(GameSetup.class);
    private Set<Card> cards = new HashSet<>();	//The cards available
    private int nRows;	//	Number of rows in play field
    private int nCols;	//	Number of columns in play field
    final public boolean alwaysShowCards=false;   //true <=>  show all cards

    GameSetup () {  //constructor
        this(2,3);
    };

    GameSetup (int nRows,int nCols) {  //constructor
        this.nRows=nRows;   this.nCols=nCols;
        setCardsUsed();
        logger.info("GameSetup created");
    };

    public void setCardsUsed() throws RuntimeException {
        //This method creates the set cards

        if (nRows * nCols % 2  != 0)  //set exception?
            throw new RuntimeException("Incorrect combination of nRows and nCols");

        SortedSet<Card> allct = new TreeSet<>();  //Gross set of cards
        Collections.addAll(allct, Card.values());

        cards.clear();
        for (int i = 0; i < nRows * nCols / 2; i++) {
            Card card = allct.first();        cards.add(card);
            allct.remove(card);  //remove from set so not added again to cardsUsed
        }
    }

    public void setnRows(int nRows) {
        this.nRows = nRows;
    }

    public void setnCols(int nCols) {
        this.nCols = nCols;
    }

    public int getnRows() {  return nRows;   }
    public int getnCols() {  return nCols;   }
    public Set<Card> getCardsUsed() {     return cards; }

    public Boolean nonfeasCardpos(CardPos pos) {
        Boolean anytosmall = (pos.getCi() < 1) || (pos.getRi() < 1);
        Boolean anytolarge = (pos.getCi() > getnCols()) || (pos.getRi() > getnRows());
        return (anytosmall || anytolarge);
    }

    public int getNofCardsused() {
        return cards.size();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(20);
        sb.append("nRows:");  sb.append(getnRows()); sb.append(", ");
        sb.append("nCols:");  sb.append(getnCols()); sb.append(", ");
        sb.append("cardsUsed:");
        for (Card card:getCardsUsed() )
            sb.append(card); sb.append(", ");
        return sb.toString();

    }

}




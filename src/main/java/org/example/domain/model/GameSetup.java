package org.example.domain.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.datatypes.Card;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.SortedSet; import java.util.TreeSet;

@Component  //make the class available as bean in spring container
public class GameSetup {
    private static final Logger logger = LoggerFactory.getLogger(GameSetup.class);
    private SortedSet<Card> cardsUsed = new TreeSet<>();	//The cards used, subset of cardTypes according to play field size
    private int nRows;	//	Number of rows of play field
    private int nCols;	//	Number of columns of play field
    final public boolean alwaysShowCards=false;   //true <=> always show cards

    GameSetup () {  //constructor
        this(2,3);
    };

    GameSetup (int nRows,int nCols) {  //constructor
        this.nRows=nRows;   this.nCols=nCols;
        setCardsUsed();
        logger.info("GameSetup created");
    };

    public void setCardsUsed() throws RuntimeException {
        //This method creates set cardsUsed of type enum Card

        if (nRows * nCols % 2  != 0)  //set exception?
            throw new RuntimeException("Incorrect combination of nRows and nCols");

        SortedSet<Card> allct = new TreeSet<>();  //Gross set of cards
        Collections.addAll(allct, Card.values());

        cardsUsed.clear();
        for (int i = 0; i < nRows * nCols / 2; i++) {
            Card card = allct.first();        cardsUsed.add(card);
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
    public SortedSet<Card> getCardsUsed() {     return cardsUsed; }

    public Boolean nonfeasCardpos(CardPos pos) {
        Boolean anytosmall = (pos.getCi() < 1) || (pos.getRi() < 1);
        Boolean anytolarge = (pos.getCi() > getnCols()) || (pos.getRi() > getnRows());
        return (anytosmall || anytolarge);
    }

    public int getNofCardsused() {
        return cardsUsed.size();
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




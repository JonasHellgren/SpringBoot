package org.example.domain.service;


import java.util.*;

public class GameLogicService {
   //This class contains setup and status classes


    public GameLogicService() {  //Constructor
       // createPlayField();   //the functions fills the variable playField located in status
    }
/*
    public void updateStatus()  {  //This functions updates status according to player input
       status.setNofMoves(status.getNofMoves()+1);
       List<Integer>  poskeylist=status.getKeysofPlayerchosenPos();
       Set<Integer> set = new HashSet<>(poskeylist);  //to check if duplicates in list
       Map<Integer, Card> playField=status.getPlayField(); //reference to variable playField

       //nothing happens if same card (position) chosen twice
        if(set.size() == poskeylist.size()){  //There are position duplicates, i.e. not same card taken
            Card c1=playField.get(poskeylist.get(0));
            Card c2=playField.get(poskeylist.get(1));
            if (c1.equals(c2)) {    status.foundCards.add(c1);   }
        }
    }

        public void   createPlayField() { //This function fills playfield with random cards
            SortedSet<Card> cardtypes;
            cardtypes = setup.getCardsUsed();  //Set of card types
            List<Card> cards = new LinkedList<>();  //Set of cards used
            for (Card c : cardtypes) {  //create list with duplicate of every card types
                cards.add(c);     cards.add(c);
            }

            Random rand = new Random();
            Map<Integer, Card> playField = status.getPlayField(); //reference to variable playField
            CardPos pos=new CardPos();
            for (int ri = 1; ri <= setup.getnRows(); ri++)  //ri corresponds to row
                for (int ci = 1; ci <= setup.getnCols(); ci++)  //ci corresponds to column
                {
                    int ridx = rand.nextInt(cards.size()); pos.setRiCi(ri,ci);
                    playField.put(getKeypos(pos), cards.get(ridx));  //add card in playfield
                    cards.remove(ridx);  //remove to not select again
                }
        }

    public static int getKeypos(CardPos pos) {  //static <=> can be accessed without class creation (new)
        return pos.getRi() * setup.getnCols() + pos.getCi(); }

    public int getNofCardsused() {  //return the number of card types used
        SortedSet<Card> cardsUsed =  setup.getCardsUsed(); return cardsUsed.size();
    }

 */

}



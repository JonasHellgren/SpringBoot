package org.example.memorygame.service;


import org.example.memorygame.enums.Card;
import org.example.memorygame.model.GameStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service //beans with @Service to indicate that it's holding the business logic
public class GameLogicService {
    //Service related game logic, i.e. how game is updated
   private static final Logger log = LoggerFactory.getLogger(GameLogicService.class);

    @Autowired
    public GameStatus gameStatus;

    public GameLogicService() {     }

    public void updateStatus()  {  //This functions updates status according to player input
       gameStatus.setNofMoves(gameStatus.getNofMoves()+1);
       List<Integer>  posHashList=gameStatus.getHashCodesOfPlayerchosenPos();
       Set<Integer> set = new HashSet<>(posHashList);  //to check if duplicates in list
       Map<Integer, Card> playField=gameStatus.getPlayField(); //reference to variable playField

       //nothing happens if same card (position) chosen twice
        if(set.size() == posHashList.size()){  //There are position duplicates, i.e. not same card taken
            Card c1=playField.get(posHashList.get(0));
            Card c2=playField.get(posHashList.get(1));
            if (c1.equals(c2)) {    gameStatus.cardsFound.add(c1);   }
        }
    }
}



package org.example.domain.service;


import org.example.domain.enums.Card;
import org.example.domain.model.GameStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service //beans with @Service to indicate that it's holding the business logic
public class GameLogicService {
   //This service contains logic for game updating
   private static final Logger log = LoggerFactory.getLogger(GameLogicService.class);

    @Autowired
    public GameStatus gameStatus;


    public GameLogicService() {  //Constructor
     }

    public void updateStatus()  {  //This functions updates status according to player input
       gameStatus.setNofMoves(gameStatus.getNofMoves()+1);
       List<Integer>  posHashList=gameStatus.getHashCodesOfPlayerchosenPos();
       Set<Integer> set = new HashSet<>(posHashList);  //to check if duplicates in list
       Map<Integer, Card> playField=gameStatus.getPlayField(); //reference to variable playField

        log.debug("posHashList:"+posHashList);
       //nothing happens if same card (position) chosen twice
        if(set.size() == posHashList.size()){  //There are position duplicates, i.e. not same card taken
            Card c1=playField.get(posHashList.get(0));
            Card c2=playField.get(posHashList.get(1));
            log.debug("c1:"+c1+", c2:"+c2);
            if (c1.equals(c2)) {    gameStatus.foundCards.add(c1);   }
        }
    }

}



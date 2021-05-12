package org.example.memorygame.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class HumanMachinInterface {
    //Handles all player interaction, for example chosen cards
    private final Scanner input = new Scanner(System.in);  //player input object

    @Autowired  //will make object search for gameSetup in spring container, search by type is default
    private GameSetup gameSetup;

    @Autowired
    private GameStatus gameStatus;

    public int readNcolOrNRows(String instructionText) {
        //This method returns True if player wants to play new game

        int inputNr;
        do {
            System.out.print(instructionText + ":");
            inputNr = input.nextInt();  //read  from player
        } while (inputNr < 1 | inputNr > 10);

        return inputNr;
    }

    public Boolean readnewgamePlayer() {
        //This method returns True if player wants to play new game
        System.out.print("New game [y/n]:");
        String newgamestring = input.next();  //read  from player
        return newgamestring.equals("y");
    }

    public void informPlayerSetup() {
        //inform player about card types of game
        gameSetup.setCardsUsed();
        System.out.println("The type of cards in the game are:" + gameSetup.getCardsUsed());
    }

    public void informPlayerAfterGame() {
        System.out.println("You made the game in:" + gameStatus.getNofMoves() + " moves");
    }

    public void setHashCodeListForPlayerChosenPos() {
        //This function calls readCardPos and sets the variable hashCodesOfPlayerchosenPos,
        // located in class gameStatus
        CardPos pos;  //declaration
        List<Integer> hashCodeList = gameStatus.getHashCodesOfPlayerchosenPos();  //reference

        hashCodeList.clear();
        pos = readCardPos("first");
        hashCodeList.add(gameStatus.calcHashCodePos(pos));
        pos = readCardPos("second");
        hashCodeList.add(gameStatus.calcHashCodePos(pos));
    }

    public CardPos readCardPos(String cardnrtxt) {
        //This function reads positions of player selected cards, checks that positions are feasible.
        int ri, ci;
        CardPos pos = new CardPos();
        do {
            System.out.print("Row of " + cardnrtxt + " card:");
            ri = input.nextInt();  //read  from player
            System.out.print("Column " + cardnrtxt + "card:");
            ci = input.nextInt();  //read  from player
            pos.setRiCi(ri, ci);
            if (gameSetup.nonfeasCardpos(pos))
                System.out.println("Wrong card position input. You need to rewrite");
        }
        while (gameSetup.nonfeasCardpos(pos));
        return pos;
    }

}

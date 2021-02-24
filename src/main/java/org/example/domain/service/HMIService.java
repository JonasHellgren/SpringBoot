package org.example.domain.service;



import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

//all user interaction is managed by this class
public class HMIService implements HMI { //This class is the interpretor between player and game
    private Scanner input = new Scanner(System.in);    //input variable

    public HMIService() {  //constructor
          }

   /*
    public Boolean readnewgamePlayer() {  //This method returns True if player wants to play new game
        System.out.print("New game [y/n]:");
        String newgamestring = input.next();  //read  from player
        return newgamestring.equals("y");
    }
    public void informPlayerSetup(GameSetup setup) {  //inform player about card types of game
        setup.setCardsUsed();
        System.out.println("The type of cards in the game are:"+setup.getCardsUsed());
    }
    public void informPlayerAfterGame(GameStatus status) {
        System.out.println("You made the game in:"+status.getNofMoves()+" moves");
    }
    public void showPlayfield(GameStatus status, GameSetup setup) {
        Map<Integer, Card> playField = status.getPlayField();
        Objects.requireNonNull(playField);  //easier debugging, throw up in the context of the object creation
        List<Integer>  poskeylist=status.getKeysofPlayerchosenPos();
        CardPos pos = new CardPos();
        Integer keypos;
        Card card;
        for (int ri = 1; ri <= setup.getnRows(); ri++) { //ri corresponds to row
            for (int ci = 1; ci <= setup.getnCols(); ci++)  //ci corresponds to column
            {
                pos.setRiCi(ri, ci);
                keypos = GameLogicService.getKeypos(pos); //call static function in super class
                card = status.getCardAtPos(pos);
                if (poskeylist.contains(keypos) || status.foundCards.contains(card))
                    System.out.print(status.getCardAtPos(pos) + "   ");
                else
                    System.out.print("¤" + "   ");
            }
            System.out.println();
        } //end of for ri
    }

    public Boolean nonfeasCardpos(CardPos pos, GameSetup setup) {
        Boolean anytosmall = (pos.getCi() < 1) || (pos.getRi() < 1);
        Boolean anytolarge = (pos.getCi() > setup.getnCols()) || (pos.getRi() > setup.getnRows());
        return (anytosmall || anytolarge);
    }
    public CardPos readCardPos(GameSetup setup, String cardnrtxt) {
        //This function reads positions of player selected cards, checks positions are feasible.
        int ri, ci;        CardPos pos = new CardPos();
        do {
            System.out.print("Row of " + cardnrtxt + " card:");
            ri = input.nextInt();  //read  from player
            System.out.print("Column " + cardnrtxt + "card:");
            ci = input.nextInt();  //read  from player
            pos.setRi(ri);     pos.setCi(ci);
            if (nonfeasCardpos(pos, setup))
                System.out.println("Wrong card position input. You need to rewrite");
        }
        while (nonfeasCardpos(pos, setup));
        return pos;
    }
    public void setKeysofPlayerchosenPos(GameStatus status, GameSetup setup) {
        //This function calls readCardPos and sets the variable KeysofPlayerchosenPos,
        // located in class variable status
        CardPos pos;  //declaration
        List<Integer>  poskeylist=status.getKeysofPlayerchosenPos();  //declaration

        poskeylist.clear();
        pos = readCardPos(setup, "first");  poskeylist.add(GameLogicService.getKeypos(pos));
        pos = readCardPos(setup, "second"); poskeylist.add(GameLogicService.getKeypos(pos));
    }


    */
}



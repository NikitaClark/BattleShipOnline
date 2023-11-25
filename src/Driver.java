package cs3500.pa03;


import static cs3500.pa03.BoardDisplayWhat.SuccessfullShots;
import static cs3500.pa03.BoardDisplayWhat.coord;
import static cs3500.pa03.BoardDisplayWhat.firstQHOperator;
import static cs3500.pa03.BoardDisplayWhat.firstQHScanOperator;
//import static cs3500.pa03.BoardDisplayWhat.greedAiSizePass;
import static cs3500.pa03.BoardDisplayWhat.greedAiSizePass;
import static cs3500.pa03.BoardDisplayWhat.holdToCount;
import static cs3500.pa03.BoardDisplayWhat.numberOfShipsOnBoard;
import static cs3500.pa03.BoardDisplayWhat.numberOfShipsSunk;
import static cs3500.pa03.BoardDisplayWhat.savedShipChoices;
import static cs3500.pa03.BoardDisplayWhat.secondQHOperator;
import static cs3500.pa03.BoardDisplayWhat.secondQHScanOperator;
//import static cs3500.pa03.BoardDisplayWhat.greedAiSizePass;
import static cs3500.pa03.BoardDisplayWhat.greedSizePass;

import static cs3500.pa03.BoardDisplayWhat.spacer;
import static cs3500.pa03.BoardDisplayWhat.thirdQHOperator;
import static cs3500.pa03.BoardDisplayWhat.thirdQHScanOperator;



import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * This is the main driver of this project.
 */
public class Driver extends PlayerAbstract {
  private static int savedInput;
  /**
   * Project entry point
   *
   * @param args - no command line args required
   *
   */

  public static void main(String[] args) {
    try {
   //First question with welcome massage displayed
       firstQHOperator();

   //Board size parameter holder
      List<Integer> boardSize = firstQHScanOperator();

   // Second question text output
      secondQHOperator();

      // Second question scanner
      secondQHScanOperator();

      // Ship choices parameter holder
     Map<ShipType, Integer> ShipChoices = savedShipChoices;


      // Displays AI board
      greedAiSizePass(boardSize, ShipChoices);

      // Created a space
      spacer();

      // Displays player board
      greedSizePass(boardSize, ShipChoices);

      // Created a space
      spacer();

     // Asks the third question
     thirdQHOperator();

     //System.out.println(numberOfShipsSunk());

      // Holds the places where shots will be taking places
     thirdQHScanOperator(numberOfShipsSunk(), numberOfShipsOnBoard());

     // Returns a list of all shots

    List<Coord> holdShots = coord();

      for (Coord shot : holdShots) {
        System.out.println("Shot coordinates: (" + shot.getCol()  + ", " + shot.getRow() + ")");
      }

      SuccessfullShots(holdShots, holdToCount);

      SuccessfullShots(holdShots, holdToCount);









     // Shots Scanner
     ///Integer[][] shootsCord =  savedShotCoord;



    } catch (Exception e) {
      System.out.println("We encountered an unexpected error");
    }
  }




  /**
   * Get the player's name.
   * NOTE: This may not be important to your implementation for PA03, but it will be later
   *
   * @return the player's name
   */
  @Override
  public String name() {
    return null;
  }
}
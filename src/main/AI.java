package cs3500.pa03;

import static cs3500.pa03.ShipType.BATTLESHIP;
import static cs3500.pa03.ShipType.CARRIER;
import static cs3500.pa03.ShipType.DESTROYER;
import static cs3500.pa03.ShipType.SUBMARINE;

import java.util.*;

public class AI extends PlayerAbstract {
  public static int heightAI;
  public static int widthAI;


  public List<Ship> forBoardSetUpCaller(int height, int width, Map<ShipType, Integer> specifications) {
    heightAI = height;
    widthAI = width;
    return setup(height, width, specifications);


  }

// will be putting ships on our actual display board

  char[][] initializeGrid(int height, int width) {
    char[][] grid = new char[height][width];
    for (int i = 0; i < height; i++) {
      Arrays.fill(grid[i], ' ');
    }
    return grid;
  }

  public void displayShipLocations(List<Ship> ships, boolean opponent) {
    char[][] grid = initializeGrid(heightAI, widthAI);

    if (!opponent) {
      for (Ship ship : ships) {
        int startRow = ship.getStartRow();
        int startCol = ship.getStartCol();
        int shipLength = ship.getLength();
        int direction = ship.getDirection();
        char symbol;

        if (ship.getType().equals(CARRIER)) {
          symbol = 'C';
        } else if (ship.getType().equals(BATTLESHIP)) {
          symbol = 'B';
        } else if (ship.getType().equals(DESTROYER)) {
          symbol = 'D';
        } else if (ship.getType().equals(SUBMARINE)) {
          symbol = 'S';
        } else {
          continue; // Skip invalid ship types
        }

        boolean isSunk = ship.isSunk();

        for (int i = 0; i < shipLength; i++) {
          if (direction == 0) {
            grid[startCol][startRow + i] = isSunk ? '!' : symbol; // Place ship's segments horizontally on the grid and change to '!' if sunk
          } else {
            grid[startCol + i][startRow] = isSunk ? '!' : symbol; // Place ship's segments vertically on the grid and change to '!' if sunk
          }
        }
      }
    }




    // Display the grid with ship locations
    for (char[] row : grid) {
      System.out.println(Arrays.toString(row));
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

  /**
   * Returns this player's shots on the opponent's board. The number of shots returned should
   * equal the number of ships on this player's board that have not sunk.
   */
  @Override
  public List<Coord> takeShots() {
    return null;
  }

  /**
   * Returns this player's shots on the opponent's board. The number of shots returned should
   * equal the number of ships on this player's board that have not sunk.
   */

}






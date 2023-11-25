package cs3500.pa03;


import static cs3500.pa03.BoardDisplayWhat.shotCoord;
import static cs3500.pa03.ShipType.BATTLESHIP;
import static cs3500.pa03.ShipType.CARRIER;
import static cs3500.pa03.ShipType.DESTROYER;
import static cs3500.pa03.ShipType.SUBMARINE;

import java.util.*;

// Represents a single player in a game of BattleSalvo.
abstract class PlayerAbstract implements Player {


  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    char[][] grid = initializeGrid(height, width); // Create grid
    List<Ship> ships = new ArrayList<>();

    for (Map.Entry<ShipType, Integer> entry : specifications.entrySet()) {
      // Take out the ship type
      ShipType shipType = entry.getKey();
      // Takes out the number of them
      int shipCount = entry.getValue();

      // for the number of that ship type, iterates over each of them.
      for (int i = 0; i < shipCount; i++) {
        Ship ship = createShip(shipType, height, width, grid);
        placeShip(grid, ship);
        ships.add(ship);
      }
    }

    return ships;

  }



  private char[][] initializeGrid(int height, int width) {
    char[][] grid = new char[height][width];
    for (int i = 0; i < height; i++) {
      Arrays.fill(grid[i], ' ');
    }
    return grid;
  }


  private void placeShip(char[][] grid, Ship ship) {
    int startY = ship.getStartCol(); // Start position for placing the ship horizontally
    int startX = ship.getStartRow();
    int shipLength = ship.getLength();
    int direction = ship.getDirection();
    String type;

    if (ship.getType().equals(CARRIER)) {
      type = "C";
    } else if (ship.getType().equals(BATTLESHIP)) {
      type = "B";
    } else if (ship.getType().equals(DESTROYER)) {
      type = "D";
    } else if (ship.getType().equals(SUBMARINE)) {
      type = "S";
    } else {
      System.out.println("ship placement error");
      return; // Return if ship type is invalid
    }

    // Check if the ship goes overboard horizontally
    if (startX + shipLength > grid[0].length) {
      return;
    }

    // Check if the ship goes overboard vertically
    if (startY + shipLength > grid.length) {
      return;
    }

    // Check if the ship overlaps with another ship
    for (int i = 0; i < shipLength; i++) {
      if (direction == 0 && grid[startY][startX + i] != ' ') {
        return;
      } else if (direction == 1 && grid[startY + i][startX] != ' ') {
        return;
      }
    }

    // Place the ship on the grid
    for (int i = 0; i < shipLength; i++) {
      if (direction == 0) {
        grid[startY][startX + i] = type.charAt(0); // Place ship's segments horizontally on the grid
      } else {
        grid[startY + i][startX] = type.charAt(0); // Place ship's segments vertically on the grid
      }
    }

    ship.setStartRow(startY); // Update the ship's start row
    ship.setStartCol(startX); // Update the ship's start column
  }

  protected Ship createShip(ShipType shipType, int height, int width, char[][] grid) {
    // Generate random starting coordinates and direction
    Random random = new Random();
    int shipLength = shipType.getLength();
    boolean isSunk = false;

    // Loop until a valid placement is found
    while (true) {
      int startRow = random.nextInt(height);
      int startCol = random.nextInt(width);
      int direction = random.nextInt(2); // 0 for horizontal, 1 for vertical

      // Check if the ship goes overboard horizontally
      if (startCol + shipLength <= width) {
        // Check if the ship goes overboard vertically
        if (startRow + shipLength <= height) {
          // Check if the placement overlaps with another ship
          boolean isValidPlacement = true;
          for (int i = 0; i < shipLength; i++) {
            if (direction == 0 && grid[startRow][startCol + i] != ' ') {
              isValidPlacement = false;
              break;
            } else if (direction == 1 && grid[startRow + i][startCol] != ' ') {
              isValidPlacement = false;
              break;
            }
          }

          if (isValidPlacement) {
            // Create the ship with the generated parameters and return it
            return new Ship(shipType, shipLength, startRow, startCol, direction, isSunk);
          }
        }
      }
    }
  }



   public void successfulHits(List<Coord> holdShots) {

    }






  public List<Coord> takeShots() {
    return shotCoord;
  }


}

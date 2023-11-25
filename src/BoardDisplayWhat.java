package cs3500.pa03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BoardDisplayWhat extends PlayerAbstract {

  public static int firstQHScan;
  public static int firstQWScan;
  static BoardView classDisplay = new BoardView();
  static AI aiClass = new AI();

  static HolderForShoots holdShots = new HolderForShoots();

  static List<Ship> holdToCount;

  static List<Ship> holdToCountAi;

  static List<Coord> shotCoord;



  private static Scanner scanner = new Scanner(System.in);

  //static List <Integer> boardSize = firstQHScanOperator();

  public Map<ShipType, Integer> secondQScan;

  static Map<ShipType, Integer> savedShipChoices;

  /*

    public String name;
    public GameResult result;
    public String reason;

    public BoardDisplayWhat(int firstQHScan, int firstQWScan, Map<ShipType, Integer> secondQScan
                            String name, GameResult result, String reason, Scanner scanner) {
      this.firstQHScan = firstQHScan;
      this.firstQWScan = firstQWScan;
      this.secondQScan = secondQScan;

      this.name = name;
      this.result = result;
      this.reason = reason;

    }
    public static List<Integer> getBoardSize() {
      return boardSize;
    } */
  public static void firstQHOperator() {
    classDisplay.displayWelcome();
    classDisplay.display1stQ();
  }

  public static List<Integer> firstQHScanOperator() {
    List<Integer> boardSize = new ArrayList<>(2);

    boolean responseValid = false;
    while (!responseValid) {
      scanner = new Scanner(System.in);
      while (!(boardSize.size() == 2)) {
        for (int i = 0; i <= 1; i++) {
          int input = scanner.nextInt();
          boardSize.add(input);
        }

      }
      int elementFirst = boardSize.get(0);
      int elementSecond = boardSize.get(1);

      if (elementFirst < 6 || elementFirst > 15 || elementSecond < 6 || elementSecond > 15) {
        classDisplay.displayWrong1stQ();
        boardSize.clear();
      } else {
        responseValid = true;
      }
    }

    return boardSize;
  }

  public static void secondQHOperator() {
    classDisplay.displayFleetQ();
  }

  public static Map<ShipType, Integer> secondQHScanOperator() {
    Map<ShipType, Integer> fleetSize = new HashMap<>();

    boolean fleetValid = false;
    while (!fleetValid) {
      scanner = new Scanner(System.in);
      int input = scanner.nextInt();
      while (!(fleetSize.size() == 4)) {
        for (ShipType shipType : ShipType.values()) {
          fleetSize.put(shipType, input);
        }

      }
      int sum = 0;
      for (int size : fleetSize.values()) {
        sum = size + sum;
      }
      if (fleetSize.containsValue(0) || sum > 8) {
        classDisplay.displayFleetQWrong();
        fleetSize.clear();
      } else {
        fleetValid = true;
      }
    }
    savedShipChoices = fleetSize;
    return fleetSize;

  }


  public static void greedAiSizePass(List<Integer> boardSize, Map<ShipType, Integer> shipsSelection) {
    int width = boardSize.get(0);
    int height = boardSize.get(1);

    List<Ship> hold = aiClass.forBoardSetUpCaller(height, width, shipsSelection);

    holdToCount = hold;

    //System.out.println(hold);

    classDisplay.aiBoard();

    aiClass.displayShipLocations(hold, false);

  }

  public static void greedSizePass(List<Integer> boardSize,
                                     Map<ShipType, Integer> shipsSelection) {
    int width = boardSize.get(0);
    int height = boardSize.get(1);

    List<Ship> hold = aiClass.forBoardSetUpCaller(height, width, shipsSelection);

    holdToCountAi = hold;
    //System.out.println(hold);

    classDisplay.playerBoard();

    aiClass.displayShipLocations(hold, true);

    System.out.println(holdToCount);

  }

  public static void spacer() {
    classDisplay.spacer();
  }

  public static void thirdQHOperator() {
    classDisplay.displayShotsQ();
  }


  public static void thirdQHScanOperator(int shipsSunk, int totalShip) {
    totalShip = totalShip - shipsSunk;
    List<Coord> shotCoords = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < totalShip; i++) {
      int column = scanner.nextInt();
      int row = scanner.nextInt();
      Coord coord = new Coord(row, column);
      shotCoords.add(coord);
    }
    shotCoord = shotCoords;
    scanner.close();
  }

 /* public static void aiTakeShots(int shipsSunk, int totalShip, char[][] opponentGrid) {
    int remainingShips = totalShip - shipsSunk;
    List<Coord> shotCoords = new ArrayList<>();
    <Coord> shotSet = new HashSet<>(); // To store already shot coordinates

    Scanner scanner = new Scanner(System.in);

    for (int i = 0; i < remainingShips; i++) {
      System.out.print("Enter column: ");
      int column = scanner.nextInt();

      System.out.print("Enter row: ");
      int row = scanner.nextInt();

      Coord coord = new Coord(row, column);

      if (isValidShot(coord, opponentGrid) && !shotSet.contains(coord)) {
        shotCoords.add(coord);
        shotSet.add(coord);
      } else {
        System.out.println("Invalid shot! Try again.");
        i--; // Retry for an invalid shot
      }
    }

    // Use shotCoords for further processing
    // ...

    scanner.close();
  }
*/





  static int numberOfShipsSunk() {
    int i = 0;
    for (Ship ship : holdToCount) {
      if (ship.isSunk) {
        i = i + 1;
      }
    }
    return i;
  }

  static int numberOfShipsOnBoard() {
    int b = 0;
    for (Ship ship : holdToCount) {
      b = b + 1;

    }
    return b;
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



  public static List<Coord> coord() {
    return holdShots.coordsCall();
  }





  public static void SuccessfullShots(List<Coord> holdShots, List<Ship> holdShipsCurrentLocation) {
   for (Coord shot : holdShots) {
      for (Ship ship : holdShipsCurrentLocation) {
        if (isCoordOnShip(shot, ship)) {
          ship.setSunk(true);
       }
      }
    }
    System.out.println(holdToCount);
    aiClass.displayShipLocations(holdToCount, false);

  }

  private static boolean isCoordOnShip(Coord shot, Ship ship) {
    if (ship.getDirection() == 0) { // Horizontal ship
      if (shot.getRow() == ship.getStartRow() && shot.getCol() >= ship.getStartCol() && shot.getCol() < ship.getStartCol() + ship.getLength()) {
        return true;
      }
    } else { // Vertical ship
      if (shot.getCol() == ship.getStartCol() && shot.getRow() >= ship.getStartRow() && shot.getRow() < ship.getStartRow() + ship.getLength()) {
        return true;
      }
    }
    return false;
  }


}






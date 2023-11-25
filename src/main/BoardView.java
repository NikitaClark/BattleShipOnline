package cs3500.pa03;

public class BoardView {
  public void displayGrid(char[][] grid, int height, int width) {
    System.out.println("Your Board: ");

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        System.out.print(grid[row][col] + " ");
      }
      System.out.println();
    }
  }

  public void displayWelcome() {
    System.out.println("Hello. Welcome to the OOD BattleSalvo Game. ");
  }

  public void display1stQ() {
    System.out.println("Enter a valid height and width below:\n" +
        "------------------------------------------------------");
  }

  public void spacer() {
    System.out.println(" ");
  }

  public void displayWrong1stQ() {
    System.out.println("You've entered invalid dimensions. Remember that the height and width\n" +
        "of the game must be in the range (6, 10), inclusive. Try again.\n" +
        "------------------------------------------------------ \n"
    );
  }

  public void displayFleetQ() {
    System.out.println(
        "Enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].\n" +
            "Remember, your fleet may not exceed size 8.\n" +
            "--------------------------------------------------------------------------------\n"
    );
  }

  public void displayFleetQWrong() {
    System.out.println(
        "--------------------------------------------------------------------------------\n" +
            "You've entered invalid fleet sizes.\n" +
            "Enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].\n" +
            "Remember, your fleet may not exceed size 8.\n" +
            "--------------------------------------------------------------------------------");
  }

  public void displayShotsQ() {
    System.out.println("Please Enter 8 Shots:\n" +
        "------------------------------------------------------------------");
  }

  public void playerBoard() {
    System.out.println("Player's Board");
  }

  public void aiBoard() {
    System.out.println("Opponent's Board");
  }


}



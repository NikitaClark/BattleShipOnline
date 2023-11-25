package cs3500.pa03;

import java.util.ArrayList;
import java.util.List;


class Coord {
  private int row;
  private int col;

  public Coord(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }
/*
  public List<Coord> takeShots() {
    List<Coord> shots = new ArrayList<>();
    // Implement your logic to generate shots here
    // You can modify this method according to your requirements

    // Example: Generate random shots within the grid
    for (int i = 0; i < 5; i++) {
      int row = (int) (Math.random() * rows);
      int col = (int) (Math.random() * cols);
      shots.add(new Coord(row, col));
    }

    return shots;
  }*/
}

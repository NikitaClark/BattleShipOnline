package cs3500.pa03;

class Ship {
  private ShipType type;
  private int length;
  private int startRow;
  private int startCol;
  private int direction; // 0 - horizontal, 1 - vertical
  boolean isSunk;

  public Ship(ShipType type, int length, int startRow, int startCol, int direction, boolean isSunk) {
    this.type = type;
    this.length = length;
    this.startRow = startRow;
    this.startCol = startCol;
    this.direction = direction;
    this.isSunk = isSunk;
  }

  public int getLength() {
    return length;
  }
  public ShipType getType() {
    return type;
  }

  public void setStartRow(int startRow) {
    this.startRow = startRow;
  }
  public void setStartCol(int startCol) {
    this.startCol = startCol;
  }
  public int getStartRow() {
    return startRow;
  }
  public int getStartCol() {
    return startCol;
  }

  public int getDirection() {
    return direction;
  }
  @Override
  public String toString() {
    return "Ship{" +
        "type=" + type +
        ", length=" + length +
        ", startRow=" + startRow +
        ", startCol=" + startCol +
        ", direction=" + direction +
        ", isSunk=" + isSunk +
        '}';
  }
  public void setSunk(boolean sunk) {
    isSunk = sunk;
  }
  public boolean isSunk() {
    return isSunk;
  }
}

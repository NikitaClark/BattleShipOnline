package cs3500.pa03;

public enum ShipType {
  CARRIER {
    @Override
    public int getLength() {
      return 6;
    }
  },
  BATTLESHIP {
    @Override
    public int getLength() {
      return 5;
    }
  },
  DESTROYER {
    @Override
    public int getLength() {
      return 4;
    }
  },
  SUBMARINE {
    @Override
    public int getLength() {
      return 3;
    }
  };

  public abstract int getLength();
}

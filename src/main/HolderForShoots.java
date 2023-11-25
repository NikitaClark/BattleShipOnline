package cs3500.pa03;

import java.util.List;
import java.util.Map;

public class HolderForShoots extends PlayerAbstract {

  public List<Coord> coordsCall() {

    return takeShots();


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
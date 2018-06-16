package Projekt1.Logic.Interfaces;

import Projekt1.Entities.Map;
import Projekt1.Entities.Ship;

public interface PersistenceService
{
    IActionResult saveMap(Map map);
    IActionResult saveShip(Ship ship);
    Map loadMap();
    Ship loadShip();
}

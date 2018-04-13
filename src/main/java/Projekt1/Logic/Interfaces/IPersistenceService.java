package Projekt1.Logic.Interfaces;

import Projekt1.Entities.Map;
import Projekt1.Entities.Ship;

public interface IPersistenceService
{
    IActionResult saveMap(Map map);
    IActionResult saveShip(Ship ship);
    Map loadMap();
    Ship loadShip();
}

package Projekt1.Logic.Interfaces;

import Projekt1.Entities.Map;
import Projekt1.Entities.Ship;

public interface PersistenceService
{
    ActionResult saveMap(Map map);
    ActionResult saveShip(Ship ship);
    Map loadMap();
    Ship loadShip();
}

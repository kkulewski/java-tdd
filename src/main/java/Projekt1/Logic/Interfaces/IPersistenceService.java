package Projekt1.Logic.Interfaces;

import Projekt1.Entities.Map;
import Projekt1.Entities.Ship;

public interface IPersistenceService
{
    public IActionResult saveMap(Map map);
    public IActionResult saveShip(Ship ship);
    public Ship loadShip();
}

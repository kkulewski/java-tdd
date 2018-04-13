package Projekt1.Logic.Interfaces;

public interface IMoveProcessor
{
    IActionResult turnRight();
    IActionResult turnLeft();
    IActionResult moveForward();
    IActionResult moveBack();
    IActionResult shoot();
}
